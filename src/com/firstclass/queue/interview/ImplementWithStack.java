package com.firstclass.queue.interview;

import java.util.Stack;

public class ImplementWithStack {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;

	public ImplementWithStack() {
		this.enqueueStack = new Stack<Integer>();
		this.dequeueStack = new Stack<Integer>();
		;
	}

	public void enqueue(int item) {
		this.enqueueStack.push(item);
	}

	public int dequeue() {
		if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		if (dequeueStack.isEmpty()) {
			while (!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}

	public static void main(String[] args) {

		ImplementWithStack implementWithStack = new ImplementWithStack();
		//System.out.println(implementWithStack.dequeue());
		implementWithStack.enqueue(10);
		implementWithStack.enqueue(30);
		implementWithStack.enqueue(60);

		System.out.println(implementWithStack.dequeue());
		implementWithStack.enqueue(31);
		implementWithStack.enqueue(62);
		System.out.println(implementWithStack.dequeue());
	}

}
