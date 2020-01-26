package decide;

import java.awt.geom.Point2D;
import utilities.MathHelper;

public class DecideHelpFunctions {

    public boolean conditionFunctionZero(double length, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionOne(double radius, double[][] coordinates) {
        return true;
    }

    /**
     * Checks if there is a set of 3 consecutive points that form an angle that is either greater than (Pi + {@code epsilon}),
     * or lower than (Pi - {@code epsilon}). The second point is always the vertex of the angle, and if two of the three poins are equal,
     * the point is undefined.
     * @param epsilon Angle added and substracted from Pi for comparison (has to have an absolute value lower than Pi)
     * @param coordinates The data points
     * @return {@code true} if there exits at least three data points that meat the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionTwo(double epsilon, Point2D[] coordinates) {
        if ((coordinates.length < 3) || (Math.abs(epsilon) > Math.PI)) return false; 
        for (int i = 1; i < (coordinates.length - 1); i++){
            if (!(coordinates[i].equals(coordinates[i-1]) && !(coordinates[i].equals(coordinates[i+1])))){
                if ((Math.abs(Math.toRadians(MathHelper.getAngle(coordinates[i], coordinates[i-1], coordinates[i+1])))) > (Math.PI + epsilon) ||
                    (Math.abs(Math.toRadians(MathHelper.getAngle(coordinates[i], coordinates[i-1], coordinates[i+1])))) < (Math.PI - epsilon))
                    return true;
                }
            }
        return false;
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

    public boolean conditionFunctionSix(int nPts, double dist, double[][] coordinates) {
        return true;
    }

    /**
     * Checks if there are at least one set of two data points separated by exactly {@code kPts} consecutive intervening
     * points that are a distance greater than {@code length} apart from each other.
     * @param kPts The number of consecutive intervening points between the pair
     * @param length The distance between the data points
     * @param coordinates The data points
     * @return {@code true} if there exits at least two data points that meat the requirements, otherwise {@code false}
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
