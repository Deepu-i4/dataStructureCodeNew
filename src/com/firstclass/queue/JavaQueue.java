package com.firstclass.queue;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {

	public static void main(String[] args) {
		// FIFO
		Queue<Integer> queue = new LinkedList<>();

		// add---enqueue -O(1)
		queue.add(10);
		queue.add(100);
		queue.add(1000);

		// element() ---O(1)
		System.out.println(queue.element());
		System.out.println(queue.size());

		System.out.println(queue.remove());
		System.out.println(queue.size());

		Queue<Task> queue1 = new LinkedList<>();

		// add---enqueue -O(1)
		queue1.add(new Task(1));
		queue1.add(new Task(2));
		queue1.add(new Task(3));

		while (!queue1.isEmpty()) {
			Task task = queue1.remove();
			task.execute();
		}

	}

}

//Suppose Operating System tasks.
class Task {
	private int id;

	public Task(int id) {
		this.id = id;
	}

	public void execute() {

		System.out.println("Executing task with id " + id);

	}

}
