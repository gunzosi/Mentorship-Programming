import com.project.Folder;
import com.project.File;
import com.project.PermissionType;
import com.project.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FolderTest {
    private Folder rootFolder;
    private Folder subFolderA;
    private Folder subFolderB;
    private File fileD;
    private File fileE;
    private User user;

    @BeforeEach
    void setUp() {
        rootFolder = new Folder(1, "Root Folder");
        subFolderA = new Folder(2, "Folder A");
        subFolderB = new Folder(3, "Folder B");

        fileD = new File(4, "File D");
        fileE = new File(5, "File E");

        user = new User(1, "user@example.com");

        rootFolder.addChild(subFolderA);
        subFolderA.addChild(fileD);
    }

    @Test
    void testAddChildFolder() {
        rootFolder.addChild(subFolderB);
        assertTrue(rootFolder.getChildren().contains(subFolderB));
    }

    @Test
    void testRemoveChildFolder() {
        rootFolder.addChild(subFolderB);
        rootFolder.removeChild(subFolderB);
        assertFalse(rootFolder.getChildren().contains(subFolderB));
    }

    @Test
    void testAddPermissionToUser() {
        rootFolder.addPermission(user, PermissionType.READ);
        assertTrue(rootFolder.canUserPerformAction(user, PermissionType.READ));
    }

    @Test
    void testRemovePermissionFromUser() {
        rootFolder.addPermission(user, PermissionType.ADMIN);
        rootFolder.removePermission(user, PermissionType.ADMIN);
        assertFalse(rootFolder.canUserPerformAction(user, PermissionType.ADMIN));
    }
}
