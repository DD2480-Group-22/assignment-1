import decide.DecideProgram;
import utilities.IOHandler;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
	    try {
            DecideProgram decideProgram = new IOHandler().readTest("test_1.in");
            decideProgram.decide();
        } catch (IOException e) {
	        System.err.println("Something went wrong while trying to read a file");
        } catch (Exception e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
        }
	}
}



