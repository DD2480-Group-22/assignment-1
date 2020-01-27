package decide;

import org.junit.jupiter.api.*;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecideHelpFunctionsTest {

	@Nested
    @DisplayName("Tests of condition function zero")
    class ConditionFunctionZeroTests {
        @Test
        @DisplayName("Test function with on basic input of two coordinates")
        void basicTwoCoordinates() {
        	Point2D[] coord = {
                    new Point2D.Double(1.0, 1.0), new Point2D.Double(0.0, 0.0)
            };
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(1.0, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2)-0.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(2.0, coord) );
        	
        	coord[1].setLocation(-2.0, -3.0);
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4.99, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(6, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.01, coord) );
        }

        @Test
        @DisplayName("Test function with input of 10 coordinates where only the last has any distance from the others")
        void longArrayLastCoordinate() {
        	Point2D[] coord = new Point2D[10];
        	for(int i = 0; i < 10; ++i) {
        		coord[i] = new Point2D.Double(0.0,0.0);
        	}
        	
        	coord[9].setLocation(4.0, 3.0);
        	
        	
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4.99, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(6, coord) );
        }

        @Test
        @DisplayName("Test function with only negative coordinates")
        void negativeCoordinates() {
        	Point2D[] coord = {
        			new Point2D.Double(-1.0, -1.0), 
        			new Point2D.Double(-1.0, -2.0),
        			new Point2D.Double(-4.0, -6.0)
        	};
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(4.99, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(5.1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(6, coord) );
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
        	Point2D[] coord = { new Point2D.Double(1.0, 1.0) };
        	
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(1, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(50, coord) );
        }

        @Test
        @DisplayName("Test sequence of consecutive points with equal distance")
        void longArrayEqualDistance() {
        	Point2D[] coord = new Point2D[10];;
        	
        	for(int i = 0; i < 10; ++i) {
        		coord[i] = new Point2D.Double(i, i);
        	}
        	
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(1, coord) );
        	assertTrue( DecideHelpFunctions.conditionFunctionZero(1.2, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(2, coord) );
        	assertFalse( DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord) );
        }
	}

    @Disabled
    @Nested
    @DisplayName("Tests for the condition function one")
    class conditionFunctionOneTests {

    }

    @Nested
    @DisplayName("Tests for the condition function two")
    class conditionFunctionTwoTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 1.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionTwo(0.1, array));
        }
        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(-1.0, 0.0), new Point2D.Double(-1.0, 0.0),
                    new Point2D.Double(1.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionTwo(0.1, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionTwo(0.1, array));
        }

        @Test
        @DisplayName("Invalid epsilon")
        void invalidEpsilon() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(-1.0, 0.0), new Point2D.Double(-1.0, 0.0),
                    new Point2D.Double(1.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionTwo(4.0, array));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function three")
    class conditionFunctionThreeTests {
    	@Test
        @DisplayName("Test function for simple, straight triangle")
        void simpleStraightTriangle() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), 
                    new Point2D.Double(6.0, 0.0),
                    new Point2D.Double(3.0, 3.0)
            };
            
            assertTrue(DecideHelpFunctions.conditionFunctionThree(5.0, array));
            assertTrue(DecideHelpFunctions.conditionFunctionThree(8.99, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(10.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(9.0, array));
        }
    	
    	@Test
        @DisplayName("Test function for an angled triangle")
        void angledTriangle() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), 
                    new Point2D.Double(3.0, 2.0),
                    new Point2D.Double(0.0, 3.0)
            };
            
            assertTrue(DecideHelpFunctions.conditionFunctionThree(2.0, array));
            assertTrue(DecideHelpFunctions.conditionFunctionThree(3.99, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(6.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(4.0, array));
        }
    	
    	@Test
        @DisplayName("Test function for an angled triangle with negative coordinates")
        void negativeCoordinates() {
            Point2D[] array = {
                    new Point2D.Double(-1.0, 0.0), 
                    new Point2D.Double(-3.0, -2.0),
                    new Point2D.Double(0.0, -3.0)
            };
            
            assertTrue(DecideHelpFunctions.conditionFunctionThree(2.0, array));
            assertTrue(DecideHelpFunctions.conditionFunctionThree(3.99, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(6.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(4.0, array));
        }
    	
    	@Test
        @DisplayName("Test function for array where every three consecutive points have two that are equal")
        void longArrayOfPairwiseEqual() {
            Point2D[] array = new Point2D[10];
            
            for(int i = 0; i < 10; i+=2) {
            	array[i] = new Point2D.Double(i,i);
            	array[i+1] = new Point2D.Double(i,i);
            }
            
            assertFalse(DecideHelpFunctions.conditionFunctionThree(10.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(5.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(1.0, array));
        }
    	
    	@Test
        @DisplayName("Test function for array where only the two last are not at origin")
        void longArrayLastTwo() {
            Point2D[] array = new Point2D[10];
            
            for(int i = 0; i < 10; ++i) {
            	array[i] = new Point2D.Double(0.0,0.0);
            }
            
            array[8].setLocation(4.0,0.0);
            array[9].setLocation(4.0,4.0);
            
            assertTrue(DecideHelpFunctions.conditionFunctionThree(4, array));
            assertTrue(DecideHelpFunctions.conditionFunctionThree(7.99, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(10.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(8.0, array));
        }
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

    @Nested
    @DisplayName("Tests for the condition function six")
    class conditionFunctionSixTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(5.0, 5.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(10.0, 0.0), new Point2D.Double(0.0, 0.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionSix(5, 4, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false, to short distance")
        void toShortDistance() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(5.0, 5.0), new Point2D.Double(0.0, 10.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0)
            };

            assertFalse(DecideHelpFunctions.conditionFunctionSix(4, 10, array));
        }

        @Test
        @DisplayName("Not in range")
        void notInRange() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 10.0), new Point2D.Double(5.0, 5.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0)
            };

            assertFalse(DecideHelpFunctions.conditionFunctionSix(4, 10, array));
        }

        @Test
        @DisplayName("Same coordinates")
        void sameCoordinates() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(5.0, 5.0), new Point2D.Double(0.0, 0.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionSix(4, 4, array));
        }
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