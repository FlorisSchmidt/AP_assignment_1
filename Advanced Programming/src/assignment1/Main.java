package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private PrintStream out;

	static final int MAX_NUMBER_OF_ELEMENTS = 10;

	private boolean inputContainsCorrectSet(Scanner input, Set set){
		if(nextChar(input)!='{'){
			return false;
		}
		//TODO split input into identifiers and add them to the set
		return true;
	}

	private char nextChar(Scanner in) {
		return in.next().charAt(0); }

	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+"")); }

	// Method to check if the next character to be read when
	// calling nextChar() is a digit.

	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	}

	// Method to check if the next character to be read when
	// calling nextChar() is a letter.

	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]"); }

	private void calculateAndGiveOutput(){
	    //TODO make method
	}

	private boolean askSet(Scanner input, String question, Set set){
		do{
			out.print(question);
			if(! input.hasNextLine()) {
				out.print("\n");	//otherwise line with ˆD will be overwritten
				return false;
			}
		} while (!inputContainsCorrectSet(input,set));
		return true;
	}

	private boolean askBothSets(Scanner input, Set set1, Set set2) {
		return askSet(input, "Give first set : ", set1) &&
				askSet(input, "Give second set : ", set2);
	}
	
	private void start(){
		out = new PrintStream(System.out);
		Scanner in = new Scanner(System.in);
		Set set1 = new Set(),
				set2 = new Set();

		while(askBothSets(in,set1,set2)){
			calculateAndGiveOutput();
		}

	}

	public static void main(String[] args) {
		new Main().start();
	}

}
