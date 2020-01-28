package decide;

import java.awt.geom.Point2D;

public class DecideProgram {
    private int nr_points;
    private Point2D[] coordinates;
    private Parameters parameters;
    private Connectors[][] logical_connector_matrix;
    private boolean[] preliminary_unlocking_vector;

    /**
     * Initializes a newly created {@code DecideProgram} object based on the input parameters.
     *
     * @param nr_points  The number of points
     * @param points     A matrix containing the coordinates of the points
     * @param parameters A {@code Parameters} object
     * @param lcm        A logical connector matrix
     * @param puv        The preliminary unlocking vector
     */
    public DecideProgram(int nr_points, Point2D[] points, Parameters parameters, Connectors[][] lcm, boolean[] puv) {
        this.nr_points = nr_points;
        this.coordinates = points;
        this.parameters = parameters;
        this.logical_connector_matrix = lcm;
        this.preliminary_unlocking_vector = puv;
    }

    /**
     * Makes a decision based on the provided variables when the {@code DecideProgram} object was created.
     * Returns {@code true} if the provided variables satisfies the conditions for a launch, otherwise the function
     *
     * @return the decision
     */
    public boolean launch() {
        boolean[] cmv = createCMV();
        boolean[][] pum = new boolean[15][15];
        boolean[] fuv = new boolean[15];

        for (int i = 0; i < pum.length; i++) {
            for (int j = 0; j < pum[i].length; j++) {
                pum[i][j] = logicEvaluator(logical_connector_matrix[i][j], cmv[i], cmv[j]);
            }
        }

        for (int i = 0; i < pum.length; i++) {
            if (!preliminary_unlocking_vector[i]) {
                fuv[i] = true;
            } else {
                fuv[i] = evaluateBooleanArray(pum[i]);
            }
        }

        return evaluateBooleanArray(fuv);
    }

    private boolean[] createCMV() {
        return new boolean[]{
                DecideHelpFunctions.conditionFunctionZero(parameters.getLength1(), coordinates),
                DecideHelpFunctions.conditionFunctionOne(parameters.getRadius1(), coordinates),
                DecideHelpFunctions.conditionFunctionTwo(parameters.getEpsilon(), coordinates),
                DecideHelpFunctions.conditionFunctionThree(parameters.getArea1(), coordinates),
                DecideHelpFunctions.conditionFunctionFour(parameters.getqPts(), parameters.getQuads(), coordinates),
                DecideHelpFunctions.conditionFunctionFive(coordinates),
                DecideHelpFunctions.conditionFunctionSix(parameters.getnPts(), parameters.getDist(), coordinates),
                DecideHelpFunctions.conditionFunctionSeven(parameters.getkPts(), parameters.getLength1(), coordinates),
                DecideHelpFunctions.conditionFunctionEight(parameters.getaPts(), parameters.getbPts(), nr_points, parameters.getRadius1(), coordinates),
                DecideHelpFunctions.conditionFunctionNine(parameters.getcPts(), parameters.getdPts(), nr_points, parameters.getEpsilon(), coordinates),
                DecideHelpFunctions.conditionFunctionTen(parameters.getePts(), parameters.getfPts(), parameters.getArea1(), coordinates),
                DecideHelpFunctions.conditionFunctionEleven(parameters.getgPts(), nr_points, coordinates),
                DecideHelpFunctions.conditionFunctionTwelve(parameters.getkPts(), parameters.getLength1(), parameters.getLength2(), coordinates),
                DecideHelpFunctions.conditionFunctionThirteen(parameters.getaPts(), parameters.getbPts(), nr_points, parameters.getRadius1(), parameters.getRadius2(), coordinates),
                DecideHelpFunctions.conditionFunctionFourteen(parameters.getePts(), parameters.getfPts(), parameters.getArea1(), parameters.getArea2(), coordinates)
        };
    }

    private boolean logicEvaluator(Connectors connector, boolean value_a, boolean value_b) {
        if (Connectors.NOTUSED.equals(connector)) return true;
        if (Connectors.ANDD.equals(connector)) return value_a && value_b;
        return value_a || value_b;
    }

    private boolean evaluateBooleanArray(boolean[] fuv) {
        for (boolean value : fuv) if (!value) return false;
        return true;
    }
}
