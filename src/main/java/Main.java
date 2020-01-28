import decide.DecideProgram;
import utilities.IOHandler;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
	    try {
			DecideProgram decide_program = new IOHandler().readTest("test_3.in");
			System.out.println(decide_program.launch());
		} catch (IOException e) {
	        System.err.println("Something went wrong while trying to read a file");
        } catch (Exception e) {
	        System.err.println(e.getMessage());
	        e.printStackTrace();
        }
	}
}



