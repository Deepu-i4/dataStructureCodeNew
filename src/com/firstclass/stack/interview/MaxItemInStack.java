package com.firstclass.stack.interview;

import java.util.Stack;

public class MaxItemInStack {

	private Stack<Integer> mainStack;
	private Stack<Integer> maxStack;

	public MaxItemInStack() {
		this.mainStack = new Stack();
		this.maxStack = new Stack();
	}

	public void push(int item) {
		mainStack.push(item);

		// first item has to be inserted anyway.
		if (mainStack.size() == 1) {
			maxStack.push(item);
		}

		if (item < maxStack.peek()) {
			maxStack.push(maxStack.peek());
		} else {
			maxStack.push(item);
		}
	}

	public int getMaxItem() {
		return this.maxStack.peek();
	}

	// when removing an item we remove it from both stack
	public int pop() {
		maxStack.pop();
		return mainStack.pop();
	}

	public static void main(String[] args) {
		MaxItemInStack maxItemInStack = new MaxItemInStack();
		maxItemInStack.push(10);
		maxItemInStack.push(8);
		maxItemInStack.push(23);
		maxItemInStack.push(1);

		System.out.println(maxItemInStack.getMaxItem());

	}

}
