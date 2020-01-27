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

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function four")
    class conditionFunctionFourTests {

    }

    @Nested
    @DisplayName("Tests for the condition function five")
    class conditionFunctionFiveTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(3.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionFive(array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionFive(array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionFive(array));
        }
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

    @Nested
    @DisplayName("Tests for the condition function eight")
    class conditionFunctionEightTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionEight(1, 1, 5, 0.9, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionEight(1, 1, 5, 20.0, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionEight(1, 1, 5, 20.0, array));
        }
    }

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function nine")
    class conditionFunctionNineTests {

    }

    @Nested
    @DisplayName("Tests for the condition function ten")
    class conditionFunctionTenTests {
    	double default_area = 16.0;
    	int default_ediff = 3;
    	int default_fdiff = 4;
    	Point2D[] template_array = { new Point2D.Double(1.0, 2.5), new Point2D.Double(2.4, 3.0), new Point2D.Double(1.0, 2.3), new Point2D.Double(5.0, 6.0),
				new Point2D.Double(0.4, 0.2), new Point2D.Double(1.4, 5.6), new Point2D.Double(9.8, 3.1), new Point2D.Double(10.0, 2.0),
				new Point2D.Double(1.3, 2.2), new Point2D.Double(1.1, 1.1), new Point2D.Double(4.2, 4.3), new Point2D.Double(0.5, 2.4)
    	};
  
    	
    	@Test
    	@DisplayName("Should return true for 3 points where side ab is the shortest, ac the longest and bc is 2nd longest")
    	void abLong3acLong1bcLong2() {
    		Point2D[] coord_array = template_array;
    		
    		assertTrue(DecideHelpFunctions.conditionFunctionTen(default_ediff, default_fdiff, default_area, coord_array));
    	}
    	
    	
    	@Test
    	@DisplayName("should return true for 3 points where side ab is the 2nd longest, ac is the longest and bc the shortest")
    	void abLong2acLong1bcLong3() {
    		Point2D[] coord_array = template_array;
    		coord_array[0] = new Point2D.Double(1.0, 1.5);
    		coord_array[3] = new Point2D.Double(7.0, 6.0);
    		
    		assertTrue(DecideHelpFunctions.conditionFunctionTen(default_ediff, default_fdiff, 18.0, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Should return false as it needs a bigger area than the ones we can make with given points")
    	void incorrectArea() {
    		Point2D[] coord_array = template_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionTen(default_ediff, default_fdiff, 30.0, coord_array));
    	}
    	
    	@Test
    	@DisplayName("should return false as the number of coordinates is lower than 5 but the differences make it possible to succeed")
    	void tooFewCoords() {
    		Point2D[] coord_array = {new Point2D.Double(1.0, 0.0), new Point2D.Double(4.5, 1.2)};
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionTen(1, 2, default_area, coord_array));
    	}
    	
    	@Test
    	@DisplayName("should return false as ePts is negative")
    	void invalidEPts() {
    		Point2D[] coord_array = template_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionTen(-2, default_fdiff, default_area, coord_array));
    	}
    	
    	@Test
    	@DisplayName("should return false as fPts is negative")
    	void invalidFPts() {
    		Point2D[] coord_array = template_array;
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionTen(default_ediff, -2, default_area, coord_array));
    	}
    	
    	@Test
    	@DisplayName("Should return false as it needs a difference larger than the quantity of points given")
    	void notEnoughPointsforGivenDiff() {
    		Point2D[] coord_array = {new Point2D.Double(2.4, 6.7), new Point2D.Double(1.0, 2.3)};
    		
    		assertFalse(DecideHelpFunctions.conditionFunctionTen(default_ediff, default_fdiff, default_area, coord_array));
    	}
    	
    	
    	
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