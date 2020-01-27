package utilities;

import java.awt.geom.Point2D;

public class MathHelper {
    private static final double EPSILON = 0.000001;
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

    /**
     * Calculates the shortest distance between {@code pointC} and the line formed by the two points {@code pointA}
     * and {@code pointB}
     * @param pointA the end of the line
     * @param pointB the start of the line
     * @param pointC the point being measured from
     * @return the shortest distance between {@code pointA} and the line formed by {@code pointB} and {@code pointC}
     * @throws IllegalArgumentException if {@code pointA} and {@code pointB} are the same point according to the
     *         {@code equalityCheckCoordinates} function
     */
    public static double distanceToLine(Point2D pointA, Point2D pointB, Point2D pointC) {
        final double xDelta = pointB.getX() - pointA.getX();
        final double yDelta = pointB.getY() - pointA.getY();

        final double distance = ((pointC.getX() - pointA.getX()) * xDelta + (pointC.getY() - pointA.getY()) * yDelta) /
                (Math.pow(xDelta, 2) + Math.pow(yDelta, 2));
        final Point2D closestPoint;
        if (distance < 0) {
            closestPoint = pointA;
        } else if (distance > 1) {
            closestPoint = pointB;
        } else {
            closestPoint = new Point2D.Double(pointA.getX() + distance * xDelta, pointA.getY() + distance *
                    yDelta);
        }

        return closestPoint.distance(pointC);
    }

    /**
     * Checks if two coordinates should be considered to represent the same point. The precision is set to
     * {@code EPSILON}
     * @param pointA A coordinate
     * @param pointB A coordinate
     * @return {@code true} if the difference between both coordinates are less then {@code EPSILON},
     *         otherwise {@code false}
     */
    public static boolean equalityCheckCoordinates(Point2D pointA, Point2D pointB) {
        return Math.abs(pointA.getX() - pointB.getX()) < EPSILON &&
                Math.abs(pointA.getY() - pointB.getY()) < EPSILON;
    }
    
    /**
     * Checks if the difference between two floating point numbers are less than EPSILON 
     * @param a : First floating point number
     * @param b : Second floating point number
     * @return {@code true} : If the difference is less than EPSILON
     */
    public static boolean equal(double a, double b) {
    	return Math.abs(a-b) < EPSILON;
    }

}