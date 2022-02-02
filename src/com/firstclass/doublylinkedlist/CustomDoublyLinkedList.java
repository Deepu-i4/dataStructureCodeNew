package com.firstclass.doublylinkedlist;

import java.util.LinkedList;

class Node<T extends Comparable<T>> {

	private Node<T> nextNode;
	private Node<T> previousNode;
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

	public Node<T> getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node<T> previousNode) {
		this.previousNode = previousNode;
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

class DoublyLinkedList<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;

	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		// this is the first item in the linkedList
		if (tail == null) {
			// both of the pointers are pointing to the new node
			tail = newNode;
			head = newNode;
		} else {
			// we have to insert the new item in the end of the list
			// we just have to manipulate the tail node and its references in O(1)
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}

	// lets traverse the list forward
	public void traverseForward() {
		Node<T> actualNode = head;

		while (actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}

	}

	// lets traverse the list backward
	public void traverseBackward() {
		Node<T> actualNode = tail;

		while (actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getPreviousNode();
		}

	}
}

public class CustomDoublyLinkedList {

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.addFirst("Adma");
		linkedList.addFirst("Salma");
		linkedList.addFirst("Deepu");
		
		linkedList.removeFirst();

		for (String name : linkedList) {
			System.out.println(name);
		}

		DoublyLinkedList<String> names = new DoublyLinkedList<>();
		names.insert("Adma");
		names.insert("Salma");
		names.insert("Deepu");
		names.insert("Radhe");
		System.out.println("--------------");
		names.traverseBackward();
		System.out.println("--------------");
		names.traverseForward();

	}

}
