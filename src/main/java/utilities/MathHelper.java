package utilities;

import java.awt.geom.Point2D;

public class MathHelper {
    /**
     * Computes the angle (in degrees) between the three points with {@code pointA} as a vertex. This function is based
     * on the angle function found in the JavaFX class Point2D.
     * @param pointA the fixed point
     * @param pointB one point
     * @param pointC other point
     * @return angle between the vectors (pointA, pointB) and (pointA, pointC) measured in degrees,
     * {@code NaN} if the three points are not different from one another
     * @throws NullPointerException if {@code pointA}, {@code pointB} or {@code pointC} is null
     */
    public static double getAngle(Point2D pointA, Point2D pointB, Point2D pointC) {
        final double x = pointA.getX();
        final double y = pointA.getY();

        final double ax = pointB.getX() - x;
        final double ay = pointB.getY() - y;
        final double bx = pointC.getX() - x;
        final double by = pointC.getY() - y;

        final double delta = (ax * bx + ay * by) / Math.sqrt(
                (ax * ax + ay * ay) * (bx * bx + by * by));

        if (delta > 1.0) {
            return 0.0;
        }
        if (delta < -1.0) {
            return 180.0;
        }

        return Math.toDegrees(Math.acos(delta));
    }
}