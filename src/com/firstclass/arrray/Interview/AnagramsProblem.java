package com.firstclass.arrray.Interview;

import java.util.Arrays;

public class AnagramsProblem {

	public static void main(String[] args) {
		String subject = "restful";
		String anagrams = "fluster";
		System.out.println("Is Anagrams :- " + checkAnagrams(subject.toCharArray(), anagrams.toCharArray()));

		String subject1 = "restful";
		String anagrams1 = "pushpen";
		System.out.println("Is Anagrams :- " + checkAnagrams(subject1.toCharArray(), anagrams1.toCharArray()));
	}

	private static boolean checkAnagrams(char[] charArray1, char[] charArray2) {
		if (charArray1.length != charArray2.length)
			return false;
		// O(NlogN)
		Arrays.sort(charArray2);
		Arrays.sort(charArray1);

		// O(N)
		for (int i = 0; i < charArray1.length; i++) {
			if (charArray1[i] != charArray2[i])
				return false;
		}

		return true;
	}

}
