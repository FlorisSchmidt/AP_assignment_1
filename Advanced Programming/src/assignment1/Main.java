package assignment1;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	private PrintStream out;
	private static final int MAX_NUMBER_OF_ELEMENTS = 10;

	private boolean inputContainsCorrectSet(Scanner input, Set set) {
		StringBuffer inputString = new StringBuffer(input.nextLine());
		if(inputString.length()==0){
			return false;
		}
		if(inputString.charAt(0)!='{'){
			return throwError("Missing {");
		}
		if(inputString.charAt(inputString.length()-1)!='}'){
			return throwError("Missing }");
		}

		return initSet(inputString,set);
	}

	private boolean initSet(StringBuffer inputString, Set set){
		Scanner cleanInput = new Scanner(inputString.substring(1,inputString.length()-1));

		while(cleanInput.hasNext()) {
			if(!addElement(cleanInput, set)){
				set.init();
				return throwError("Incorrect input");
			}
			if(set.size()>MAX_NUMBER_OF_ELEMENTS){
				return throwError("To many identifiers");
			}
		}
		return true;
	}

	private boolean throwError(String error){
		out.print(error + "\n");
		return false;
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

}
