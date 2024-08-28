import com.project.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private Folder rootFolder;
    private Folder subFolder;
    private File file;
    private Permission readPermission;
    private Permission adminPermission;

    @BeforeEach
    void setUp() {
        user = new User(1, "user@example.com");
        rootFolder = new Folder(1, "Root Folder");
        subFolder = new Folder(2, "Sub Folder");
        file = new File(3, "File");

        readPermission = new Permission(rootFolder, user, PermissionType.READ);
        adminPermission = new Permission(subFolder, user, PermissionType.ADMIN);

        user.addPermission(readPermission);
        user.addPermission(adminPermission);

        rootFolder.addChild(subFolder);
        subFolder.addChild(file);
    }

    @Test
    void testUserCanReadRootFolder() {
        assertTrue(user.hasPermission(rootFolder, PermissionType.READ));
    }

    @Test
    void testUserCanAdminSubFolder() {
        assertTrue(user.hasPermission(subFolder, PermissionType.ADMIN));
    }

    @Test
    void testUserCannotAdminRootFolderWithoutAdminPermission() {
        assertFalse(user.hasPermission(rootFolder, PermissionType.ADMIN));
    }

    @Test
    void testUserCanCreateFileInSubFolderWithAdminPermission() {
        if (user.hasPermission(subFolder, PermissionType.ADMIN)) {
            File newFile = new File(4, "New File");
            subFolder.addChild(newFile);
            assertTrue(subFolder.getChildren().contains(newFile));
        } else {
            fail("User doesn't have admin permission on subFolder.");
        }
    }
}
