package decide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.IOHandler;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideProgramTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void launchConfigFile() {
        try {
            IOHandler ioHandler = new IOHandler();
            DecideProgram decideProgram = ioHandler.readTest("test_1.in");
            assertTrue(decideProgram.launch());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}