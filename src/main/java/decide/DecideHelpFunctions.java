package decide;

import utilities.MathHelper;

import java.awt.geom.Point2D;

public class DecideHelpFunctions {

    /**
     * Takes an array of 2D coordinates and check if any two consecutive points are at a distance of length
     * apart. Returns true if such a pair is found, false otherwise.
     *
     * @param length      : The distance
     * @param coordinates : The array of coordinates
     * @return {@code true}	: If there exists two consecutive coordinates with distance greater than length.
     */
    public static boolean conditionFunctionZero(double length, Point2D[] coordinates) {
        for (int i = 0; i < coordinates.length - 1; ++i) {
            if (coordinates[i].distance(coordinates[i + 1]) > length) return true;
        }
        return false;
    }

    /**
     * Takes an array of coordinates and a radius. Checks to see if three consecutive coordinates in the array
     * cannot fit within a circle of the given radius. Returns true if the cannot fit, false otherwise.
     *
     * @param radius      : The radius of the circle
     * @param coordinates : The array of coordinates
     * @return {@code true} : If three consecutive coordinates cannot fit with a circle of given radius
     */
    public static boolean conditionFunctionOne(double radius, Point2D[] coordinates) {
        if (coordinates.length < 3) return false;

        for (int i = 0; i < coordinates.length - 2; ++i) {
            // Find the smallest possible circle
            // The smallest possible circle has either 2 or 3 points at the edge

            // If only 2 points are at the edge, then distance between them must
            // be at least 2*radius in order to return true
            if (coordinates[i].distance(coordinates[i + 1]) > radius * 2 ||
                    coordinates[i].distance(coordinates[i + 2]) > radius * 2 ||
                    coordinates[i + 1].distance(coordinates[i + 2]) > radius * 2) {
                return true;
            }

            // If the smallest circle is supported by all three points,
            // then a circle with given radius supported by two points with
            // its center lying towards the third point should encompass all
            Point2D point1 = coordinates[i];
            Point2D point2 = coordinates[i + 1];
            Point2D point3 = coordinates[i + 2];
            double dist = coordinates[i].distance(coordinates[i + 1]);
            if (dist < coordinates[i].distance(coordinates[i + 2])) {
                point1 = coordinates[i];
                point2 = coordinates[i + 2];
                point3 = coordinates[i + 1];
                dist = coordinates[i].distance(coordinates[i + 2]);
            }
            if (dist < coordinates[i + 1].distance(coordinates[i + 2])) {
                point1 = coordinates[i + 1];
                point2 = coordinates[i + 2];
                point3 = coordinates[i];
            }

            Point2D mid_point = new Point2D.Double(
                    (point1.getX() + point2.getX()) / 2,
                    (point1.getY() + point2.getY()) / 2
            );


            Point2D vector = new Point2D.Double(
                    -(point1.getY() - point2.getY()),
                    (point1.getX() - point2.getX())
            );

            //Normalize vector
            double d = Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY());
            vector.setLocation(vector.getX() / d, vector.getY() / d);

            dist = Math.sqrt(Math.pow(radius, 2) - Math.pow(mid_point.distance(coordinates[i]), 2));


            Point2D center1 = new Point2D.Double(mid_point.getX() + vector.getX() * dist,
                    mid_point.getY() + vector.getY() * dist);

            Point2D center2 = new Point2D.Double(mid_point.getX() - vector.getX() * dist,
                    mid_point.getY() - vector.getY() * dist);

            Point2D center = center1;
            if (center1.distance(point3) > center2.distance(point3)) {
                center = center2;
            }

            if (center.distance(point3) > radius) {
                return true;
            }
        }
        return false;
    }

    /**
     * Takes points from a Point2D array and checks if there is a set of 3 consecutive points that form an angle
     * that is either greater than (Pi + {@code epsilon}),
     * or lower than (Pi - {@code epsilon}). The second point is always the vertex of the angle, and if two of
     * the three poins are equal, the point is undefined.
     *
     * @param epsilon     Angle added and substracted from Pi for comparison (has to have an absolute value lower than Pi)
     * @param coordinates The data points
     * @return {@code true} if there exits at least three data points that meat the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionTwo(double epsilon, Point2D[] coordinates) {
        if ((coordinates.length < 3) || (Math.abs(epsilon) > Math.PI)) return false;
        for (int i = 1; i < (coordinates.length - 1); i++) {
            if (!(coordinates[i].equals(coordinates[i - 1]) && !(coordinates[i].equals(coordinates[i + 1])))) {
                if ((Math.abs(Math.toRadians(MathHelper.getAngle(coordinates[i], coordinates[i - 1], coordinates[i + 1])))) > (Math.PI + epsilon) ||
                        (Math.abs(Math.toRadians(MathHelper.getAngle(coordinates[i], coordinates[i - 1], coordinates[i + 1])))) < (Math.PI - epsilon))
                    return true;
            }
        }
        return false;
    }

    /**
     * Checks if three consecutive 2D coordinate points in an array form a triangle with area larger than the given input area.
     *
     * @param area        : The given area that the triangle must be larger than
     * @param coordinates : The array of 2D coordinates
     * @return {@code true} : If three consecutive points form a triangle with an area larger than the input area
     */
    public static boolean conditionFunctionThree(double area, Point2D[] coordinates) {
        if (coordinates.length < 3) return false;
        for (int i = 0; i < (coordinates.length - 2); ++i) {
            // If two points are at the same location, then the area is 0
            if (MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i + 1]) ||
                    MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i + 2]) ||
                    MathHelper.equalityCheckCoordinates(coordinates[i + 1], coordinates[i + 2])) {
                continue;
            }

            double triangle_area = MathHelper.triangleArea(coordinates[i], coordinates[i + 1], coordinates[i + 2]);

            // If the area is 0, the the points are on a line and does not form a triangle
            if (MathHelper.equal(triangle_area, 0)) {
                continue;
            }

            if (triangle_area > area && !MathHelper.equal(triangle_area, area)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if there are at least one set of {@code qPts} consecutive points on the same quadrant, on more
     * than {@code quads} quadrants, with checking priority of quadrants starting from I to IV (highest to lowest).
     *
     * @param qPts
     * @param quads
     * @param coordinates
     * @return {@code true} if there exists at least one set of points satisfying the previous criteria, otherwise {@code false}
     */
    public static boolean conditionFunctionFour(int qPts, int quads, Point2D[] coordinates) {
        Double x, y;
        int[] is_in_quad = new int[4];
        int total_quads;

        if (qPts < 2 || (coordinates.length - qPts) < 0 || quads > 3 || quads < 1) {
            return false;
        }


        for (int i = 0; i < coordinates.length - qPts; i++) {

            total_quads = 0;

            for (int j = 0; j < is_in_quad.length; j++) {
                is_in_quad[j] = 0;
            }

            for (int j = 0; j < qPts; j++) {
                x = coordinates[i + j].getX();
                y = coordinates[i + j].getY();

                if (x >= 0 && y >= 0) {
                    is_in_quad[0] = 1;
                } else if (x > 0 && y < 0) {
                    is_in_quad[1] = 1;
                } else if (x < 0 && y > 0) {
                    is_in_quad[2] = 1;
                } else {
                    is_in_quad[3] = 1;
                }
            }

            for (int j = 0; j < is_in_quad.length; j++) {
                total_quads += is_in_quad[j];
            }

            if (total_quads > quads) {
                return true;
            }

        }

        return false;
    }

    /**
     * Checks if there are at least one set of two consecutive data points with the second one having a lower X value than the first one.
     *
     * @param coordinates The data points
     * @return {@code true} if there exits at least two data points that meat the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionFive(Point2D[] coordinates) {
        if (coordinates.length < 2) return false;
        for (int i = 0; i < (coordinates.length - 1); i++) {
            if (coordinates[i].getX() > coordinates[i + 1].getX()) return true;
        }
        return false;
    }


    /**
     * Checks if there exists {@code nPts} consecutive data points such that at least one of the points lies a distance
     * greater than {@code dist} from the line joining the first and last of these {@code nPts} points.
     * If the first and last points of these {@code nPts} are identical, the distance from these points to all other
     * points of the {@code nPts} consecutive points will be calculated.
     *
     * @param nPts        The number of consecutive intervening points
     * @param dist        The distance to compare with
     * @param coordinates The data points
     * @return {@code true} if the requirements are meet, otherwise {@code false}
     */
    public static boolean conditionFunctionSix(int nPts, double dist, Point2D[] coordinates) {
        for (int i = 0; i < coordinates.length && (i + nPts - 1) < coordinates.length; i++) {
            for (int j = i + 1; j < (i + nPts - 1); j++) {
                if (MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i + nPts - 1])) {
                    if (coordinates[i].distance(coordinates[j]) > dist) return true;
                } else if (MathHelper.distanceToLine(coordinates[j], coordinates[i], coordinates[i + nPts - 1]) > dist) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are at least one set of two data points separated by exactly {@code kPts} consecutive intervening
     * points that are a distance greater than {@code length} apart from each other.
     *
     * @param kPts        The number of consecutive intervening points between the pair
     * @param length      The distance between the data points
     * @param coordinates The data points
     * @return {@code true} if there exits at least two data points that meet the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionSeven(int kPts, double length, Point2D[] coordinates) {
        if (coordinates.length < 3) return false;
        for (int i = 0; i < coordinates.length && (i + kPts + 1) < coordinates.length; i++) {
            Point2D pointA = coordinates[i];
            Point2D pointB = coordinates[i + (kPts + 1)];
            if (pointA.distance(pointB) > length) return true;
        }
        return false;
    }

    /**
     * Takes sets of 3 points from a Point2D array, with {@code aPts} between the first and second point,
     * and {@code bPts} between the second and third points.
     * The condition is met if there's a set that can't be contained by a circle of radius {@code radius1}.
     *
     * @param aPts        Points between the first and second point
     * @param bPts        Points between the second and third point
     * @param nrPoints    Number of data points
     * @param radius1     Radius of the circle that has to contain all 3 points
     * @param coordinates The data points
     * @return {@code true} if there exists at least one set of 3 points that cannot be contained within a circle
     * of radius {@code radius1}, otherwise {@code false}
     */
    public static boolean conditionFunctionEight(int aPts, int bPts, int nrPoints, double radius1, Point2D[] coordinates) {
        if ((aPts < 1) || (bPts < 1) || (nrPoints < (aPts + bPts + 3))) return false;
        for (int i = 0; i < (coordinates.length - aPts - bPts - 2); i++) {
            if (Math.max(Math.max(coordinates[i].distance(coordinates[i + aPts + 1]), coordinates[i].distance(coordinates[i + aPts + bPts + 2])),
                    coordinates[i + bPts + 1].distance(coordinates[i + aPts + 1])) > (2 * radius1))
                return true;
        }
        return false;
    }

    /**
     * Takes sets of 3 points from a Point2D array, with {@code cPts} between the first and second points,
     * and {@code dPts} between the second and third points.
     * Checks if there is a set of 3 points that form an angle that is either greater than (Pi + {@code epsilon}),
     * or lower than (Pi - {@code epsilon}). The second point is always the vertex of the angle, and if two of the three poins are equal,
     * the angle is undefined.
     *
     * @param cPts        Points between the first and second point
     * @param dPts        Points between the second and third point
     * @param nrPoints    Number of data points
     * @param epsilon     Angle added and substracted from Pi
     * @param coordinates The data points
     * @return {@code true} if there exists a set of 3 points that meet the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionNine(int cPts, int dPts, int nrPoints, double epsilon, Point2D[] coordinates) {
        if ((cPts < 1) || (dPts < 1) || (nrPoints < (cPts + dPts + 3))) return false;
        for (int i = 0; i < (coordinates.length - cPts - dPts - 2); i++) {
            if (((Math.abs(Math.toRadians(MathHelper.getAngle(
                    coordinates[i + cPts + 1], coordinates[i], coordinates[i + cPts + dPts + 2])))) > (Math.PI + epsilon)) ||
                    ((Math.abs(Math.toRadians(MathHelper.getAngle(
                            coordinates[i + cPts + 1], coordinates[i], coordinates[i + cPts + dPts + 2])))) < (Math.PI - epsilon)))
                return true;
        }
        return false;
    }

    /**
     * Checks if there's at least one set of 3 points separated by exactly {@code ePts} and {@code fPts} consecutive
     * points in between them. These 3 points should also form a triangle with area greater than {@code area1}.
     * The functions iterates all over the coordinates array checking points separated by ePts and ePts + fPts from the first one
     * and then calculating the correct base and height depending on the geometry of the generated triangle, as there are 6 combinations
     * for different side lengths.
     *
     * @param ePts
     * @param fPts
     * @param area1
     * @param coordinates
     * @return {@code true} only if it satisfies the previous criteria, otherwise {@code false}
     */
    public static boolean conditionFunctionTen(int ePts, int fPts, double area1, Point2D[] coordinates) {
        Point2D a, b, c;
        double base, height, area;
        double side_1, side_2, side_3;

        if (coordinates.length < 5 || ePts < 1 || fPts < 1 || (ePts + fPts) > (coordinates.length - 3)) {
            return false;
        }

        for (int i = 0; i < coordinates.length - (ePts + fPts); i++) {
            a = coordinates[i];
            b = coordinates[i + ePts];
            c = coordinates[i + ePts + fPts];

            side_1 = a.distance(b);
            side_2 = a.distance(c);
            side_3 = b.distance(c);

            if (side_1 < side_2 && side_1 > side_3) {
                base = side_2;
                height = side_1 * Math.sin(MathHelper.getAngle(a, b, c));
            } else if (side_3 < side_2 && side_3 > side_1) {
                base = side_2;
                height = side_3 * Math.sin(MathHelper.getAngle(c, a, b));
            } else if (side_2 < side_3 && side_2 > side_1) {
                base = side_3;
                height = side_2 * Math.sin(MathHelper.getAngle(c, a, b));
            } else if (side_1 < side_3 && side_1 > side_2) {
                base = side_3;
                height = side_1 * Math.sin(MathHelper.getAngle(b, a, c));
            } else if (side_2 < side_1 && side_2 > side_3) {
                base = side_1;
                height = side_2 * Math.sin(MathHelper.getAngle(a, b, c));
            } else {
                base = side_1;
                height = side_3 * Math.sin(MathHelper.getAngle(b, a, c));
            }

            area = base * height / 2;

            if (area > area1 && !MathHelper.equal(area, area1)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Checks if there are at least one set of two data points separated by exactly {@code gPts},
     * with the second one having a lower x value than the first one.
     *
     * @param gPts        Number of points between the two points comared
     * @param nrPoints    Number of data points
     * @param coordinates The data points
     * @return {@code true} if there exits at least two data points that meat the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionEleven(int gPts, int nrPoints, Point2D[] coordinates) {
        if ((gPts < 1) || (nrPoints < (2 + gPts))) return false;
        for (int i = 0; i < (coordinates.length - gPts - 1); i++) {
            if (coordinates[i].getX() > coordinates[i + gPts + 1].getX()) return true;
        }
        return false;
    }

    /**
     * Checks if there are two points, p1 and p2, that satisfy {@code |p1 - p2| > lenght1} and also another
     * (or the same) set of 2 points that satisfy {@code |p1 - p2| < length2}. If both conditions get to be true,
     * then it returns boolean value for true.
     *
     * @param kPts
     * @param length1
     * @param length2
     * @param coordinates
     * @return {@code true} if criteria is met, otherwise {@code false}
     */
    public static boolean conditionFunctionTwelve(int kPts, double length1, double length2, Point2D[] coordinates) {
        boolean cond_1 = false;
        boolean cond_2 = false;
        Point2D p1, p2;
        double dist;

        if (coordinates.length < 3 || length2 < 0 || kPts < 0) {
            return false;
        }

        for (int i = 0; i < coordinates.length - kPts - 1; i++) {
            p1 = coordinates[i];
            p2 = coordinates[i + kPts + 1];

            dist = p1.distance(p2);

            if (dist > length1 && !MathHelper.equal(dist, length1)) {
                cond_1 = true;
            }

            if (dist < length2 && !MathHelper.equal(dist, length2)) {
                cond_2 = true;
            }
        }

        return cond_1 && cond_2;
    }

    /**
     * Takes sets of 3 points from a Point2D array, with {@code aPts} between the first and second point, and {@code bPts}
     * between the second and third points.
     * For each set it checks if the 3 selected points cannot all be contained within a circle of radius {@code radius1}, and then
     * it checks if they can be contained on a circle of radius {@code radius2}.
     * If there's a set that can't be contained by de {@code radius1} circle, and a set that can be contained by the {@code radius2}
     * circle, the the condition is met, even if both sets are the same one.
     *
     * @param aPts        Points between the first and second point
     * @param bPts        Points between the second and third point
     * @param nrPoints    Number of data points
     * @param radius1     First ardius of the circle that has to contain all 3 points
     * @param radius2     Second radius of the circle that has to contain all 3 points
     * @param coordinates The data points
     * @return {@code true} if there exists a set of 3 points that meet the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionThirteen(int aPts, int bPts, int nrPoints, double radius1, double radius2, Point2D[] coordinates) {
        if ((aPts < 1) || (bPts < 1) || (nrPoints < (aPts + bPts + 3))) return false;
        boolean firstCondition = false;
        boolean secondCondition = false;
        for (int i = 0; i < (coordinates.length - aPts - bPts - 2); i++) {
            if (Math.max(Math.max(coordinates[i].distance(coordinates[i + aPts + 1]), coordinates[i].distance(coordinates[i + aPts + bPts + 2])),
                    coordinates[i + bPts + 1].distance(coordinates[i + aPts + 1])) > (2 * radius1))
                firstCondition = true;
            if (Math.max(Math.max(coordinates[i].distance(coordinates[i + aPts + 1]), coordinates[i].distance(coordinates[i + aPts + bPts + 2])),
                    coordinates[i + bPts + 1].distance(coordinates[i + aPts + 1])) < (2 * radius2))
                secondCondition = true;
            if (firstCondition && secondCondition) return true;

        }
        return false;
    }

    /**
     * Takes an array of 2D coordinates and checks if there exists three with with ePts and fPts consecutive points apart respectively
     * form a triangle. There exists a triangle with an area larger than area1 and a triangle smaller than area2, return true. Otherwise
     * return false.
     *
     * @param ePts        : Number of consecutive points between first and second points in the triangle
     * @param fPts        : Number of consecutive points between second and third points in the triangle
     * @param area1       : The area a triangle must be found larger than
     * @param area2       : The area a triangle must be found smaller than
     * @param coordinates : The array of coordinates
     * @return {@code true} : If a triangle is found larger than area1 and a triangle is found smaller than area2
     */
    public static boolean conditionFunctionFourteen(int ePts, int fPts, double area1, double area2, Point2D[] coordinates) {
        if (coordinates.length < 5) return false;

        boolean area1_condition = false;
        boolean area2_condition = false;

        // e_pts and f_pts for the interveing data points and 2 for the other data points in the triangle
        int l = coordinates.length - (ePts + fPts + 2);
        for (int i = 0; i < l; ++i) {

            int i1 = i + ePts + 1;
            int i2 = i + ePts + fPts + 2;

            // If two points are at the same location, then there is no triangle
            if (MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i1]) ||
                    MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i2]) ||
                    MathHelper.equalityCheckCoordinates(coordinates[i1], coordinates[i2])) {
                continue;
            }

            double triangle_area = MathHelper.triangleArea(coordinates[i], coordinates[i1], coordinates[i2]);

            // If the area is 0, the the points are on a line and does not form a triangle
            if (MathHelper.equal(triangle_area, 0)) {
                continue;
            }

            if (triangle_area > area1 && !MathHelper.equal(triangle_area, area1)) {
                area1_condition = true;
            }
            if (triangle_area < area2 && !MathHelper.equal(triangle_area, area2)) {
                area2_condition = true;
            }
        }

        return area1_condition && area2_condition;
    }
}