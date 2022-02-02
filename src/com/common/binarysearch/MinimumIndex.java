package com.common.binarysearch;

/**
 * Find minimum index number. Find minimum index. Count of Left and right
 * Rotation.
 * 
 * @author Deepu Verma
 *
 */
public class MinimumIndex {

	public static void main(String a[]) {

		int[] intArray = new int[] { 2, 3, 4, 5, 1 };

		System.out.println("minimum number:- " + intArray[minimumIndex(intArray)]);
		System.out.println("minimum index:- " + minimumIndex(intArray));
		System.out.println("Rotation left :- " + minimumIndex(intArray));
		System.out.println("Rotation Right :- " + (intArray.length - minimumIndex(intArray)));
	}

	static int minimumIndex(int[] intArray) {
		int start = 0;
		int end = intArray.length - 1;
		int length = intArray.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % length;
			int prev = (mid + length - 1) % length;
			if (intArray[prev] > intArray[mid] && intArray[mid] < intArray[next]) {
				return mid;
			} else if (intArray[start] <= intArray[mid]) {
				start = mid + 1;
			} else if (intArray[start] >= intArray[mid]) {
				end = mid - 1;
			}
		}
		return -1;
	}
}
