package assignment1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		UtilSet set = new UtilSet();
		set.add('H');
		set.add('G');
		System.out.println(Arrays.toString(set.getValues()));
		set.remove('G');
		System.out.println(Arrays.toString(set.getValues()));
		set.add('K');
		System.out.println(set.isEmpty());
		set.clear();
		System.out.println(Arrays.toString(set.getValues()));
		System.out.println(set.isEmpty());
	}

}
