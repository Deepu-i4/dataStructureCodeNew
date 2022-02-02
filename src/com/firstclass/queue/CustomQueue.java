package com.firstclass.queue;

class Node<T extends Comparable> {
	private T data;
	private Node<T> nextNode;

	public Node(T data, Node<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", nextNode=" + nextNode + "]";
	}

}

class Queue<T extends Comparable> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;

	public boolean isEmpty() {
		return null == this.firstNode;
	}

	public int size() {
		return count;
	}

	// O(1)
	public void enqueue(T newData) {
		this.count++;
		Node<T> oldNode = this.lastNode;
		this.lastNode = new Node(newData, oldNode);
		this.lastNode.setNextNode(null);
		if (isEmpty()) {
			this.firstNode = this.lastNode;
		} else {
			oldNode.setNextNode(this.lastNode);
		}
	}

	// O(1)
	public T dequeue() {
		this.count--;
		T dataToDeque = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		if (isEmpty()) {
			this.lastNode = null;
		}
		return dataToDeque;
	}

}

public class CustomQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(10);
		queue.enqueue(100);
		queue.enqueue(1000);

		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

	}

}
