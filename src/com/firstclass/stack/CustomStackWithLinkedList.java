package com.firstclass.stack;

class Node<T> {

	private Node<T> nextNode;
	private T data;

	public Node(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "" + data;
	}

}
public class CustomStackWithLinkedList<T> {
	// the LIFO last item we inserted is the first one we take out
	// when the pop() method is called
	private Node<T> head;
	private int count;

	// removes
	public T pop() {
		if (isEmpty()) {
			return null;
		}
		T data = head.getData();
		head = head.getNextNode();
		count--;
		return data;
	}

	public void push(T data) {
		count++;
		if (head == null) {
			head = new Node(data);
		} else {
			Node<T> oldHeadNode = head;
			head = new Node(data);
			head.setNextNode(oldHeadNode);
		}

	}

	// O(1)
	public boolean isEmpty() {
		return count == 0;
	}

	// O(1)
	public int size() {
		return count;
	}

	public static void main(String[] args) {
		CustomStackWithLinkedList<String> names = new CustomStackWithLinkedList<>();
		names.push("pushpendra");
		names.push("salma");
		names.push("radhe");
		names.push("vadhe");

		System.out.println("count :- " + names.count);
		while (!names.isEmpty()) {
			System.out.println(names.pop());
		}

	}
}
