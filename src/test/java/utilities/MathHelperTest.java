package utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

class MathHelperTest {
    @Nested
    @DisplayName("Tests for the getAngle function")
    class getAnglesTest {

        @Test
        public void testPointAngle() {
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