import com.project.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PermissionTest {
    private User owner;
    private User editor;
    private Folder rootFolder;
    private File file;
    private Permission adminPermission;
    private Permission readPermission;

    @BeforeEach
    void setUp() {
        owner = new User(1, "owner@example.com");
        editor = new User(2, "editor@example.com");

        rootFolder = new Folder(1, "Root Folder");
        file = new File(2, "File");

        adminPermission = new Permission(rootFolder, owner, PermissionType.ADMIN);
        readPermission = new Permission(file, editor, PermissionType.READ);

        owner.addPermission(adminPermission);
        editor.addPermission(readPermission);

        rootFolder.addChild(file);
    }

    @Test
    void testUserCanReadFileIfHasReadPermission() {
        assertTrue(editor.hasPermission(file, PermissionType.READ));
    }

    @Test
    void testUserCannotAdminRootFolderWithoutAdminPermission() {
        assertFalse(editor.hasPermission(rootFolder, PermissionType.ADMIN));
    }

    @Test
    void testOwnerHasAdminPermission() {
        assertTrue(owner.hasPermission(rootFolder, PermissionType.ADMIN));
    }

    @Test
    void testEditorCanNotAdminFile() {
        assertFalse(editor.hasPermission(file, PermissionType.ADMIN));
    }
}
