package decide;

import utilities.MathHelper;

import java.awt.geom.Point2D;
import utilities.MathHelper;

public class DecideHelpFunctions {
	
	/**
	 * Takes an array of 2D coordinates and check if any two consecutive points are at a distance of length 
	 * apart. Returns true if such a pair is found, false otherwise.
	 * @param length		: The distance 
	 * @param coordinates	: The array of coordinates
	 * @return {@code true}	: If there exists two consecutive coordinates with distance greater than length.
	 */
    public static boolean conditionFunctionZero(double length, Point2D[] coordinates) {
    	for(int i = 0; i < coordinates.length-1; ++i) {
    		if(coordinates[i].distance(coordinates[i+1]) > length) return true;
    	}
        return false;
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
    
    /**
     * Checks if there are at least one set of {@code qPts} consecutive points on the same quadrant, on more 
     * than {@code quads} quadrants, with checking priority of quadrants starting from I to IV (highest to lowest).
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
        		x = coordinates[i+j].getX();
        		y = coordinates[i+j].getY();
        	
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
