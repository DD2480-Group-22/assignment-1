package utilities;

import decide.DecideProgram;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IOHandlerTest {

    @Test
    @DisplayName("Check for when config file contains to few data points (< 3)")
    void toFewDataPoints() {
        String fileName = "to_few_data_points.in";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(fileName));

        String expectedMessage = "There needs to be at least 3 coordinates";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Config file doesn't exist")
    void fileDoesNotExist() {
        String fileName = "Non-existing file";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(fileName));

        String expectedMessage = "The file " + fileName + " couldn't be found";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Check that IOHandler creates a DecideProgram object when given a correct config file")
    void correctType() {
        String fileName = "program_test_4.in";
        IOHandler ioHandler = new IOHandler();

        assertDoesNotThrow(() -> {
            ioHandler.readTest(fileName);
        });

        try {
            DecideProgram decideProgram = ioHandler.readTest(fileName);
            assertNotNull(decideProgram);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("To few double parameters")
    void toFewDoubles() {
        String fileName = "to_few_doubles.in";
        assertThrows(NumberFormatException.class, () -> new IOHandler().readTest(fileName));
    }

    @Test
    @DisplayName("To few integer parameters")
    void toFewIntegers() {
        String fileName = "to_few_integers.in";
        assertThrows(NumberFormatException.class, () -> new IOHandler().readTest(fileName));
    }

    @Test
    @DisplayName("The Logical Connector Matrix contains a value that doesn't math a enum in Connectors")
    void wrongTypeOfOperator() {
        String fileName = "non_existen_logical_operator.in";
        assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(fileName));
    }

    @Test
    @DisplayName("Non-boolean value in the Preliminary Unlocking Vector")
    void nonBoolean() {
        String fileName = "non_boolean_value.in";
        assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(fileName));
    }
}