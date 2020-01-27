package decide;

import utilities.MathHelper;

import java.awt.geom.Point2D;

public class DecideHelpFunctions {

    public boolean conditionFunctionZero(double length, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionOne(double radius, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionTwo(double epsilon, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionThree(double area, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionFour(int qPts, int quads, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionFive(double[][] coordinates) {
        return true;
    }


    /**
     * Checks if there exists {@code nPts} consecutive data points such that at least one of the points lies a distance
     * greater than {@code dist} from the line joining the first and last of these {@code nPts} points.
     * If the first and last points of these {@code nPts} are identical, the distance from these points to all other
     * points of the {@code nPts} consecutive points will be calculated.
     * @param nPts The number of consecutive intervening points
     * @param dist The distance to compare with
     * @param coordinates The data points
     * @return {@code true} if the requirements are meet, otherwise {@code false}
     */
    public static boolean conditionFunctionSix(int nPts, double dist, Point2D[] coordinates) {
        for (int i = 0; i < coordinates.length && (i + nPts - 1) < coordinates.length; i++) {
            for (int j = i + 1; j < (i + nPts - 1); j++) {
                if (MathHelper.equalityCheckCoordinates(coordinates[i], coordinates[i + nPts - 1])) {
                    if (coordinates[i].distance(coordinates[j]) > dist) return true;
                }
                else if (MathHelper.distanceToLine(coordinates[j], coordinates[i], coordinates[i + nPts - 1]) > dist) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are at least one set of two data points separated by exactly {@code kPts} consecutive intervening
     * points that are a distance greater than {@code length} apart from each other.
     * @param kPts The number of consecutive intervening points between the pair
     * @param length The distance between the data points
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

    public boolean conditionFunctionEight(int aPts, int bPts, int nrPoints, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionNine(int cPts, int dPts, double epsilon, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionTen(int ePts, int fPts, double area, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionEleven(int gPts, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionTwelve(int kPts, double length1, double length2, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionThirteen(int aPts, int bPts, double radius1, double radius2,
                                             double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionFourteen(int ePts, int fPts, double area1, double area2, double[][] coordinates) {
        return true;
    }
}
