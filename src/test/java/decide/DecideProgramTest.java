package decide;

import org.junit.jupiter.api.Test;
import utilities.IOHandler;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideProgramTest {
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

    @Test
    void programTestOne() {
        try {
            IOHandler ioHandler = new IOHandler();
            DecideProgram decideProgram = ioHandler.readTest("program_test_1.in");
            assertFalse(decideProgram.launch());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void programTestTwo() {
        try {
            IOHandler ioHandler = new IOHandler();
            DecideProgram decideProgram = ioHandler.readTest("program_test_2.in");
            assertFalse(decideProgram.launch());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}