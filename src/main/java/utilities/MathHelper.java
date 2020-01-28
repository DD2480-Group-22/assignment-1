package utilities;

import java.awt.geom.Point2D;

public class MathHelper {
    private static final double EPSILON = 0.000001;

    /**
     * Computes the angle (in degrees) between the three points with {@code pointA} as a vertex. This function is based
     * on the angle function found in the JavaFX class Point2D.
     *
     * @param point_a the fixed point
     * @param point_b one point
     * @param point_c other point
     * @return angle between the vectors (pointA, pointB) and (pointA, pointC) measured in degrees,
     * {@code NaN} if the three points are not different from one another
     * @throws NullPointerException if {@code pointA}, {@code pointB} or {@code pointC} is null
     */
    public static double getAngle(Point2D point_a, Point2D point_b, Point2D point_c) {
        final double x = point_a.getX();
        final double y = point_a.getY();

        final double ax = point_b.getX() - x;
        final double ay = point_b.getY() - y;
        final double bx = point_c.getX() - x;
        final double by = point_c.getY() - y;

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
     *
     * @param point_a the end of the line
     * @param point_b the start of the line
     * @param point_c the point being measured from
     * @return the shortest distance between {@code pointA} and the line formed by {@code pointB} and {@code pointC}
     * @throws IllegalArgumentException if {@code pointA} and {@code pointB} are the same point according to the
     *                                  {@code equalityCheckCoordinates} function
     */
    public static double distanceToLine(Point2D point_a, Point2D point_b, Point2D point_c) {
        final double x_delta = point_b.getX() - point_a.getX();
        final double y_delta = point_b.getY() - point_a.getY();

        final double distance = ((point_c.getX() - point_a.getX()) * x_delta + (point_c.getY() - point_a.getY()) * y_delta) /
                (Math.pow(x_delta, 2) + Math.pow(y_delta, 2));
        final Point2D closest_point;
        if (distance < 0) {
            closest_point = point_a;
        } else if (distance > 1) {
            closest_point = point_b;
        } else {
            closest_point = new Point2D.Double(point_a.getX() + distance * x_delta, point_a.getY() + distance *
                    y_delta);
        }

        return closest_point.distance(point_c);
    }

    /**
     * Checks if two coordinates should be considered to represent the same point.
     *
     * @param point_a A coordinate
     * @param point_b A coordinate
     * @return {@code true} if the difference between both coordinates are less then {@code EPSILON},
     * otherwise {@code false}
     */
    public static boolean equalityCheckCoordinates(Point2D point_a, Point2D point_b) {
        return equal(point_a.getX(), point_b.getX()) && equal(point_a.getY(), point_b.getY());
    }

    /**
     * Checks if the difference between two floating point numbers are less than EPSILON
     *
     * @param a : First floating point number
     * @param b : Second floating point number
     * @return {@code true} : If the difference is less than EPSILON
     */
    public static boolean equal(double a, double b) {
        return Math.abs(a - b) < EPSILON;
    }

    /**
     * Takes three 2D points and calculates the area of a triangle they form. Returns zero if they do not form a triangle.
     *
     * @param point_a : First point
     * @param point_b : Second point
     * @param point_c : Third point
     * @return : The area of the triangle, zero if there is no triangle
     */
    public static double triangleArea(Point2D point_a, Point2D point_b, Point2D point_c) {

        Point2D point1 = point_a;
        Point2D point2 = point_b;
        Point2D point3 = point_c;

        double dist = point_a.distance(point_b);
        if (dist < point_a.distance(point_c)) {
            point1 = point_a;
            point2 = point_c;
            point3 = point_b;
            dist = point_a.distance(point_c);
        }
        if (dist < point_b.distance(point_c)) {
            point1 = point_b;
            point2 = point_c;
            point3 = point_a;
        }

        double width = point1.distance(point2);
        double height = MathHelper.distanceToLine(point1, point2, point3);

        return width * height / 2;
    }
}