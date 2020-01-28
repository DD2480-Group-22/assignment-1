import decide.DecideProgram;
import utilities.IOHandler;

import java.io.IOException;

public class Main {

	private static final String[] TEST_FILES = {
			"program_test_1.in", "program_test_2.in", "program_test_3.in", "program_test_4.in"
	};

	public static void main(String[] args) {
		try {
			for (String arg : args) {
				executeProgram(Integer.parseInt(arg) - 1);
			}
		} catch (NumberFormatException e) {
			System.err.println("Only integers in the range 1 <= argument <= " + TEST_FILES.length + " are valid input to the program");
		}
		if (args.length == 0) {
			for (int i = 0; i < TEST_FILES.length; i++) {
				executeProgram(i);
			}
		}
	}

	private static void executeProgram(int index) {
		try {
			DecideProgram decideProgram = new IOHandler().readTest(TEST_FILES[index]);
			System.out.println("Result from file " + TEST_FILES[index] + ": the missile was" + (decideProgram.launch() ? "" : " not") + " launched");
		} catch (IOException e) {
			System.err.println("Something went wrong while trying to read a file");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}



