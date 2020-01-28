package decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametersTest {

    Parameters parameters_individual;
    Parameters parameters_arrays;

    @BeforeEach
    void setUp() {
        parameters_individual = new Parameters(1.0, 2.0, 3.0, 4.0, 5.0,
                6.0, 7.0, 8.0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11);

        double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        parameters_arrays = new Parameters(doubles, ints);
    }

    @Nested
    @DisplayName("Test the epsilon field")
    class epsilonTests {
        @Test
        void individual() {
            assertEquals(1.0, parameters_individual.getEpsilon());
        }

        @Test
        void arrays() {
            assertEquals(1.0, parameters_arrays.getEpsilon());
        }
    }

    @Nested
    @DisplayName("Test the  length1 field")
    class length1Tests {
        @Test
        void individual() {
            assertEquals(2.0, parameters_individual.getLength1());
        }

        @Test
        void arrays() {
            assertEquals(2.0, parameters_arrays.getLength1());
        }
    }

    @Nested
    @DisplayName("Test the length2 field")
    class length2Tests {
        @Test
        void individual() {
            assertEquals(3.0, parameters_individual.getLength2());
        }

        @Test
        void arrays() {
            assertEquals(3.0, parameters_arrays.getLength2());
        }
    }

    @Nested
    @DisplayName("Test the radius1 field")
    class radius1Tests {
        @Test
        void individual() {
            assertEquals(4.0, parameters_individual.getRadius1());
        }

        @Test
        void arrays() {
            assertEquals(4.0, parameters_arrays.getRadius1());
        }
    }

    @Nested
    @DisplayName("Test the radius2 field")
    class radius2Tests {
        @Test
        void individual() {
            assertEquals(5.0, parameters_individual.getRadius2());
        }

        @Test
        void arrays() {
            assertEquals(5.0, parameters_arrays.getRadius2());
        }
    }

    @Nested
    @DisplayName("Test the area1 field")
    class area1Tests {
        @Test
        void individual() {
            assertEquals(6.0, parameters_individual.getArea1());
        }

        @Test
        void arrays() {
            assertEquals(6.0, parameters_arrays.getArea1());
        }
    }

    @Nested
    @DisplayName("Test the area2 field")
    class area2Tests {
        @Test
        void individual() {
            assertEquals(7.0, parameters_individual.getArea2());
        }

        @Test
        void arrays() {
            assertEquals(7.0, parameters_arrays.getArea2());
        }
    }

    @Nested
    @DisplayName("Test the dist field")
    class distTests {
        @Test
        void individual() {
            assertEquals(8.0, parameters_individual.getDist());
        }

        @Test
        void arrays() {
            assertEquals(8.0, parameters_arrays.getDist());
        }
    }

    @Nested
    @DisplayName("Test the qPts field")
    class qPtsTests {
        @Test
        void individual() {
            assertEquals(1, parameters_individual.getqPts());
        }

        @Test
        void arrays() {
            assertEquals(1, parameters_arrays.getqPts());
        }
    }

    @Nested
    @DisplayName("Test the quads field")
    class quadsTests {
        @Test
        void individual() {
            assertEquals(2, parameters_individual.getQuads());
        }

        @Test
        void arrays() {
            assertEquals(2, parameters_arrays.getQuads());
        }
    }

    @Nested
    @DisplayName("Test the nPts field")
    class nPtsTests {
        @Test
        void individual() {
            assertEquals(3, parameters_individual.getnPts());
        }

        @Test
        void arrays() {
            assertEquals(3, parameters_arrays.getnPts());
        }
    }

    @Nested
    @DisplayName("Test the kPts field")
    class kPtsTests {
        @Test
        void individual() {
            assertEquals(4, parameters_individual.getkPts());
        }

        @Test
        void arrays() {
            assertEquals(4, parameters_arrays.getkPts());
        }
    }

    @Nested
    @DisplayName("Test the aPts field")
    class aPtsTests {
        @Test
        void individual() {
            assertEquals(5, parameters_individual.getaPts());
        }

        @Test
        void arrays() {
            assertEquals(5, parameters_arrays.getaPts());
        }
    }

    @Nested
    @DisplayName("Test the bPts field")
    class bPtsTests {
        @Test
        void individual() {
            assertEquals(6, parameters_individual.getbPts());
        }

        @Test
        void arrays() {
            assertEquals(6, parameters_arrays.getbPts());
        }
    }

    @Nested
    @DisplayName("Test the cPts field")
    class cPtsTests {
        @Test
        void individual() {
            assertEquals(7, parameters_individual.getcPts());
        }

        @Test
        void arrays() {
            assertEquals(7, parameters_arrays.getcPts());
        }
    }

    @Nested
    @DisplayName("Test the dPts field")
    class dPtsTests {
        @Test
        void individual() {
            assertEquals(8, parameters_individual.getdPts());
        }

        @Test
        void arrays() {
            assertEquals(8, parameters_arrays.getdPts());
        }
    }

    @Nested
    @DisplayName("Test the ePts field")
    class ePtsTests {
        @Test
        void individual() {
            assertEquals(9, parameters_individual.getePts());
        }

        @Test
        void arrays() {
            assertEquals(9, parameters_arrays.getePts());
        }
    }

    @Nested
    @DisplayName("Test the fPts field")
    class fPtsTests {
        @Test
        void individual() {
            assertEquals(10, parameters_individual.getfPts());
        }

        @Test
        void arrays() {
            assertEquals(10, parameters_arrays.getfPts());
        }
    }

    @Nested
    @DisplayName("Test the gPts field")
    class gPtsTests {
        @Test
        void individual() {
            assertEquals(11, parameters_individual.getgPts());
        }

        @Test
        void arrays() {
            assertEquals(11, parameters_arrays.getgPts());
        }
    }
}