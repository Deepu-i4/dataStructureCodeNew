package com.firstclass.arrray.Interview;

public class ReverseArrayInMemory {

	// the running time complexity is O(N) + in-place algorithm (no need for extra
	// memory)
	public static void reverse(int[] nums) {
		int endIndex = nums.length - 1;
		int startIndex = 0;
		// we swap 2 items in 1 iteration: so we just have to make N/2 iterations
		while (startIndex < endIndex) {
			// swap two items with index endIndex and startIndex
			doSwap(nums, startIndex, endIndex);
			// increment and decrement the indexes
			startIndex++;
			endIndex--;
		}
	}

	public static void doSwap(int[] nums, int startIndex, int endIndex) {
		int temp = nums[startIndex];
		nums[startIndex] = nums[endIndex];
		nums[endIndex] = temp;
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		reverse(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}

	}

}
