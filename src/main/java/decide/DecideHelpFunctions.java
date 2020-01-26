package decide;

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
