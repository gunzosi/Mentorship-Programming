import com.project.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FolderPermissionTest {
    private User clientUser;
    private Folder folderA;  // Root folder
    private Folder folderB;  // Child of A
    private Folder folderC;  // Child of A
    private Folder folderC1; // Child of C
    private Folder folderC11; // Child of C.1
    private File fileD;      // Child of C

    @BeforeEach
    void setUp() {
        clientUser = new User(1, "client@example.com");

        // Create folder structure
        folderA = new Folder(1, "Folder A");  // Root
        folderB = new Folder(2, "Folder B");  // Child of A
        folderC = new Folder(3, "Folder C");  // Child of A
        folderC1 = new Folder(4, "Folder C.1");  // Child of C
        folderC11 = new Folder(5, "Folder C.1.1");  // Child of C.1
        fileD = new File(6, "File D"); // Child of C

        // Set up parent-child relationships
        folderA.addChild(folderB);
        folderA.addChild(folderC);
        folderC.addChild(folderC1);
        folderC1.addChild(folderC11);
        folderC.addChild(fileD);
    }

    @Test
    void testOptionalA_PermissionOnRootFolder() {
        // Add ADMIN permission to clientUser on Folder A (Root)
        folderA.addPermission(clientUser, PermissionType.ADMIN);

        // Check creation permissions
        assertTrue(clientUser.canCreate(folderC));
        assertTrue(clientUser.canCreate(fileD));
        assertTrue(clientUser.canCreate(folderC1));
        assertTrue(clientUser.canCreate(folderC11));

        // Check that the user cannot create a new file or folder outside of Folder C
        File fileE = new File(7, "File E");
        assertFalse(clientUser.canCreate(fileE));

        // Check that the user cannot create Folder C.1.2
        Folder folderC12 = new Folder(8, "Folder C.1.2");
        assertFalse(clientUser.canCreate(folderC12));
    }

    @Test
    void testOptionalB_PermissionOnFolderBOnly() {
        // Add ADMIN permission to clientUser on Folder B
        folderB.addPermission(clientUser, PermissionType.ADMIN);

        // Check creation permissions in Folder B
        Folder folderB1 = new Folder(9, "Folder B.1");
        File fileF = new File(10, "File F");
        folderB.addChild(folderB1);
        folderB.addChild(fileF);
        assertTrue(clientUser.canCreate(folderB1));
        assertTrue(clientUser.canCreate(fileF));

        // Check that the user cannot create or modify outside Folder B
        assertFalse(clientUser.canCreate(folderA)); // Root folder
        assertFalse(clientUser.canCreate(folderC)); // Child of root, not part of B
        assertFalse(clientUser.canCreate(fileD)); // File in Folder C
    }
}
