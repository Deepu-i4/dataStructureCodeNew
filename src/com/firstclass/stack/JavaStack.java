package com.firstclass.stack;

public class JavaStack {

	public static void main(String[] args) {
		java.util.Stack<String> stack = new java.util.Stack<>();
		stack.push("Adam");
		stack.push("Bill");
		stack.push("Jeff");
		stack.push("Elon");
		
		// peek() runs in O(1) and return the last item we have inserted.
		// without removing it.
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		// pop() O(1) that is going to remove the last item 
		// + return the value
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}

}
