package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private PrintStream out;
	public static final String IMPROPER_FORMAT_MESSAGE = "Input not properly formatted";
	static final int MAX_NUMBER_OF_ELEMENTS = 10;

	private boolean inputContainsCorrectSet(Scanner input, Set set) {
		StringBuffer inputString = new StringBuffer(input.nextLine());
		if(inputString.charAt(0)!='{'||inputString.charAt(inputString.length()-1)!='}'){
			return false;
		}

		Scanner cleanInput = new Scanner(inputString.substring(1,inputString.length()-1));

		while(cleanInput.hasNext()) {
			if(!addElement(cleanInput, set)){
				return false;
			}
		}
		return true;
	}

	private boolean addElement(Scanner input, Set set){
		Identifier id = new Identifier();
		String chars = input.next();
		for(int i = 0;i<chars.length();i++){
			if(id.add(chars.charAt(i))){
				continue;
			}
			return false;
		}
		return set.add(id);
	}

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
			out.print("\n");
			calculateAndGiveOutput();
		}

	}

	public static void main(String[] args) {
		new Main().start();
	}

}
