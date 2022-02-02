package com.common.arrays;

/**
 * Find the size of Largest Subset with positive Bitwise AND. Given an array
 * arr[] consisting of N positive integers, the task is to find the largest size
 * of the subset of the array arr[] with positive Bitwise AND. Input: arr[] =
 * [7, 13, 8, 2, 3] Output: 3 Explanation: The subset having Bitwise AND
 * positive is {13, 7, 3} is of length 3, which is of maximum length among all
 * possible subsets. 1101(13) 0111(7) 0011(3) ------- 0001(1) ----------
 * 
 * @author Deepu Verma
 *
 */
public class LargestSubsetWithPositiveBitwise {

	public static void main(String[] args) {
		int arr[] = { 7, 13, 8, 2, 3 };
		int N = arr.length;
		largestSubset(arr, N);
	}

	private static void largestSubset(int[] arr, int n) {
		// Stores the number of set bits
		// at each bit position
		int bit[] = new int[32];

		// Traverse the given array arr[]
		for (int i = 0; i < n; i++) {
			// Current bit position
			int x = 31;
			// Loop till array element
			// becomes zero
			while (arr[i] > 0) {
				// If the last bit is set
				if ((int) (arr[i] & 1) == (int) 1) {
					// Increment frequency
					bit[x]++;
				}
				// Divide array element by 2
				arr[i] = arr[i] >> 1;

				// Decrease the bit position
				x--;

			}
		}
		// Size of the largest possible subset
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < 32; i++) {
			max = Math.max(max, bit[i]);
		}

		System.out.println(max);

	}

}
