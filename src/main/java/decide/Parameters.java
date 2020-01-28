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
    private int q_pts;
    private int quads;
    private int n_pts;
    private int k_pts;
    private int a_pts;
    private int b_pts;
    private int c_pts;
    private int d_pts;
    private int e_pts;
    private int f_pts;
    private int g_pts;

    /**
     * Initializes a newly created {@code Parameters} object, based on the input variables.
     *
     * @param epsilon the epsilon value
     * @param length1 the lenght1 value
     * @param length2 the lenght2 value
     * @param radius1 the radius1 value
     * @param radius2 the radius2 value
     * @param area1   the area1 value
     * @param area2   the area2 value
     * @param dist    the dist value
     * @param q_pts    the qPts value
     * @param quads   the quads value
     * @param n_pts    the nPts value
     * @param k_pts    the kPts value
     * @param a_pts    the aPts value
     * @param b_pts    the bPts value
     * @param c_pts    the cPts value
     * @param d_pts    the dPts value
     * @param e_pts    the ePts value
     * @param f_pts    the fPts value
     * @param g_pts    the gPts value
     */
    public Parameters(double epsilon, double length1, double length2, double radius1, double radius2, double area1,
                      double area2, double dist, int q_pts, int quads, int n_pts, int k_pts, int a_pts, int b_pts, int c_pts,
                      int d_pts, int e_pts, int f_pts, int g_pts) {
        this.epsilon = epsilon;
        this.length1 = length1;
        this.length2 = length2;
        this.radius1 = radius1;
        this.radius2 = radius2;
        this.area1 = area1;
        this.area2 = area2;
        this.quads = quads;
        this.q_pts = q_pts;
        this.dist = dist;
        this.n_pts = n_pts;
        this.k_pts = k_pts;
        this.a_pts = a_pts;
        this.b_pts = b_pts;
        this.c_pts = c_pts;
        this.d_pts = d_pts;
        this.e_pts = e_pts;
        this.f_pts = f_pts;
        this.g_pts = g_pts;
    }

    /**
     * Initializes a newly created {@code Parameters} object, based on the the two input arrays.
     * The {@code doubleParameters} contains all the values for the fields that are of type {@code double} and the
     * {@code intParameters} contains all the values for the fields that are of type {@code int}.
     *
     * @param double_parameters The {@code double} array
     * @param int_parameters    The {@code int} array
     */
    public Parameters(double[] double_parameters, int[] int_parameters) {
        epsilon = double_parameters[0];
        length1 = double_parameters[1];
        length2 = double_parameters[2];
        radius1 = double_parameters[3];
        radius2 = double_parameters[4];
        area1 = double_parameters[5];
        area2 = double_parameters[6];
        dist = double_parameters[7];

        q_pts = int_parameters[0];
        quads = int_parameters[1];
        n_pts = int_parameters[2];
        k_pts = int_parameters[3];
        a_pts = int_parameters[4];
        b_pts = int_parameters[5];
        c_pts = int_parameters[6];
        d_pts = int_parameters[7];
        e_pts = int_parameters[8];
        f_pts = int_parameters[9];
        g_pts = int_parameters[10];
    }

    /**
     * Getter function for the epsilon field.
     *
     * @return the value of epsilon
     */
    public double getEpsilon() {
        return epsilon;
    }

    /**
     * Getter function for the length1 field.
     *
     * @return the value of length1
     */
    public double getLength1() {
        return length1;
    }

    /**
     * Getter function for the length2 field.
     *
     * @return the value of length2
     */
    public double getLength2() {
        return length2;
    }

    /**
     * Getter function for the radius1 field.
     *
     * @return the value of radius1
     */
    public double getRadius1() {
        return radius1;
    }

    /**
     * Getter function for the radius1 field.
     *
     * @return the value of radius1
     */
    public double getRadius2() {
        return radius2;
    }

    /**
     * Getter function for the area1 field.
     *
     * @return the value of area1
     */
    public double getArea1() {
        return area1;
    }

    /**
     * Getter function for the area2 field.
     *
     * @return the value of area2
     */
    public double getArea2() {
        return area2;
    }

    /**
     * Getter function for the qPts field.
     *
     * @return the value of qPts
     */
    public int getqPts() {
        return q_pts;
    }

    /**
     * Getter function for the quads field.
     *
     * @return the value of quads
     */
    public int getQuads() {
        return quads;
    }

    /**
     * Getter function for the dist field.
     *
     * @return the value of dist
     */
    public double getDist() {
        return dist;
    }

    /**
     * Getter function for the pts field.
     *
     * @return the value of pts
     */
    public int getnPts() {
        return n_pts;
    }

    /**
     * Getter function for the kPts field.
     *
     * @return the value of kPts
     */
    public int getkPts() {
        return k_pts;
    }

    /**
     * Getter function for the aPts field.
     *
     * @return the value of aPts
     */
    public int getaPts() {
        return a_pts;
    }

    /**
     * Getter function for the bPts field.
     *
     * @return the value of bPts
     */
    public int getbPts() {
        return b_pts;
    }

    /**
     * Getter function for the cPts field.
     *
     * @return the value of cPts
     */
    public int getcPts() {
        return c_pts;
    }

    /**
     * Getter function for the dPts field.
     *
     * @return the value of dPts
     */
    public int getdPts() {
        return d_pts;
    }

    /**
     * Getter function for the ePts field.
     *
     * @return the value of ePts
     */
    public int getePts() {
        return e_pts;
    }

    /**
     * Getter function for the fPts field.
     *
     * @return the value of fPts
     */
    public int getfPts() {
        return f_pts;
    }

    /**
     * Getter function for the gPts field.
     *
     * @return the value of gPts
     */
    public int getgPts() {
        return g_pts;
    }
}
