package com.firstclass.binarySearchtree;

public class BinarySearchTreeApp {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(12);
		bst.insert(4);
		bst.insert(20);
		bst.insert(1);
		bst.insert(8);
		bst.insert(16);
		bst.insert(27);

		System.out.println(bst.getMax());
		System.out.println(bst.getMin());
		bst.traversal();
		bst.remove(16);
		bst.remove(20);
		bst.remove(12);
		bst.traversal();

		BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
		
		System.out.println("-------------------------");
		bst1.insert(new Person(12, "Adam"));
		bst1.insert(new Person(5, "Kevin"));
		bst1.insert(new Person(78, "Ana"));
		bst1.insert(new Person(56, "Michael"));
		bst1.insert(new Person(34, "Daniel"));
		bst1.insert(new Person(41, "Bill"));

		bst1.traversal();
	}

}
