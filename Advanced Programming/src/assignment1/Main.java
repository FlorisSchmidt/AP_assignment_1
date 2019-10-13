package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	private PrintStream out;
	private static final int MAX_NUMBER_OF_ELEMENTS = 10;

	private boolean inputContainsCorrectSet(Scanner input, Set set) {
		Scanner s = new Scanner(input.nextLine());
		s.useDelimiter("");
		skipSpaces(s);

		if(!s.hasNext()){
			return throwError("Empty scanner",set);
		}
		if(!nextCharIs(s,'{')){
			return throwError("Set should start with a {",set);
		}
		nextChar(s);
		skipSpaces(s);
		if(!s.hasNext()){
			return throwError("Nothing after opening bracket",set);
		}

		return parseSet(s,set);
	}

	private boolean parseSet(Scanner s, Set set){
		if(nextCharIs(s,'}')){
			return true;
		}

		if(nextCharIsDigit(s)){
			return throwError("Identifier can't start with a number",set);
		}

		Identifier id = new Identifier();
		while(s.hasNext()){

			if(nextCharIsDigit(s) || nextCharIsLetter(s)){
				id.add(nextChar(s));
			} else if(nextCharIs(s, '}')){
				nextChar(s);
				skipSpaces(s);
				if(s.hasNext()){
					return throwError("No element allowed after }",set);
				}
				break;
			} else if(nextCharIs(s,' ')){
				skipSpaces(s);
				if(set.size()==MAX_NUMBER_OF_ELEMENTS){
					return throwError("To many identifiers",set);
				}
				set.add(id);
				return parseSet(s,set);
			} else {
				return throwError("Unsuspected char",set);
			}
		}
		return true;
	}

	private boolean throwError(String error, Set set){
		out.print(error + "\n");
		set.init();
		return false;
	}

	private void calculateAndGiveOutput(Set set1,Set set2){
		out.printf("difference = {%s}\n", setToString(set1.difference(set2)));
		out.printf("intersection = {%s}\n", setToString(set1.intersection(set2)));
		out.printf("union = {%s}\n", setToString(set1.union(set2)));
		out.printf("sym. diff. = {%s}\n", setToString(set1.symDifference(set2)));
	}

	private String setToString(Set set){
		String result = "";
		int size = set.size();
		for(int i = 0;i<size;i++) {
			result = result.concat(set.get().get() + " ");
		}
		if(result.length()!=0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
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
		Set set1 = new Set(), set2 = new Set();
		while(askBothSets(in,set1,set2)){
			out.print("\n");
			calculateAndGiveOutput(set1,set2);
			set1.init();
			set2.init();
		}

	}

	public static void main(String[] args) {
		new Main().start();
	}

	private char nextChar(Scanner in) {
		return in.next().charAt(0);
	}

	private boolean nextCharIs(Scanner in,char c) {
		return in.hasNext(Pattern.quote(c+""));
	}

	private boolean nextCharIsDigit(Scanner in) {
		return in.hasNext("[0-9]");
	}

	private boolean nextCharIsLetter(Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}

	private void skipSpaces(Scanner s){
		while(nextCharIs(s, ' ')) {
			nextChar(s);
		}
	}
}
