package decide;

public class DecideHelpFunctions {
	
	/**
	 * Checks two doubles to see if the first is to be considered equal, lesser or greater to another 
	 * @param a : First double variable
	 * @param b : Second double variable
	 * @return : 1 if a > b, 0 if a = b, -1 if a < b
	 */
	private static int elg(double a, double b) {
		double diff = a-b;
		
		if(Math.abs(diff) < 0.000001) {
			return 0;
		}
		if(diff > 0) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * Calculates and adds the distance between two 2D coordinates
	 * @param c1 : First coordinate
	 * @param c2 : Second coordinate
	 * @return : Distance between the two coordinates
	 */
	private static double distance(double[] c1, double[] c2) {
		double x_diff = c1[0] - c2[0];
		double y_diff = c1[1] - c2[1];
		
		double dist = Math.sqrt(x_diff*x_diff + y_diff*y_diff);
		
		return dist;
	}
	
	/**
	 * Takes an array of coordinates and returns true if two consecutive coordinates are at least the length apart
	 * @param length 	  : The minimum distance between coordinates for function to return true
	 * @param coordinates : The coordinates being measured
	 * @return			  : True if two consecutive coordinates are at at least the minimum distance, else false
	 */
    public static boolean conditionFunctionZero(double length, double[][] coordinates) {
    	if(coordinates.length < 2) return false;
    	
    	for(int i = 0; i < coordinates.length-1; ++i) {
    		double dist = distance(coordinates[i], coordinates[i+1]);
    		if(elg(dist, length) >= 0) {
    			return true;
    		}
    	}
        return false;
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

    public boolean conditionFunctionSix(int nPts, double dist, double[][] coordinates) {
        return true;
    }

    public boolean conditionFunctionSeven(int kPts, double length, double[][] coordinates) {
        return true;
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
