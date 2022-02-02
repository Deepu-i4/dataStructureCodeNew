package com.firstclass.arrray.Interview;

public class RepetetionIntegerProblem {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 1, 2, 4, 3 };
		solve(array);
	}

	private static void solve(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[Math.abs(array[i])] > 0) {
				array[Math.abs(array[i])] = -array[Math.abs(array[i])];
			} else {
				System.out.println(Math.abs(array[i]) + " repetetion");
			}
		}

	}

}
