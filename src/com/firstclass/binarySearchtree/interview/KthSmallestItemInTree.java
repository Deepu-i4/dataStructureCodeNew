package com.firstclass.binarySearchtree.interview;

import com.firstclass.binarySearchtree.BinarySearchTree;
import com.firstclass.binarySearchtree.Tree;

public class KthSmallestItemInTree {

	public static void main(String[] args) {

		Tree<Integer> bst = new BinarySearchTree<>();

		bst.insert(2);
		bst.insert(55);
		bst.insert(67);
		bst.insert(12);
		bst.insert(11);

		System.out.println(bst.getKSmallest(bst.getRoot(), 2));
	}

}
