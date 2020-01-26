package decide;

public class Parameters {
    private double epsilon;
    private double length1;
    private double length2;
    private double radius1;
    private double radius2;
    private double area1;
    private double area2;
    private double dist;
    private int qPts;
    private int quads;
    private int nPts;
    private int kPts;
    private int aPts;
    private int bPts;
    private int cPts;
    private int dPts;
    private int ePts;
    private int fPts;
    private int gPts;

    /**
     * Initializes a newly created {@code Parameters} object, based on the input variables.
     * @param epsilon the epsilon value
     * @param length1 the lenght1 value
     * @param length2 the lenght2 value
     * @param radius1 the radius1 value
     * @param radius2 the radius2 value
     * @param area1 the area1 value
     * @param area2 the area2 value
     * @param dist the dist value
     * @param qPts the qPts value
     * @param quads the quads value
     * @param nPts the nPts value
     * @param kPts the kPts value
     * @param aPts the aPts value
     * @param bPts the bPts value
     * @param cPts the cPts value
     * @param dPts the dPts value
     * @param ePts the ePts value
     * @param fPts the fPts value
     * @param gPts the gPts value
     */
    public Parameters(double epsilon, double length1, double length2, double radius1, double radius2, double area1,
                      double area2, double dist, int qPts, int quads, int nPts, int kPts, int aPts, int bPts, int cPts,
                      int dPts, int ePts, int fPts, int gPts) {
        this.epsilon = epsilon;
        this.length1 = length1;
        this.length2 = length2;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.area1 = area1;
        this.area2 = area2;
        this.quads = quads;
        this.qPts = qPts;
        this.dist = dist;
        this.nPts = nPts;
        this.kPts = kPts;
        this.aPts = aPts;
        this.bPts = bPts;
        this.cPts = cPts;
        this.dPts = dPts;
        this.ePts = ePts;
        this.fPts = fPts;
        this.gPts = gPts;
    }

    /**
     * Initializes a newly created {@code Parameters} object, based on the the two input arrays.
     * The {@code doubleParameters} contains all the values for the fields that are of type {@code double} and the
     * {@code intParameters} contains all the values for the fields that are of type {@code int}.
     * @param doubleParameters The {@code double} array
     * @param intParameters The {@code int} array
     */
    public Parameters(double[] doubleParameters, int[] intParameters) {
        epsilon = doubleParameters[0];
        length1 = doubleParameters[1];
        length2 = doubleParameters[2];
        radius1 = doubleParameters[3];
        radius2 = doubleParameters[4];
        area1 = doubleParameters[5];
        area2 = doubleParameters[6];
        dist = doubleParameters[7];

        qPts = intParameters[0];
        quads = intParameters[1];
        nPts = intParameters[2];
        kPts = intParameters[3];
        aPts = intParameters[4];
        bPts = intParameters[5];
        cPts = intParameters[6];
        dPts = intParameters[7];
        ePts = intParameters[8];
        fPts = intParameters[9];
        gPts = intParameters[10];
    }

    /**
     * Getter function for the epsilon field.
     * @return the value of epsilon
     */
    public double getEpsilon() {
        return epsilon;
    }

    /**
     * Getter function for the length1 field.
     * @return the value of length1
     */
    public double getLength1() {
        return length1;
    }

    /**
     * Getter function for the length2 field.
     * @return the value of length2
     */
    public double getLength2() {
        return length2;
    }

    /**
     * Getter function for the radius1 field.
     * @return the value of radius1
     */
    public double getRadius1() {
        return radius1;
    }

    /**
     * Getter function for the radius1 field.
     * @return the value of radius1
     */
    public double getRadius2() {
        return radius2;
    }

    /**
     * Getter function for the area1 field.
     * @return the value of area1
     */
    public double getArea1() {
        return area1;
    }

    /**
     * Getter function for the area2 field.
     * @return the value of area2
     */
    public double getArea2() {
        return area2;
    }

    /**
     * Getter function for the qPts field.
     * @return the value of qPts
     */
    public int getqPts() {
        return qPts;
    }

    /**
     * Getter function for the quads field.
     * @return the value of quads
     */
    public int getQuads() {
        return quads;
    }

    /**
     * Getter function for the dist field.
     * @return the value of dist
     */
    public double getDist() {
        return dist;
    }

    /**
     * Getter function for the pts field.
     * @return the value of pts
     */
    public int getnPts() {
        return nPts;
    }

    /**
     * Getter function for the kPts field.
     * @return the value of kPts
     */
    public int getkPts() {
        return kPts;
    }

    /**
     * Getter function for the aPts field.
     * @return the value of aPts
     */
    public int getaPts() {
        return aPts;
    }

    /**
     * Getter function for the bPts field.
     * @return the value of bPts
     */
    public int getbPts() {
        return bPts;
    }

    /**
     * Getter function for the cPts field.
     * @return the value of cPts
     */
    public int getcPts() {
        return cPts;
    }

    /**
     * Getter function for the dPts field.
     * @return the value of dPts
     */
    public int getdPts() {
        return dPts;
    }

    /**
     * Getter function for the ePts field.
     * @return the value of ePts
     */
    public int getePts() {
        return ePts;
    }

    /**
     * Getter function for the fPts field.
     * @return the value of fPts
     */
    public int getfPts() {
        return fPts;
    }

    /**
     * Getter function for the gPts field.
     * @return the value of gPts
     */
    public int getgPts() {
        return gPts;
    }
}
