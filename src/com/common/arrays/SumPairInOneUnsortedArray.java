package com.common.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Arrays.sort uses dual-pivot Quicksort on primitives. It offers O(n log(n))
 * performance and is typically faster than traditional (one-pivot) Quicksort
 * implementations. However, it uses a stable, adaptive, iterative
 * implementation of mergesort algorithm for Array of Objects.
 *
 * Behind the scenes of parallelSort(), it breaks the array into different
 * sub-arrays (as per granularity in the algorithm of parallelSort). Each
 * sub-array is sorted with Arrays.sort() in different threads so that sort can
 * be executed in a parallel fashion and are merged finally as a sorted array.
 * The result of the Arrays.parallelSort is going to be the same as Array.sort
 * of course, it's just a matter of leveraging multi-threading.
 */
class SumPairInOneUnsortedArray {
	public static void main(String[] args) {
		// 1st Pointer solutions :- We can find only one pair here.
		Integer arr[] = new Integer[] { 12, 3, 5, 7, 4, 19, 26 };
		int sum = 19;
		if (!checkforSumPair(arr, sum))
			System.out.println("Sum doesnt exists");

		System.out.println("----------------------------");

		// 1st Pointer solutions :- We can find only one pair here.
		Integer arr1[] = new Integer[] { 0, -1, 2, -3, 1 };
		int sum1 = -2;
		checkforSumPair(arr1, sum1);

		System.out.println("----------------------------");

		// 2nd Hashing solutions :- We can find all the pairs here.
		Integer arr2[] = new Integer[] { 0, -1, 2, -3, 1, -4 };
		int sum2 = -2;
		printPairsUsingHashing(arr2, sum2);

		// Problem if it has duplicate numbers. // doesnt works
		System.out.println("----------------------------");
		Integer arr3[] = new Integer[] { 10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1 };
		int sum3 = 11;
		// Output : 9
		printPairsUsingHashingForDuplicate(arr3, sum3);

		// doesnt works
		System.out.println("----------------------------");
		Integer arr4[] = new Integer[] { 1, 1, 1, 1 };
		int sum4 = 2;
		// Output : 6
		printPairsUsingHashingForDuplicate(arr4, sum4);
	}

	/**
	 * Note: If there is more than one pair having the given sum then this algorithm
	 * reports only one. Can be easily extended for this though. Time Complexity:
	 * Depends on what sorting algorithm we use. If Merge Sort or Heap Sort is used
	 * then (-)(nlogn) in the worst case. If Quick Sort is used then O(n^2) in the
	 * worst case. Auxiliary Space: This too depends on sorting algorithm. The
	 * auxiliary space is O(n) for merge sort and O(1) for Heap Sort.
	 * 
	 */
	private static boolean checkforSumPair(Integer[] arr, int sum) {
		Arrays.parallelSort(arr);
		int right = arr.length - 1;
		int left = 0;
		while (left < right) {
			if (arr[left] + arr[right] == sum) {
				System.out.println("pair:- " + arr[left] + " : " + arr[right]);
				return true;
			}
			if (arr[left] + arr[right] > sum) {
				right--;
			} else // (arr[left] + arr[right] < sum)
				left++;
		}
		return false;

	}

	/**
	 * Time Complexity: O(n). As the whole array is needed to be traversed only
	 * once. Auxiliary Space: O(n). A hash map has been used to store array
	 * elements.
	 * 
	 */
	private static void printPairsUsingHashing(Integer[] arr, int sum) {
		HashSet<Integer> hashSet = new HashSet();
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (hashSet.contains(temp)) {
				System.out.println("Pair with given Sum :- " + sum + " is " + temp + " : " + arr[i]);
			}
			hashSet.add(arr[i]);
		}

	}

	// doesnt works
	private static void printPairsUsingHashingForDuplicate(Integer[] arr, int sum) {
		HashMap<Integer, Integer> hashMap = new HashMap();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			} else {
				hashMap.put(arr[i], 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			if (hashMap.get(sum - arr[i]) != null) {
				count = hashMap.get(sum - arr[i]);
				if (sum - arr[i] == arr[i])
					count--;
				System.out.println("dsad " + (sum - arr[i]) + " : " + arr[i] + " count: " + count);
				hashMap.remove(arr[i]);

			}
		}

	}

}
