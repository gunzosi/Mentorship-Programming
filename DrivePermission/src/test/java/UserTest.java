package com.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class UserTest {
    private User user;
    private Folder rootFolder;
    private Folder subFolder;
    private Permission editorPermission;

    @BeforeEach
    void setUp() {
        rootFolder = new Folder(1, "Root Folder");
        subFolder = new Folder(2, "Sub Folder");

        // Initialize user with editor permission on rootFolder
        editorPermission = new Permission(rootFolder, PermissionType.EDITOR);
        List<Permission> permissions = new ArrayList<>();
        permissions.add(editorPermission);
        user = new User(1, "user@example.com", permissions);

        // Add subFolder to rootFolder
        rootFolder.addChild(subFolder);
    }

    @Test
    void testCreateSubFolderWithEditorPermissionOnRoot() {
        // Simulate user creating a new subfolder in rootFolder
        if (user.hasPermission(rootFolder, PermissionType.EDITOR)) {
            Folder newSubFolder = new Folder(3, "New Sub Folder");
            rootFolder.addChild(newSubFolder);
            assertTrue(rootFolder.getChildren().contains(newSubFolder));
        } else {
            fail("User doesn't have editor permission on root folder.");
        }
    }

    @Test
    void testCreateFolderAndFileInSubFolder() {
        // Add editor permission to user for subFolder
        Permission subFolderEditorPermission = new Permission(subFolder, PermissionType.EDITOR);
        user.addPermission(subFolderEditorPermission);

        // Simulate user creating a new folder and a new file in subFolder
        if (user.hasPermission(subFolder, PermissionType.EDITOR)) {
            Folder newFolderInSubFolder = new Folder(4, "New Folder in SubFolder");
            File newFileInSubFolder = new File(5, "New File in SubFolder");

            subFolder.addChild(newFolderInSubFolder);
            subFolder.addChild(newFileInSubFolder);

            assertTrue(subFolder.getChildren().contains(newFolderInSubFolder));
            assertTrue(subFolder.getChildren().contains(newFileInSubFolder));
        } else {
            fail("User doesn't have editor permission on subfolder.");
        }
    }
}
