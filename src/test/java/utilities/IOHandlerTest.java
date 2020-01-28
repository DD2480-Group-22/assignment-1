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
        String file_name = "to_few_data_points.in";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(file_name));

        String expected_message = "There needs to be at least 3 coordinates";
        assertEquals(expected_message, exception.getMessage());
    }

    @Test
    @DisplayName("Config file doesn't exist")
    void fileDoesNotExist() {
        String file_name = "Non-existing file";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(file_name));

        String expected_message = "The file " + file_name + " couldn't be found";
        assertEquals(expected_message, exception.getMessage());
    }

    @Test
    @DisplayName("Check that IOHandler creates a DecideProgram object when given a correct config file")
    void correctType() {
        String file_name = "test_1.in";
        IOHandler io_handler = new IOHandler();

        assertDoesNotThrow(() -> {
            io_handler.readTest(file_name);
        });

        try {
            DecideProgram decide_program = io_handler.readTest(file_name);
            assertNotNull(decide_program);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("To few double parameters")
    void toFewDoubles() {
        String file_name = "to_few_doubles.in";
        assertThrows(NumberFormatException.class, () -> new IOHandler().readTest(file_name));
    }

    @Test
    @DisplayName("To few integer parameters")
    void toFewIntegers() {
        String file_name = "to_few_integers.in";
        assertThrows(NumberFormatException.class, () -> new IOHandler().readTest(file_name));
    }

    @Test
    @DisplayName("The Logical Connector Matrix contains a value that doesn't math a enum in Connectors")
    void wrongTypeOfOperator() {
        String file_name = "non_existen_logical_operator.in";
        assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(file_name));
    }

    @Test
    @DisplayName("Non-boolean value in the Preliminary Unlocking Vector")
    void nonBoolean() {
        String file_name = "non_boolean_value.in";
        assertThrows(IllegalArgumentException.class, () -> new IOHandler().readTest(file_name));
    }
}