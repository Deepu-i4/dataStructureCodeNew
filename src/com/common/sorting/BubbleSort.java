package com.common.sorting;

import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		bubbleSort();
		bubbleSort1();
	}

	private static void bubbleSort() {
		Integer arr[] = new Integer[] { 7, 4, 6, -2, 1, 19 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < (arr.length - i); j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void bubbleSort1() {
		Random random = new Random();
		int arr[] = new int[30000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10000);
		}

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < (arr.length - i); j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Time taken : - " + (endTime - startTime)+"ms");
	}
}
