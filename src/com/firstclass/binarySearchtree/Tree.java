package com.firstclass.binarySearchtree;

public interface Tree<T> {

	public int getAgesSum();

	public Node<T> getKSmallest(Node<T> node, int k);

	public Node<T> getRoot();

	public void insert(T data);

	public void remove(T data);

	// in order yeilds the natural ordering.
	public void traversal();

	public T getMin();

	public T getMax();

}
