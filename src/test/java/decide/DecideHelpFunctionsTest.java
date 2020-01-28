package decide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

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

            assertTrue(DecideHelpFunctions.conditionFunctionZero(1.0, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2) - 0.1, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(2.0, coord));

            coord[1].setLocation(-2.0, -3.0);

            assertTrue(DecideHelpFunctions.conditionFunctionZero(4, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionZero(4.99, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(6, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(5.01, coord));
        }

        @Test
        @DisplayName("Test function with input of 10 coordinates where only the last has any distance from the others")
        void longArrayLastCoordinate() {
            Point2D[] coord = new Point2D[10];
            for (int i = 0; i < 10; ++i) {
                coord[i] = new Point2D.Double(0.0, 0.0);
            }

            coord[9].setLocation(4.0, 3.0);

            assertTrue(DecideHelpFunctions.conditionFunctionZero(4, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionZero(4.99, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(5.1, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(6, coord));
        }

        @Test
        @DisplayName("Test function with only negative coordinates")
        void negativeCoordinates() {
            Point2D[] coord = {
                    new Point2D.Double(-1.0, -1.0),
                    new Point2D.Double(-1.0, -2.0),
                    new Point2D.Double(-4.0, -6.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionZero(4, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionZero(4.99, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(5.1, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(6, coord));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] coord = {new Point2D.Double(1.0, 1.0)};

            assertFalse(DecideHelpFunctions.conditionFunctionZero(1, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(50, coord));
        }

        @Test
        @DisplayName("Test sequence of consecutive points with equal distance")
        void longArrayEqualDistance() {
            Point2D[] coord = new Point2D[10];

            for (int i = 0; i < 10; ++i) {
                coord[i] = new Point2D.Double(i, i);
            }

            assertTrue(DecideHelpFunctions.conditionFunctionZero(1, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionZero(1.2, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(2, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionZero(Math.sqrt(2), coord));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function one")
    class conditionFunctionOneTests {
        @Test
        @DisplayName("Test function with input of three points sqrt(2) from origo")
        void basicCircularInput() {
            Point2D[] coord = {
                    new Point2D.Double(1.0, 1.0),
                    new Point2D.Double(-1.0, 1.0),
                    new Point2D.Double(0.0, -Math.sqrt(2))
            };

            assertTrue(DecideHelpFunctions.conditionFunctionOne(1.0, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2) - 0.01, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(4.0, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2), coord));

            // Turn the coordinates counter-clockwise around origin
            coord[0] = new Point2D.Double(Math.sqrt(2), 0);
            coord[1] = new Point2D.Double(-1.0, 1.0);
            coord[2] = new Point2D.Double(-1.0, -1.0);

            assertTrue(DecideHelpFunctions.conditionFunctionOne(1.0, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2) - 0.01, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(4.0, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2), coord));

            // Turn the coordinates counter-clockwise around origin
            coord[0] = new Point2D.Double(1.0, -1.0);
            coord[1] = new Point2D.Double(0, Math.sqrt(2));
            coord[2] = new Point2D.Double(-1.0, -1.0);

            assertTrue(DecideHelpFunctions.conditionFunctionOne(1.0, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2) - 0.01, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(4.0, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(Math.sqrt(2), coord));

        }

        @Test
        @DisplayName("Test function with input of three points on a line")
        void basicLinearInput() {
            Point2D[] coord = {
                    new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(5.0, 0.0),
                    new Point2D.Double(10.0, 0.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionOne(2, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionOne(4, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(10, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(5, coord));
        }

        @Test
        @DisplayName("Test function with input a long array where only the last is not at origin")
        void arrayInputOnlyLast() {
            Point2D[] coord = new Point2D[10];

            for (int i = 0; i < 10; ++i) {
                coord[i] = new Point2D.Double(0.0, 0.0);
            }
            coord[9].setLocation(3.0, 4.0);

            assertTrue(DecideHelpFunctions.conditionFunctionOne(1, coord));
            assertTrue(DecideHelpFunctions.conditionFunctionOne(2, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(5, coord));
            assertFalse(DecideHelpFunctions.conditionFunctionOne(2.5, coord));
        }
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

            for (int i = 0; i < 10; i += 2) {
                array[i] = new Point2D.Double(i, i);
                array[i + 1] = new Point2D.Double(i, i);
            }

            assertFalse(DecideHelpFunctions.conditionFunctionThree(10.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(5.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(1.0, array));
        }

        @Test
        @DisplayName("Test function for array where only the two last are not at origin")
        void longArrayLastTwo() {
            Point2D[] array = new Point2D[10];

            for (int i = 0; i < 10; ++i) {
                array[i] = new Point2D.Double(0.0, 0.0);
            }

            array[8].setLocation(4.0, 0.0);
            array[9].setLocation(4.0, 4.0);

            assertTrue(DecideHelpFunctions.conditionFunctionThree(4, array));
            assertTrue(DecideHelpFunctions.conditionFunctionThree(7.99, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(10.0, array));
            assertFalse(DecideHelpFunctions.conditionFunctionThree(8.0, array));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function four")
    class conditionFunctionFourTests {
        Point2D[] dummy_coord_array = {new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(0.2, -3.4),
                new Point2D.Double(-2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(0.1, 5.0)
        };

        @Test
        @DisplayName("Test function that should evaluate to true, needing 3 consecutive points on more than 2 different quadrants")
        void correctInput2Quads3Points() {
            Point2D[] coord_array = {new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(0.2, -3.4),
                    new Point2D.Double(-2.4, 4.0), new Point2D.Double(1.2, 2.3), new Point2D.Double(0.1, 5.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionFour(3, 2, coord_array));
        }

        @Test
        @DisplayName("Test function that should evaluate to false, needing 3 consecutive points on more than 2 different quadrants "
                + "but with points on only 2 different quadrants")
        void incorrectInput2Quads3Points() {
            Point2D[] coord_array = {new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(-0.2, 3.4),
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
            Point2D[] coord_array = {new Point2D.Double(-1.2, 1.0), new Point2D.Double(-0.3, 2.0), new Point2D.Double(-0.2, 3.4),
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

            assertFalse(DecideHelpFunctions.conditionFunctionSix(4, 10.0, array));
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


    @Nested
    @DisplayName("Tests for the condition function nine")
    class conditionFunctionNineTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(1.0, 2.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionNine(1, 1, 5, 0.1, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(-1.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionNine(1, 1, 5, 0.1, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(-1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionNine(1, 1, 5, 0.1, array));
        }

        @Test
        @DisplayName("Invalid epsilon")
        void invalidEpsilon() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(1.0, 2.0)
            };

            assertFalse(DecideHelpFunctions.conditionFunctionNine(1, 1, 5, 4, array));
        }

        @Test
        @DisplayName("Invalid cPts")
        void invalidCPTS() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(1.0, 2.0)
            };

            assertFalse(DecideHelpFunctions.conditionFunctionNine(0, 1, 5, 4, array));
        }

        @Test
        @DisplayName("Invalid dPts")
        void invalidDPTS() {
            Point2D[] array = {
                    new Point2D.Double(1.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(1.0, 2.0)
            };

            assertFalse(DecideHelpFunctions.conditionFunctionNine(1, 0, 5, 4, array));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function ten")
    class conditionFunctionTenTests {
        double default_area = 16.0;
        int default_ediff = 3;
        int default_fdiff = 4;
        Point2D[] template_array = {new Point2D.Double(1.0, 2.5), new Point2D.Double(2.4, 3.0), new Point2D.Double(1.0, 2.3), new Point2D.Double(5.0, 6.0),
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

    @Nested
    @DisplayName("Tests for the condition function eleven")
    class conditionFunctionElevenTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(3.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionEleven(1, 4, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionEleven(1, 4, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionEleven(3, 2, array));
        }

        @Test
        @DisplayName("Invalid gPts")
        void invalidGPTS() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionEleven(0, 5, array));
        }


    }

    @Nested
    @DisplayName("Tests for the condition function twelve")
    class conditionFunctionTwelveTests {
        int default_kPts = 3;
        double default_length1 = 2.0;
        double default_length2 = 3.5;

        Point2D[] default_array = {
                new Point2D.Double(1.0, 3.4), new Point2D.Double(2.0, 4.0),
                new Point2D.Double(1.0, 0.1), new Point2D.Double(3.0, 4.5),
                new Point2D.Double(6.0, 7.7), new Point2D.Double(2.4, 5.1),
                new Point2D.Double(2.4, 5.0), new Point2D.Double(6.4, 7.6)
        };

        @Test
        @DisplayName("Test function for an invalid number of points (< 3), should return false")
        void invalidNumPoints() {
            Point2D[] coord_array = {new Point2D.Double(1.0, 2.0), new Point2D.Double(3.0, 4.0)};

            assertFalse(DecideHelpFunctions.conditionFunctionTwelve(default_kPts, default_length1, default_length2, coord_array));
        }

        @Test
        @DisplayName("Test function for a negative lenght2, should return false")
        void invalidLength2() {
            double invalid_length2 = -1.5;

            assertFalse(DecideHelpFunctions.conditionFunctionTwelve(default_kPts, default_length1, invalid_length2, default_array));
        }

        @Test
        @DisplayName("Test function with border input values, should return false")
        void borderIncorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0, 0.0),
                    new Point2D.Double(2.0, 0)
            };
            double border_length1 = 1;
            double border_length2 = 1.5;

            assertFalse(DecideHelpFunctions.conditionFunctionTwelve(1, border_length1, border_length2, array));
        }

        @Test
        @DisplayName("Test function with correct input values, should return true")
        void correctInput() {
            assertTrue(DecideHelpFunctions.conditionFunctionTwelve(default_kPts, default_length1, default_length2, default_array));
        }

        @Test
        @DisplayName("Test function with negative kPts value, should return false")
        void invalidKPts() {
            assertFalse(DecideHelpFunctions.conditionFunctionTwelve(-3, default_length1, default_length2, default_array));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function thirteen")
    class conditionFunctionThirteenTests {
        @Test
        @DisplayName("Test function with input that should evaluate to true")
        void correctInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertTrue(DecideHelpFunctions.conditionFunctionThirteen(2, 1, 13, 0.1, 30.9, array));
        }

        @Test
        @DisplayName("Test function with input that should evaluate to false")
        void incorrectInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0),
                    new Point2D.Double(2.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0),
                    new Point2D.Double(2.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0),
                    new Point2D.Double(2.0, 0.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionThirteen(1, 1, 13, 40.0, 20.0, array));
        }

        @Test
        @DisplayName("Not enough data points")
        void notEnoughPoints() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(10.0, 0.0),
                    new Point2D.Double(6.0, 6.0), new Point2D.Double(0.0, 15.0)
            };
            assertFalse(DecideHelpFunctions.conditionFunctionThirteen(1, 1, 5, 0.1, 20.0, array));
        }
    }

    @Nested
    @DisplayName("Tests for the condition function fourteen")
    class conditionFunctionFourteenTests {
        @Test
        @DisplayName("Basic test for three data points with only 1 point between each")
        void basicSmallestInput() {
            Point2D[] array = {
                    new Point2D.Double(0.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(6.0, 0.0), new Point2D.Double(0.0, 0.0),
                    new Point2D.Double(3.0, 3.0)
            };

            assertTrue(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 4, 15, array));
            assertTrue(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 8, 10, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 10, 12, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 12, 6, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 2, 1, 20, array));
        }

        @Test
        @DisplayName("Test on a long array where all except one point is on the X axis")
        void longArray() {
            Point2D[] array = new Point2D[20];

            for (int i = 0; i < 20; ++i) {
                array[i] = new Point2D.Double(i, 0.0);
            }

            array[15].setLocation(15.0, 10.0);

            assertTrue(DecideHelpFunctions.conditionFunctionFourteen(3, 3, 25, 30, array));
            assertTrue(DecideHelpFunctions.conditionFunctionFourteen(3, 3, 39, 21, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 30, 35, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 2, 6, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(2, 2, 40, 20, array));
        }

        @Test
        @DisplayName("Test on an array with too large intervals")
        void tooLargeIntervals() {
            Point2D[] array = new Point2D[6];

            for (int i = 0; i < 6; ++i) {
                array[i] = new Point2D.Double(i, i * Math.pow(-1, i));
            }

            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(4, 4, 5, 40, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(3, 1, 5, 40, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 3, 5, 40, array));
        }

        @Test
        @DisplayName("Test on an array with less than five elements")
        void tooShortArray() {
            Point2D[] array = new Point2D[4];

            for (int i = 0; i < 4; ++i) {
                array[i] = new Point2D.Double(i, i * Math.pow(-1, i));
            }

            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 1, 40, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(1, 1, 1, 40, array));
            assertFalse(DecideHelpFunctions.conditionFunctionFourteen(0, 0, 1, 40, array));
        }
    }
}