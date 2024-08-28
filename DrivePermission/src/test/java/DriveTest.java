import com.project.Drive;
import com.project.Folder;
import com.project.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DriveTest {
    private Drive drive;
    private Folder rootFolder;
    private User owner;
    private User anotherUser;

    @BeforeEach
    void setUp() {
        owner = new User(1, "owner@example.com");
        drive = new Drive(1, "My Drive", owner);
        rootFolder = new Folder(1, "Root Folder");
        anotherUser = new User(2, "user@example.com");
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

    @Test
    void testAddUserToDrive() {
        drive.addUser(anotherUser);
        assertTrue(drive.getUsers().contains(anotherUser));
    }

    @Test
    void testRemoveUserFromDrive() {
        drive.addUser(anotherUser);
        drive.removeUser(anotherUser);
        assertFalse(drive.getUsers().contains(anotherUser));
    }

    @Test
    void testOwnerIsAutomaticallyAddedToDrive() {
        assertTrue(drive.getUsers().contains(owner));
    }
}
