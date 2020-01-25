package decide;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideHelpFunctionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void conditionFunctionZero() {
    }

    @Test
    void conditionFunctionOne() {
    }

    @Test
    void conditionFunctionTwo() {
    }

    @Test
    void conditionFunctionThree() {
    }

    @Test
    void conditionFunctionFour() {
    }

    @Test
    void conditionFunctionFive() {
    }

    @Test
    void conditionFunctionSix() {
    }

    @Nested
    @DisplayName("Tests of the seventh condition function")
    class ConditionFunctionSevenTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true, evan kPts")
        void correctInputEvan() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {2.0, 0.0}};
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to true, odd kPts")
        void correctInputOdd() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {2.0, 0.0}};
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(3, 1.0, array));
        }

        @Test
        @DisplayName("Test function with large array that should evaluate to true")
        void correctInputLongArray() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0},
                    {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0},
                    {0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {2.0, 0.0}};
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}};
            assertFalse(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("To short distance between points")
        void incorrectDistance() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}, {7, 0}};
            assertFalse(DecideHelpFunctions.conditionFunctionSeven(2, 7.0, array));
        }

        @Test
        @DisplayName("Incorrect spacing between points")
        void incorrectSpacing() {
            double[][] array = {{0.0, 0.0}, {0.0, 0.0}, {7, 0}};
            assertFalse(DecideHelpFunctions.conditionFunctionSeven(3, 7.0, array));
        }
   }

    @Test
    void conditionFunctionEight() {
    }

    @Test
    void conditionFunctionNine() {
    }

    @Test
    void conditionFunctionTen() {
    }

    @Test
    void conditionFunctionEleven() {
    }

    @Test
    void conditionFunctionTwelve() {
    }

    @Test
    void conditionFunctionThirteen() {
    }

    @Test
    void conditionFunctionFourteen() {
    }
}