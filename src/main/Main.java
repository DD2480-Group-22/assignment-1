import java.lang.Math;

public class Main {
	
	// CONSTANT
	public static final double PI = 3.1415926535;
	
	// TYPE DECLARATIONS
	
	public static enum CONNECTORS{
				NOTUSED, 
				ORR, 
				ANDD};	
	
	public static enum COMPTYPE{
				LT, 
				EQ, 
				GT};
				
	class PARAMETERS_T{
		double LENGTH1;	// Length in LICs 0, 7, 12
		double RADIUS1;	// Radius in LICs 1, 8, 13
		double EPSILON;	// Deviation from PI in LICs 2, 9
		double AREA1;	// Area in LICs 3, 10, 14
		int Q_PTS;		// No. of consecutive points in LIC 4
		int QUADS;		// No. of quadrants in LIC 4
		double DIST;	// Distance in LIC 6
		int NPTS;		// No. of consecutive pts. in LIC 6
		int K_PTS;		// No. of int. pts in LICs 7, 12
		int A_PTS;		// No. of int. pts in LICs 8, 13
		int B_PTS;		// No. of int. pts in LICs 8, 13
		int C_PTS;		// No. of int. pts in LIC 9
		int D_PTS;		// No. of int. pts in LIC 9
		int E_PTS;		// No. of int. pts in LICs 10, 14
		int F_PTS;		// No. of int. pts in LICs 10, 14
		int G_PTS;		// No. of int. pts in LIC 11
		double LENGTH2;	// Maximum length in LIC 12
		double RADIUS2;	// Maximum radius in LIC 13
		double AREA2;	// Maximum area in LIC 14
	}
	
	// Global variable declarations
	
	public static PARAMETERS_T PARAMETERS;
	
	// X coordinates of data points
	public static double[] X;
	
	// Y coordinates of data points
	public static double[] Y;
	
	// Number of data points
	public static int NUMPOINTS;
	
	// Logical Connector Matrix
	public static CONNECTORS[][] LCM;
	
	// Preliminary Unlocking Matrix
	public static boolean[][] PUM;
	
	// Final Unlocking Vector
	public static boolean[] FUV;
	
	// Decision: Launch or No Launch
	public static boolean LAUNCH;
	
	// Compares floating point numbers
	public static COMPTYPE DOUBLECOMPARE(double A, double B) {
		if (Math.abs(A-B) < 0.000001) return COMPTYPE.EQ;
		if (A<B) return COMPTYPE.LT;
		return COMPTYPE.GT;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	
	// TODO: Write function
	public static void DECIDE() {
		
		// Final launch decision made here
		if(LAUNCH) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}



