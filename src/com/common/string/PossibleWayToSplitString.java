package com.common.string;

import java.util.HashMap;
import java.util.Map;

/**
 * In how many ways you can slit S into three parts such that each part contains the same number of letters 'a'
 * Count the number of ways to partition. Given a String S of length N,
 * returns the number of possible ways of splitting S as described.
 * S="babaa" function should return 2.
 * The possible splits are "ba|ba|a" and "bab|a|a"
 *  
 * @author Deepu Verma
 *
 */

class PossibleWayToSplitString {

	static int waysToSplitAdvanced(String inputString) {

		// edge cases.
		if (!inputString.contains("a")) {
			checkForBOnly(inputString.length());
		}

		if (checkFrequency(inputString) < 3) {
			return 0;
		}

		if (inputString.length() == 3 && inputString.contains("a")) {
			return 1;
		}

		int length = inputString.length();
		int answer = 0;
		for (int i = 1; i < length; i++) {
			for (int k = i + 1; k < length; k++) {
				int midCount = checkFrequency(inputString.substring(i, k));
				if (checkFrequency(inputString.substring(0, i)) == midCount) {
					if (checkFrequency(inputString.substring(k, length)) == midCount) {
						answer++;
					}
				}
			}
		}
		return answer;
	}
	// check frequency for 'a'
	public static int checkFrequency(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		return map.containsKey('a') ? map.get('a') : 0;
	}

	static int checkForBOnly(int len) {
		if (len < 3) {
			return 0;
		}
		if (len == 3) {
			return 1;
		}
		return checkForBOnly(len - 1) + len - 2;
	}

	public static void main(String[] args) {
		String inputString = "babaa";
		System.out.print(waysToSplitAdvanced(inputString));

	}
	
	static int waysToSplit(String inputString) {

		// edge cases.
		if (!inputString.contains("a")) {
			checkForBOnly(inputString.length());
		}

		if (checkFrequency(inputString) < 3) {
			return 0;
		}

		if (inputString.length() == 3 && inputString.contains("a")) {
			return 1;
		}

		int length = inputString.length();
		int answer = 0;
		for (int i = 1; i < length; i++) {
			for (int k = i + 1; k < length; k++) {
				String left = inputString.substring(0, i);
				int leftCount = checkFrequency(left);
				String mid = inputString.substring(i, k);
				int midCount = checkFrequency(mid);
				String right = inputString.substring(k, length);
				int rightCount = checkFrequency(right);
				if (leftCount == midCount && midCount == rightCount) {
					answer++;
					System.out.println(left + " : " + mid + " : " + right);
				}
			}
			System.out.println("------------");
		}

		return answer;

	}

}
