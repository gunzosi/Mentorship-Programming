package com.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FolderTest {
    private Folder rootFolder;
    private Folder folderA1;
    private Folder folderA2;
    private File fileD;
    private File fileE;
    private File fileF;

    @BeforeEach
    void setUp() {
        rootFolder = new Folder(1, "Root Folder");

        folderA1 = new Folder(2, "Folder A1");
        folderA2 = new Folder(3, "Folder A2");

        folderA1.addChild(new File(4, "File C"));

        folderA2.addChild(fileD = new File(5, "File D"));
        folderA2.addChild(fileE = new File(6, "File E"));
        folderA2.addChild(fileF = new File(7, "File F"));

        rootFolder.addChild(folderA1);
        rootFolder.addChild(folderA2);
    }

    @Test
    void testAddChildFolder() {
        // 1. Add Child FOLDER B from ROOT Folder
        Folder folderB = new Folder(8, "Folder B");
        rootFolder.addChild(folderB);
        assertTrue(rootFolder.getChildren().contains(folderB));

        // 2. ADD Child File G from ROOT Folder
        File fileG = new File(9, "File G");
        rootFolder.addChild(fileG);
        assertTrue(rootFolder.getChildren().contains(fileG));
    }

    @Test
    void testRemoveFolderFromRoot() {
        // Remove folderA2 from rootFolder
        rootFolder.removeChild(folderA2);

        // Check that folderA2 has been removed from rootFolder
        assertFalse(rootFolder.getChildren().contains(folderA2));

        // ERROR --------- ***
        assertTrue(rootFolder.getChildren().contains(folderA1));
        assertFalse(rootFolder.getChildren().contains(fileE));
        assertFalse(rootFolder.getChildren().contains(fileF));
        System.out.println("Folder A2 has been removed from Root Folder");
    }
}
