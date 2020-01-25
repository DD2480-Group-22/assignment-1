package decide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideHelpFunctionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void conditionFunctionZero() {
    	DecideHelpFunctions f = new DecideHelpFunctions();
    	
    	int nr_coord = 10;
    	double[][] coord = new double[nr_coord][2];
    	
    	System.out.println("Testing function 0");
    	
    	// Maximum dist should be sqrt(2)
    	coord[0][0] = 1.0;
    	coord[0][1] = 1.0;
    	
    	assertTrue( f.conditionFunctionZero(1.0, coord) );
    	assertTrue( f.conditionFunctionZero(Math.sqrt(2), coord) );
    	assertFalse( f.conditionFunctionZero(Math.sqrt(2)+0.1, coord) );
    	assertFalse( f.conditionFunctionZero(2.0, coord) );
    	
    	// Test if it works at end of array
    	coord[0][0] = 0.0;
    	coord[0][1] = 0.0;
    	
    	coord[9][0] = 1.0;
    	coord[9][1] = 1.0;
    	
    	assertTrue( f.conditionFunctionZero(1.0, coord) );
    	assertTrue( f.conditionFunctionZero(Math.sqrt(2), coord) );
    	assertFalse( f.conditionFunctionZero(Math.sqrt(2)+0.1, coord) );
    	assertFalse( f.conditionFunctionZero(2.0, coord) );
    	
    	// Test larger coordinates
    	coord[8][0] = 4.0;
    	coord[8][1] = 3.0;

    	assertTrue( f.conditionFunctionZero(5.0, coord) );
    	assertTrue( f.conditionFunctionZero(4.5, coord) );
    	assertFalse( f.conditionFunctionZero(5.1, coord) );
    	
    	
    	// Test if all except last are a close the their neighbors
    	for(int i = 0; i < nr_coord; ++i) {
    		coord[i][0] = i;
    		coord[i][1] = i;
    	}
    	
    	coord[nr_coord-1][0] = nr_coord - 6.0;
    	coord[nr_coord-1][1] = nr_coord - 5.0;
    	
    	assertTrue( f.conditionFunctionZero(5.0, coord) );
    	assertTrue( f.conditionFunctionZero(4.5, coord) );
    	assertFalse( f.conditionFunctionZero(5.1, coord) );
    }

    @Test
    void conditionFunctionOne() {
    }

    @Test
    void conditionFunctionTwo() {
    }

    @Test
    void conditionFunctionThree() {
    }

    @Test
    void conditionFunctionFour() {
    }

    @Test
    void conditionFunctionFive() {
    }

    @Test
    void conditionFunctionSix() {
    }

    @Test
    void conditionFunctionSeven() {
    }

    @Test
    void conditionFunctionEight() {
    }

    @Test
    void conditionFunctionNine() {
    }

    @Test
    void conditionFunctionTen() {
    }

    @Test
    void conditionFunctionEleven() {
    }

    @Test
    void conditionFunctionTwelve() {
    }

    @Test
    void conditionFunctionThirteen() {
    }

    @Test
    void conditionFunctionFourteen() {
    }
}