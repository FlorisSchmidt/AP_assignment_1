package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private PrintStream out;
	public static final String IMPROPER_FORMAT_MESSAGE = "Input not properly formatted";
	static final int MAX_NUMBER_OF_ELEMENTS = 10;

	private boolean inputContainsCorrectSet(Scanner input, Set set){
		String setString = input.next();
		if(setString.charAt(0)!='{') {
			return false;
		}
		StringBuffer sb = new StringBuffer();
		int i = 1;
		int idx = 0;
		while(setString.charAt(i)!= '}') {
			while (true) {
				char c = setString.charAt(i);
				System.out.println(c);
				if (c == ',' || c == '}')  {
					i++;
					break;
				}
				sb.insert(idx, c);
				idx++;
				i++;
			}
			idx = 0;
			if (setString.charAt(i-1) == '}') break;
			addElement(sb.toString(), set);
			System.out.println("added to set");
			sb.delete(0, sb.length());
			idx = 0;
		}
		return true;
	}

	private boolean addElement(String word, Set set) {
		Identifier i = new Identifier();
		for (char c: word.toCharArray()) {i.add(c);}
		return set.add(i);
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
