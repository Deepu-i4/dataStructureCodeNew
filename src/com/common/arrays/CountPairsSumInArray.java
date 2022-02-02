package com.common.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class CountPairsSumInArray {

	public static void main(String[] args) {
		// if you have unique number in array.
		int arr[] = new int[] { 1, 5, 7, -1, 5 };
		int sum = 6;
		System.out.println("Count of pairs is " + getPairsCount(arr, sum));

		System.out.println("----------------------------");

		// don't give proper results as number are not unique.
		int arr1[] = { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 };
		int sum1 = 11;
		System.out.println("Count of pairs is " + getPairsCount(arr1, sum1));

		System.out.println("----------------------------");

		// below solution works in case of duplicate number also.
		int arr2[] = { 1, 1, 1, 1 };
		int sum2 = 2;
		// Output : 6
		System.out.println(" 2 Count of pairs is " + getPairsCount2(arr2, sum2));

		System.out.println("----------------------------");

		// below solution works in case of duplicate number also.
		int arr3[] = { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 };
		int sum3 = 11;
		// Output : 9
		System.out.println(" 2 Count of pairs is " + getPairsCount1(arr3, sum3));

	}

	private static int getPairsCount(int arr[], int sum) {
		HashSet<Integer> hashSet = new HashSet();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (hashSet.contains(temp)) {
				System.out.println("pairs: " + temp + " : " + arr[i]);
				count++;
			}
			hashSet.add(arr[i]);
		}
		return count;
	}

	static int getPairsCount1(int arr[], int sum) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			// initializing value to 0, if key not found
			if (!hashMap.containsKey(arr[i]))
				hashMap.put(arr[i], 0);
			// increase the count if duplicate key found.
			hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
		}
		int twice_count = 0;
		// iterate through each element and increment the
		// count (Notice that every pair is counted twice)
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.get(sum - arr[i]) != null)
				twice_count += hashMap.get(sum - arr[i]);

			// if (arr[i], arr[i]) pair satisfies the
			// condition, then we need to ensure that the
			// count is decreased by one such that the
			// (arr[i], arr[i]) pair is not considered
			if (sum - arr[i] == arr[i])
				twice_count--;
		}
		// return the half of twice_count
		return twice_count / 2;
	}

	// same as getPairsCount1.
	static int getPairsCount2(int arr[], int sum) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			} else {
				hashMap.put(arr[i], 1);
			}
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.get(sum - arr[i]) != null) {
				count += hashMap.get(sum - arr[i]);
			}
			if (sum - arr[i] == arr[i]) {
				count--;
			}
		}

		return count / 2;
	}

}
