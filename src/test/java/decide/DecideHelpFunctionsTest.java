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

    @Test
    void conditionFunctionSeven() {
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