package decide;

public class DecideProgram {
    private int numPoints;
    private double[][] coordinates;
    private Parameters parameters;
    private Connectors[][] logicalConnectorMatrix;
    private boolean[] preliminaryUnlockingVector;

    /**
     * Initializes a newly created {@code DecideProgram} object based on the input parameters.
     * @param numPoints The number of points
     * @param points A matrix containing the coordinates of the points
     * @param parameters A {@code Parameters} object
     * @param lcm A logical connector matrix
     * @param puv The preliminary unlocking vector
     */
    public DecideProgram(int numPoints, double[][] points, Parameters parameters, Connectors[][] lcm, boolean[] puv) {
        this.numPoints = numPoints;
        this.coordinates = points;
        this.parameters = parameters;
        this.logicalConnectorMatrix = lcm;
        this.preliminaryUnlockingVector = puv;
    }

    public DecideProgram() {

    }

    /**
     * Makes a decision based on the provided variables when the {@code DecideProgram} object was created.
     * Returns {@code true} if the provided variables satisfies the conditions for a launch, otherwise the function
     * returns {@code false}.
     * @return the decision
     */
    public boolean decide() {
        return true; //TODO implement the decide function
    }
}
