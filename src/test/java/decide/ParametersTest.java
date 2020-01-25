package decide;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ParametersTest {

    Parameters parametersIndividual;
    Parameters parametersArrays;

    @BeforeEach
    void setUp() {
        parametersIndividual = new Parameters(1.0, 2.0, 3.0, 4.0, 5.0,
                6.0, 7.0, 8.0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11);

        double[] doubles = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0};
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        parametersArrays = new Parameters(doubles, ints);
    }

    @Nested
    @DisplayName("Test the epsilon field")
    class epsilonTests {
        @Test
        void individual() {
            assertEquals(1.0, parametersIndividual.getEpsilon());
        }

        @Test
        void arrays() {
            assertEquals(1.0, parametersArrays.getEpsilon());
        }
    }

    @Nested
    @DisplayName("Test the  length1 field")
    class length1Tests {
        @Test
        void individual() {
            assertEquals(2.0, parametersIndividual.getLength1());
        }

        @Test
        void arrays() {
            assertEquals(2.0, parametersArrays.getLength1());
        }
    }

    @Nested
    @DisplayName("Test the length2 field")
    class length2Tests {
        @Test
        void individual() {
            assertEquals(3.0, parametersIndividual.getLength2());
        }

        @Test
        void arrays() {
            assertEquals(3.0, parametersArrays.getLength2());
        }
    }

    @Nested
    @DisplayName("Test the radius1 field")
    class radius1Tests {
        @Test
        void individual() {
            assertEquals(4.0, parametersIndividual.getRadius1());
        }

        @Test
        void arrays() {
            assertEquals(4.0, parametersArrays.getRadius1());
        }
    }

    @Nested
    @DisplayName("Test the radius2 field")
    class radius2Tests {
        @Test
        void individual() {
            assertEquals(5.0, parametersIndividual.getRadius2());
        }

        @Test
        void arrays() {
            assertEquals(5.0, parametersArrays.getRadius2());
        }
    }

    @Nested
    @DisplayName("Test the area1 field")
    class area1Tests {
        @Test
        void individual() {
            assertEquals(6.0, parametersIndividual.getArea1());
        }

        @Test
        void arrays() {
            assertEquals(6.0, parametersArrays.getArea1());
        }
    }

    @Nested
    @DisplayName("Test the area2 field")
    class area2Tests {
        @Test
        void individual() {
            assertEquals(7.0, parametersIndividual.getArea2());
        }

        @Test
        void arrays() {
            assertEquals(7.0, parametersArrays.getArea2());
        }
    }

    @Nested
    @DisplayName("Test the dist field")
    class distTests {
        @Test
        void individual() {
            assertEquals(8.0, parametersIndividual.getDist());
        }

        @Test
        void arrays() {
            assertEquals(8.0, parametersArrays.getDist());
        }
    }

    @Nested
    @DisplayName("Test the qPts field")
    class qPtsTests {
        @Test
        void individual() {
            assertEquals(1, parametersIndividual.getqPts());
        }

        @Test
        void arrays() {
            assertEquals(1, parametersArrays.getqPts());
        }
    }

    @Nested
    @DisplayName("Test the quads field")
    class quadsTests {
        @Test
        void individual() {
            assertEquals(2, parametersIndividual.getQuads());
        }

        @Test
        void arrays() {
            assertEquals(2, parametersArrays.getQuads());
        }
    }

    @Nested
    @DisplayName("Test the nPts field")
    class nPtsTests {
        @Test
        void individual() {
            assertEquals(3, parametersIndividual.getnPts());
        }

        @Test
        void arrays() {
            assertEquals(3, parametersArrays.getnPts());
        }
    }

    @Nested
    @DisplayName("Test the kPts field")
    class kPtsTests {
        @Test
        void individual() {
            assertEquals(4, parametersIndividual.getkPts());
        }

        @Test
        void arrays() {
            assertEquals(4, parametersArrays.getkPts());
        }
    }

    @Nested
    @DisplayName("Test the aPts field")
    class aPtsTests {
        @Test
        void individual() {
            assertEquals(5, parametersIndividual.getaPts());
        }

        @Test
        void arrays() {
            assertEquals(5, parametersArrays.getaPts());
        }
    }

    @Nested
    @DisplayName("Test the bPts field")
    class bPtsTests {
        @Test
        void individual() {
            assertEquals(6, parametersIndividual.getbPts());
        }

        @Test
        void arrays() {
            assertEquals(6, parametersArrays.getbPts());
        }
    }

    @Nested
    @DisplayName("Test the cPts field")
    class cPtsTests {
        @Test
        void individual() {
            assertEquals(7, parametersIndividual.getcPts());
        }

        @Test
        void arrays() {
            assertEquals(7, parametersArrays.getcPts());
        }
    }

    @Nested
    @DisplayName("Test the dPts field")
    class dPtsTests {
        @Test
        void individual() {
            assertEquals(8, parametersIndividual.getdPts());
        }

        @Test
        void arrays() {
            assertEquals(8, parametersArrays.getdPts());
        }
    }

    @Nested
    @DisplayName("Test the ePts field")
    class ePtsTests {
        @Test
        void individual() {
            assertEquals(9, parametersIndividual.getePts());
        }

        @Test
        void arrays() {
            assertEquals(9, parametersArrays.getePts());
        }
    }

    @Nested
    @DisplayName("Test the fPts field")
    class fPtsTests {
        @Test
        void individual() {
            assertEquals(10, parametersIndividual.getfPts());
        }

        @Test
        void arrays() {
            assertEquals(10, parametersArrays.getfPts());
        }
    }

    @Nested
    @DisplayName("Test the gPts field")
    class gPtsTests {
        @Test
        void individual() {
            assertEquals(11, parametersIndividual.getgPts());
        }

        @Test
        void arrays() {
            assertEquals(11, parametersArrays.getgPts());
        }
    }
}