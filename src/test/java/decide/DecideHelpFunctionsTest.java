package decide;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideHelpFunctionsTest {

	@BeforeEach
	void setUp() {
	}

	@Nested
    @DisplayName("Tests of condition function zero")
    class ConditionFunctionZeroTests {
        @Test
        @DisplayName("Test function with on basic input of two coordinates")
        void correctInputEvan() {
        	double[][] coord = new double[2][2];
        	
        	coord[0][0] = 1.0;
        	coord[0][1] = 1.0;
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(1.0, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2)+0.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(2.0, coord) );
        	
        	coord[1][0] = -2.0;
        	coord[1][1] = -3.0;
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(5.0, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4.5, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.1, coord) );
        }

        @Test
        @DisplayName("Test function with input of 10 coordinates where only the last has any distance from the others")
        void correctInputOdd() {
        	double[][] coord = new double[10][2];
        	
        	coord[9][0] = 4.0;
        	coord[9][1] = 3.0;
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(5, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(6, coord) );
        }

        @Test
        @DisplayName("Test function with only negative coordinates")
        void correctInputLongArray() {
        	double[][] coord = new double[3][2];
        	
        	coord[0][0] = -1.0;
        	coord[0][1] = -1.0;
        	
        	coord[1][0] = -1.0;
        	coord[1][1] = -2.0;
        	
        	coord[2][0] = -4.0;
        	coord[2][1] = -6.0;
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(5, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(6, coord) );
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
        	double[][] coord = new double[1][2];
        	
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(50, coord) );
        }

        @Test
        @DisplayName("Test sequence of consecutive points with equal distance")
        void incorrectDistance() {
        	double[][] coord = new double[10][2];
        	
        	for(int i = 0; i < 10; ++i) {
        		coord[i][0] = i;
        		coord[i][1] = i;
        	}
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(1.0, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2)+0.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(2.0, coord) );
        }
	}
        
    @Disabled
    @Nested
    @DisplayName("Tests for the condition function one")
    class conditionFunctionOneTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function two")
    class conditionFunctionTwoTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function three")
    class conditionFunctionThreeTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function four")
    class conditionFunctionFourTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function five")
    class conditionFunctionFiveTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function six")
    class conditionFunctionSixTests {

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

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function eight")
    class conditionFunctionEightTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function nine")
    class conditionFunctionNineTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function ten")
    class conditionFunctionTenTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function eleven")
    class conditionFunctionElevenTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function twelve")
    class conditionFunctionTwelveTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function thirteen")
    class conditionFunctionThirteenTests {

    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function fourteen")
    class conditionFunctionFourteenTests {

    }
}