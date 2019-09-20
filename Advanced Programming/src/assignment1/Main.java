package assignment1;

import java.io.PrintStream;

public class Main {

	private PrintStream out;

	private void start(){
		out = new PrintStream(System.out);
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
