package com.common.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class SumPairInTwoUnsortedArray {

	public static void main(String[] args) {
		// if first array is not having duplicate record.
		int arr1[] = { 1, 2, 3, 7, 5, 4 };
		int arr2[] = { 0, 7, 4, 3, 2, 1 };
		int sum = 8;
		findPairs(arr1, arr2, sum);

		System.out.println("----------------------------");

		// if first array is having duplicate record.
		int arr3[] = { 1, 2, 4, 3, 7, 5, 4 };
		int arr4[] = { 0, 7, 4, 3, 2, 1 };
		// int arr4[] = { 0, 7, 4, 3, 2, 1 ,4};
		int sum1 = 8;
		findPairs1(arr3, arr4, sum1);
	}

	private static void findPairs(int[] arr1, int[] arr2, int sum) {

		HashSet<Integer> hashSet = new HashSet();
		for (int i = 0; i < arr1.length; i++) {
			hashSet.add(arr1[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			if (hashSet.contains(sum - arr2[i])) {
				System.out.println("Pairs :- " + (sum - arr2[i]) + " : " + arr2[i]);
			}
		}
	}

	private static void findPairs1(int[] arr1, int[] arr2, int sum) {

		HashMap<Integer, Integer> hashMap = new HashMap();
		for (int i = 0; i < arr1.length; i++) {
			if (hashMap.containsKey(arr1[i])) {
				hashMap.put(arr1[i], hashMap.get(arr1[i]) + 1);
			} else {
				hashMap.put(arr1[i], 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (hashMap.get(sum - arr2[i]) != null) {
				/*
				 * if (hashMap.get((sum - arr2[i])) > 1) { System.out.println("Pairs :- " + (sum
				 * - arr2[i]) + " : " + arr2[i]); }
				 */
				System.out.println("Pairs :- " + (sum - arr2[i]) + " : " + arr2[i] +": no. of pair for duplicate pairs " +hashMap.get((sum - arr2[i])));
			}
		}
	}

}
