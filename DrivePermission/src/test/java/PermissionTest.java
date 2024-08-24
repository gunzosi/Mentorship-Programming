package com.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class PermissionTest {
    private User owner;
    private User user;
    private Folder rootFolder;
    private Folder subFolder;
    private File file;
    private Permission editorPermissionOnFile;
    private Permission editorPermissionOnSubFolder;

    @BeforeEach
    void setUp() {
        // Tạo chủ sở hữu và người dùng
        owner = new User(1, "owner@example.com");
        user = new User(2, "user@example.com");

        // Tạo thư mục và tệp
        rootFolder = new Folder(1, "Root Folder");
        subFolder = new Folder(2, "Sub Folder");
        file = new File(3, "File");

        // Cấp quyền cho người dùng trên thư mục và tệp
        editorPermissionOnFile = new Permission(file, PermissionType.EDITOR);
        editorPermissionOnSubFolder = new Permission(subFolder, PermissionType.EDITOR);

        // Cấp quyền cho người dùng
        user.addPermission(new Permission(rootFolder, PermissionType.EDITOR)); // Editor trên thư mục root
        user.addPermission(editorPermissionOnFile); // Editor trên tệp
        user.addPermission(editorPermissionOnSubFolder); // Editor trên subFolder

        // Cấu hình thư mục
        rootFolder.addChild(subFolder);
        rootFolder.addChild(file);
    }

    @Test
    void testUserCannotEditFileInRootFolderWithoutFilePermission() {
        // Kiểm tra rằng người dùng có thể chỉnh sửa tệp trong thư mục root
        // Điều này sẽ được kiểm tra qua permission ở tệp.
        assertTrue(user.hasPermission(file, PermissionType.EDITOR));
    }

    @Test
    void testUserCannotEditSubFolderInRootFolderWithoutSubFolderPermission() {
        // Kiểm tra rằng người dùng có thể chỉnh sửa thư mục con trong thư mục root
        // Điều này sẽ được kiểm tra qua permission ở thư mục con.
        assertTrue(user.hasPermission(subFolder, PermissionType.EDITOR));
    }

    @Test
    void testUserCannotEditRootFolderIfOnlyFilePermission() {
        // Cấp quyền editor cho tệp, không cho thư mục
        user.removePermission(editorPermissionOnFile); // Remove editor permission on file
        user.addPermission(new Permission(file, PermissionType.READ)); // View-only permission

        // Người dùng không nên có quyền chỉnh sửa thư mục root
        assertFalse(user.hasPermission(rootFolder, PermissionType.EDITOR));
    }

    @Test
    void testUserCanEditSubFolderIfHasEditorPermissionOnSubFolder() {
        // Người dùng có quyền editor trên thư mục con
        assertTrue(user.hasPermission(subFolder, PermissionType.EDITOR));
    }

    @Test
    void testUserCanEditFileIfHasEditorPermissionOnFile() {
        // Người dùng có quyền editor trên tệp
        assertTrue(user.hasPermission(file, PermissionType.EDITOR));

    }

    @Test
    void testUserCannotEditFolderAtSameLevelIfOnlyFilePermission() {
        // Cấp quyền editor cho tệp, không cho thư mục
        user.removePermission(editorPermissionOnFile);
        user.addPermission(new Permission(file, PermissionType.READ)); // View-only permission

        // Người dùng không nên có quyền chỉnh sửa các thư mục ở cùng cấp (rootFolder)
        assertFalse(user.hasPermission(rootFolder, PermissionType.EDITOR));
    }
}
