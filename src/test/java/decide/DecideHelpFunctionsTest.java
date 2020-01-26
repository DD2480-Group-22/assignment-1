package decide;

import org.junit.jupiter.api.*;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideHelpFunctionsTest {

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function zero")
    class conditionFunctionZeroTests {

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

    @Nested
    @DisplayName("Tests for the condition function four")
    class conditionFunctionFourTests {
    	Point2D[] dummy_coord_array = { new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(0.2, -3.4),
				  						new Point2D.Double(-2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(0.1, 5.0)
    	};
    	
    	@Test
    	@DisplayName("Test function that should evaluate to true, needing 3 consecutive points on more than 2 different quadrants")
    	void correctInput2Quads3Points() {
    		Point2D[] coord_array = { new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(0.2, -3.4),
  				  					  new Point2D.Double(-2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(0.1, 5.0)
        	};
    		
    		assertTrue(DecideHelpFunctions.conditionFunctionFour(3, 2, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, needing 3 consecutive points on more than 2 different quadrants "
    			+ "but with points on only 2 different quadrants")
    	void incorrectInput2Quads3Points() {
    		Point2D[] coord_array = { new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(-0.2, 3.4),
    								  new Point2D.Double(-2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(0.1, 5.0)
    		};
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(3, 2, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, needing more points than there are coordinates available")
    	void incorrectInputMorePtsThanCoords() {
    		Point2D[] coord_array = dummy_coord_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(7, 2, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, needing 3 consecutive points on more than 2 different quadrants but with"
    			+ "non consecutive points on different quadrants")
    	void incorrectInput3Quads3PointsNonconsecutive() {
    		Point2D[] coord_array = { new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(-0.2, 3.4),
    								  new Point2D.Double(2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(-0.1, -5.0)
    		};
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(3, 2, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, as it's asks for 1 point on any number of different quadrants")
    	void incorrectInputNQuads1Point() {
    		Point2D[] coord_array = dummy_coord_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(1, 3, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, as asks for points on more than 3 quadrants")
    	void incorrectInput5Quads() {
    		Point2D[] coord_array = dummy_coord_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(3, 5, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Test function that should evaluate to false, as it asks for points on less than 1 quadrant")
    	void incorrectInputZeroOrNegativeQuads() {
    		Point2D[] coord_array = dummy_coord_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionFour(3, -1, coord_array));
    	}
    	
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
        @DisplayName("Test function with input that should evaluate to true, even kPts")
        void correctInputEven() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to true, odd kPts")
        void correctInputOdd() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(3, 1.0, array));
        }

        @Test
        @DisplayName("Test function with large array that should evaluate to true")
        void correctInputLongArray() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionSeven(2, 1.0, array));
        }

        @Test
        @DisplayName("To short distance between points")
        void incorrectDistance() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(7.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionSeven(2, 7.0, array));
        }

        @Test
        @DisplayName("Incorrect spacing between points")
        void incorrectSpacing() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(7.0, 0.0)
            };
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