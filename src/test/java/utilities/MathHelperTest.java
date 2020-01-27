package utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class MathHelperTest {
    @Nested
    @DisplayName("Tests for the distanceToLine function")
    class distanceToLineTests {
        @Test
        @DisplayName("Returns correct distance")
        void distanceCheck() {
            assertEquals(5.0, MathHelper.distanceToLine(new Point2D.Double(0, 0),
                    new Point2D.Double(0.0, 10.0), new Point2D.Double(5.0, 5.0)));

            assertEquals(0.0, MathHelper.distanceToLine(new Point2D.Double(10, 10),
                    new Point2D.Double(20.0, 20.0), new Point2D.Double(15.0, 15.0)));

            assertEquals(20.0, MathHelper.distanceToLine(new Point2D.Double(20, 10),
                    new Point2D.Double(20.0, 20.0), new Point2D.Double(0.0, 15.0)));
        }
    }

    @Nested
    @DisplayName("Tests for the equalityCheckCoordinates function")
    class equalityCheckCoordinatesTests {
        @Test
        @DisplayName("Test of coordinates that should be considered to be equal ")
        void samePoints() {
            assertTrue(MathHelper.equalityCheckCoordinates(new Point2D.Double(0.000001, 0.0),
                    new Point2D.Double(0.0000011, 0.0)));
        }

        @Test
        @DisplayName("Test of coordinates that should not be considered to be equal")
        void notSamePoints() {
            assertFalse(MathHelper.equalityCheckCoordinates(new Point2D.Double(0.000001, 0.0),
                    new Point2D.Double(0.00001, 0.0)));
        }
    }

    @Nested
    @DisplayName("Tests for the getAngle function")
    class getAnglesTest {
        @Test
        void testPointAngle() {
            Point2D p1 = new Point2D.Double(2, 2);
            Point2D p2 = new Point2D.Double(0, 2);
            Point2D p3 = new Point2D.Double(-3, 2);
            Point2D p4 = new Point2D.Double(-7, 2);
            Point2D p5 = new Point2D.Double(-3, 4);
            Point2D p6 = new Point2D.Double(-5, 2);

            assertEquals(180, MathHelper.getAngle(p2, p1, p3), 0.000001);
            assertEquals(90, MathHelper.getAngle(p3, p5, p6), 0.000001);
            assertEquals(0, MathHelper.getAngle(p2, p3, p4), 0.000001);
        }
    }
}