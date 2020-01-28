package utilities;

import decide.Connectors;
import decide.DecideProgram;
import decide.Parameters;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class IOHandler {

    /**
     * Creates a new {@code DecideProgram} instance based on the content of the resource file specified by the
     * resource's file name. The function will throw an {@code IllegalArgumentException} if no resource with the
     * specified name can be found in the resource folder.
     *
     * @param file_name The name of the resource file
     * @return The created DecideProgram instance
     * @throws IOException If an error occur while trying to read the resource file
     */
    public DecideProgram readTest(String file_name) throws IOException {
        File file = getFileFromResources(file_name);
        try (FileReader file_reader = new FileReader(file);
             BufferedReader buffered_reader = new BufferedReader(file_reader)) {

            int nr_points = Integer.parseInt(buffered_reader.readLine());

            if (nr_points < 3) {
                throw new IllegalArgumentException("There needs to be at least 3 coordinates");
            }

            Point2D[] points = new Point2D[nr_points];

            for (int i = 0; i < nr_points; i++) {
                String line = buffered_reader.readLine();
                String[] coordinates = line.split(" ");
                points[i] = new Point2D.Double(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
            }

            double[] params_double = new double[8];

            for (int i = 0; i < params_double.length; i++) {
                params_double[i] = Double.parseDouble(buffered_reader.readLine());
            }


            int[] params_int = new int[11];

            for (int i = 0; i < 11; i++) {
                params_int[i] = Integer.parseInt(buffered_reader.readLine());
            }

            Connectors[][] connectors = new Connectors[15][15];

            for (int i = 0; i < connectors.length; i++) {
                String line = buffered_reader.readLine();
                String[] split_line = line.split(" ");

                for (int j = 0; j < split_line.length; j++) {
                    connectors[i][j] = Connectors.valueOf(split_line[j]);
                }
            }

            boolean[] puv = new boolean[15];

            for (int i = 0; i < 15; i++) {
                String boolean_value = buffered_reader.readLine();
                if (!(boolean_value.equals("true") || boolean_value.equals("false")))
                    throw new IllegalArgumentException("The values in the Preliminary Unlocking Vector has to be " +
                            "either true or false");
                puv[i] = Boolean.parseBoolean(boolean_value);
            }

            return new DecideProgram(nr_points, points, new Parameters(params_double, params_int), connectors, puv);
        }
    }

    /**
     * Creates a new {@code File} instance and returns it based on the provided file name.
     *
     * @param file_name the name of the resource
     * @return a {@code File} object for the specified
     * @throws IllegalArgumentException if no resource with the provided name ({@code fileName}) could be located
     */
    private File getFileFromResources(String file_name) {
        ClassLoader class_loader = getClass().getClassLoader();

        URL resource = class_loader.getResource(file_name);
        if (resource == null) {
            throw new IllegalArgumentException("The file " + file_name + " couldn't be found");
        } else {
            return new File(resource.getFile());
        }
    }
}
