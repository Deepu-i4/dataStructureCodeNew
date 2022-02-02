package com.common.string;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given an array A consisting of Strings, your function should calculate the
 * length of the longest S such that:.
 * 1. S is a concatenation of some of the strings from A.
 * 2. Every Letter in S is different.
 * Given A=["co","dil","ity"] your function should return 5.
 * The resulting string S could be "codil","dilco","coity" or "ityco"
 * 
 * @author Deepu Verma
 *
 */

public class CountDistinctCharacterInString {

	public static void main(String[] args) {
		String na[] = { "co", "dil", "ity" };
		ArrayList<String> arrayString = new ArrayList();
		for (String string : na) {
			arrayString.add(string);
		}
		System.out.println(maxLength(arrayString));

	}

	private static int maxLength(ArrayList<String> arrayString) {
		ArrayList<String> allPossibleString = helper(arrayString, 0);
		int len = 0;

		for (int i = 0; i < allPossibleString.size(); i++) {
			len = len > allPossibleString.get(i).length() ? len : allPossibleString.get(i).length();
		}

		return len;
	}

	private static ArrayList<String> helper(ArrayList<String> arrayString, int ind) {
		ArrayList<String> allPossibleString = new ArrayList();
		allPossibleString.add("");

		// Base case
		if (ind == arrayString.size()) {
			return allPossibleString;
		}

		// Consider Every String as a starting substring and store the generated string.
		ArrayList<String> temp = helper(arrayString, ind + 1);

		ArrayList<String> ret = new ArrayList(temp);

		// Add current string to result of other strings and check if characters are
		// unique or not.
		for (int i = 0; i < temp.size(); i++) {
			String test = temp.get(i) + arrayString.get(ind);
			if (check(test)) {
				ret.add(test);
			}

		}

		return ret;
	}

	private static boolean check(String test) {
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < test.length(); i++) {
			if (hashSet.contains(test.charAt(i))) {
				return false;
			}
			hashSet.add(test.charAt(i));
		}
		return true;
	}

}
