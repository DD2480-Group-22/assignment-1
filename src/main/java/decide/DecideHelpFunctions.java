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

    public boolean conditionFunctionTwo(double epsilon, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionThree(double area, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionFour(int qPts, int quads, double[][] coordinates) {
        return true;
    }

    /**
     * Checks if there are at least one set of two consecutive data points with the second one having a lower X value than the first one.
     * @param coordinates The data points
     * @return {@code true} if there exits at least two data points that meat the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionFive(Point2D[] coordinates){
        if(coordinates.length < 2) return false;
        for (int i=0; i < (coordinates.length - 1); i++){
            if(coordinates[i].getX() > coordinates[i+1].getX()) return true;
        }
        return false;
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

    /**
     * Takes sets of 3 points, with {@code aPts} between the first and second, and {@code bPts} between the second and third points.
     * For each set it checks if the 3 selected points can all be contained within a circle of radius {@code radius1}.
     * @param aPts Points between the first and second point
     * @param bPts Points between the second and third point
     * @param nrPoints Number of data points
     * @param radius1 Radius of the circle that has to contain all 3 points
     * @param coordinates The data points
     * @return {@code true} if there exists a set of 3 points that meet the requirements, otherwise {@code false}
     */
    public static boolean conditionFunctionEight(int aPts, int bPts, int nrPoints, double radius1, Point2D[] coordinates) {
        if((aPts<0) || (bPts<0) || (nrPoints<(aPts + bPts + 3))) return false;
        for (int i=0; i < (coordinates.length - aPts - bPts - 2); i++){
            if(Math.max(Math.max(coordinates[i].distance(coordinates[i+aPts+1]), coordinates[i].distance(coordinates[i+aPts+bPts+2])),
                coordinates[i+bPts+1].distance(coordinates[i+aPts+1]))> (2*radius1)) 
                return true;
        }
        return false;
    }


    public boolean conditionFunctionNine(int cPts, int dPts, double epsilon, double[][] coordinates) {
        return true;
    }

    /**
     * Checks if there's at least one set of 3 points separated by exactly {@code ePts} and {@code fPts} consecutive
     * points in between them. These 3 points should also form a triangle with area greater than {@code area1}.
     * The functions iterates all over the coordinates array checking points separated by ePts and ePts + fPts from the first one
     * and then calculating the correct base and height depending on the geometry of the generated triangle, as there are 6 combinations
     * for different side lengths.   
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
    		b = coordinates[i+ePts];
    		c = coordinates[i+ePts+fPts];
    		
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
    				
    		if (area > area1) {
    			return true;
    		}
    				
    	}
    	
    	return false;
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
