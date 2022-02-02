package com.firstclass.stack;

class Stack<T> {
	private T[] stack;
	private int count;

	public Stack() {
		stack = (T[]) new Object[1];
	}

	// we just have to add the new item to the end of the array O[1]
	public void push(T newData) {

		// Arrays are not dynamic data structure
		// we have to resize the underlying array if necessary
		// if there are too many item then we double the array
		// if there are too few items then we decrease the array
		if (count == stack.length) {
			resize(2 * count);
		}
		// we just have to insert into array
		// stack[count] = newData;
		// count++;
		stack[count++] = newData;
	}

	// return and removes the last item we have inserted O(1)
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T item = stack[--count];
		// Obsolete references - avoid memory leak
		// it is going to be one dimensional array and GC
		// will not able to remove then so set to null;
		stack[count] = null;

		// maybe we have to resize the array and decrease the size
		// the stack is 255 full only.
		if (count > 0 && count == stack.length / 4) {
			resize(stack.length / 2);
		}
		return item;
	}

	// O(1)
	public int size() {
		return count;
	}

	// O(1)
	public boolean isEmpty() {
		return count == 0;
	}

	// this is the bottleneck of the application O(N)
	private void resize(int capacity) {
		System.out.println("Need to resize the array --- ");
		T[] stackCopy = (T[]) new Object[capacity];
		for (int i = 0; i < count; i++) {
			stackCopy[i] = stack[i];
		}
		stack = stackCopy;
	}

}

public class CustomStackWithArrays<T> {

	public static void main(String[] args) {
		Stack<Integer> nums = new Stack<>();

		nums.push(1);
		nums.push(2);
		nums.push(3);
		nums.push(4);
		nums.push(5);
		nums.push(6);

		while (!nums.isEmpty())
			System.out.println(nums.pop());

	}
}
