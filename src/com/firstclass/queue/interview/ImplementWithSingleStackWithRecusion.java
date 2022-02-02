package com.firstclass.queue.interview;

import java.util.Stack;

public class ImplementWithSingleStackWithRecusion {

	private Stack<Integer> stack;

	public ImplementWithSingleStackWithRecusion() {
		this.stack = new Stack<Integer>();
	}

	public void enqueue(int item) {
		this.stack.push(item);
	}

	//
	public int dequeue() {
		// base case for the recursion method calls the first item.
		// is what we are after
		if (stack.isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}

		if (stack.size() == 1) {
			return stack.pop();
		}

		// we keep on poping the items untill we find the last one
		int item = stack.pop();

		// we call the method recusively
		int lastDequeuedItem = dequeue();

		// after we find the item, we have to reinsert the items one by one.
		enqueue(item);

		// this is the item we are looking for( this is what have been popped off in the
		// stack.size()==1)
		return lastDequeuedItem;
	}

	public static void main(String[] args) {

		ImplementWithSingleStackWithRecusion implementWithStack = new ImplementWithSingleStackWithRecusion();
		// System.out.println(implementWithStack.dequeue());
		implementWithStack.enqueue(10);
		implementWithStack.enqueue(30);
		implementWithStack.enqueue(60);
		System.out.println(implementWithStack.dequeue());
	}

}
