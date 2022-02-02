package com.firstclass.priorityqueue.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimizeSumPriorityQueue {

	public static int sumAndCost(List<Integer> list) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue(list);
		int sum = priorityQueue.poll();
		int cost = 0;
		while (!priorityQueue.isEmpty()) {
			int currentElement = priorityQueue.poll();
			if (currentElement < sum) {
				priorityQueue.add(sum);
				sum = currentElement;
			} else {
				sum += currentElement;
				cost += sum;
				continue;
			}

			sum += priorityQueue.poll();
			cost += sum;
		}

		return cost;
	}

	static int getMinSum(int arr[], int n) {
		int i, sum = 0;

		// Priority queue to store the elements of the array
		// and retrieve the minimum element efficiently
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// Add all the elements
		// to the prioriry queue
		for (i = 0; i < n; i++)
			pq.add(arr[i]);

		// While there are more than 1 elements
		// left in the queue
		while (pq.size() > 1) {

			// Remove and get the minimum
			// element from the queue
			int min = pq.poll();

			// Remove and get the second minimum
			// element (currently minimum)
			int secondMin = pq.poll();

			// Update the sum
			sum += (min + secondMin);

			// Add the sum of the minimum
			// elements to the queue
			pq.add(min + secondMin);
		}

		// Return the minimized sum
		return sum;
	}

	public static void main(String[] args) {

		// first way
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(7);
		list.add(4);
		System.out.println(sumAndCost(list));

		// second way
		int arr[] = { 1, 3, 7, 5, 6 };
		int n = arr.length;
		System.out.print(getMinSum(arr, n));

	}

}
