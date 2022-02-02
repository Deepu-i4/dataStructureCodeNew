package com.firstclass.linkedlist.Interview;

import com.firstclass.linkedlist.LinkedList;
import com.firstclass.linkedlist.List;

/*
 * In-place algorithm
 */
public class ReverseLinkedList {

	public static void main(String[] args) {

		List<Integer> myLinkedList = new LinkedList<>();

		myLinkedList.insert(10);
		myLinkedList.insert(2);
		myLinkedList.insert(13);
		myLinkedList.insert(5);

		myLinkedList.traverse();
		myLinkedList.reverse();
		System.out.println("----------------");
		myLinkedList.traverse();

	}

}
