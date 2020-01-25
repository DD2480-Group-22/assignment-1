package utilities;

import decide.Connectors;
import decide.DecideProgram;
import decide.Parameters;

import java.io.*;
import java.net.URL;

public class IOHandler {

    /**
     * Creates a new {@code DecideProgram} instance based on the content of the resource file specified by the
     * resource's file name. The function will throw an {@code IllegalArgumentException} if no resource with the
     * specified name can be found in the resource folder.
     * @param fileName The name of the resource file
     * @return The created DecideProgram instance
     * @throws IOException If an error occur while trying to read the resource file
     */
    public DecideProgram readTest(String fileName) throws IOException {
        File file = getFileFromResources(fileName);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int nrPoints = Integer.parseInt(bufferedReader.readLine());
            double[][] points = new double[nrPoints][2];

            if (nrPoints < 3) {
                throw new IllegalArgumentException("There needs to be at least 3 coordinates");
            }

            for (int i = 0; i < nrPoints; i++) {
                String line = bufferedReader.readLine();
                String[] coordinates = line.split(" ");
                points[i][0] = Double.parseDouble(coordinates[0]);
                points[i][1] = Double.parseDouble(coordinates[1]);
            }

            double[] paramsDouble = new double[8];

            for (int i = 0; i < paramsDouble.length; i++) {
                paramsDouble[i] = Double.parseDouble(bufferedReader.readLine());
            }


            int[] paramsInt = new int[11];

            for (int i = 0; i < 11; i++) {
                paramsInt[i] = Integer.parseInt(bufferedReader.readLine());
            }

            Connectors[][] connectors = new Connectors[15][15];

            for (int i = 0; i < connectors.length; i++) {
                String line = bufferedReader.readLine();
                String[] splitLine = line.split(" ");

                for (int j = 0; j < splitLine.length; j++) {
                    if (Connectors.ANDD.toString().equals(splitLine[j])) {
                        connectors[i][j] = Connectors.ANDD;
                    } else if (Connectors.ORR.toString().equals(splitLine[j])) {
                        connectors[i][j] = Connectors.ORR;
                    } else if (Connectors.NOTUSED.toString().equals(splitLine[j])) {
                        connectors[i][j] = Connectors.NOTUSED;
                    }
                }
            }

            boolean[] puv = new boolean[15];

            for (int i = 0; i < 15; i++) {
                String booleanValue = bufferedReader.readLine();
                if (!(booleanValue.equals("true") || booleanValue.equals("false")))
                    throw new IllegalArgumentException("The values in the Preliminary Unlocking Vector has to be " +
                            "either true or false");
                puv[i] = Boolean.parseBoolean(booleanValue);
            }

            return new DecideProgram(nrPoints, points, new Parameters(paramsDouble, paramsInt), connectors, puv);
        }
    }

    /**
     * Creates a new {@code File} instance and returns it based on the provided file name.
     * @param fileName the name of the resource
     * @return a {@code File} object for the specified
     * @throws IllegalArgumentException if no resource with the provided name ({@code fileName}) could be located
     */
    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("The file " + fileName + " couldn't be found");
        } else {
            return new File(resource.getFile());
        }
    }
}
