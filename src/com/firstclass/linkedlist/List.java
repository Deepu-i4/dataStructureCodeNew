package com.firstclass.linkedlist;

public interface List<T extends Comparable<T>> {

	/**
	 * below 4 for custom implementation
	 */
	public void insert(T data);

	public void remove(T data);

	public void traverse();

	public int size();

	/**
	 * below both are for interview
	 */
	public void reverse();

	public Node<T> getMiddleNode();

}
