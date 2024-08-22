import com.project.Drive;
import com.project.Folder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriveTest {
    private Drive drive;
    private Folder rootFolder;

    @BeforeEach
    void setUp() {
        drive = new Drive(1,"My Drive");
        rootFolder = new Folder(1, "Test Folder");
    }

    @Test
    void testAddRootFolder() {
        drive.addChild(rootFolder);
        assertTrue(drive.getChildren().contains(rootFolder));
    }

    @Test
    void testRemoveRootFolder() {
        drive.addChild(rootFolder);
        drive.removeChild(rootFolder);
        assertFalse(drive.getChildren().contains(rootFolder));
    }
}
