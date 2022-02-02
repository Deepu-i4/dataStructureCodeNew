package com.firstclass.doublylinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

	public static void main(String[] args) {

		addFirstPlace();
		addLastPlace();

	}

	private static void addLastPlace() {
		List<Integer> array = new ArrayList<>();
		long currentTime = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			array.add(i);
		}
		System.out.println("Time Taken for Arraylist at last index:- " + (System.currentTimeMillis() - currentTime));

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		long currentTime1 = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedList.addLast(i);
		}

		System.out.println("Time Taken for LinkedList at last index:- " + (System.currentTimeMillis() - currentTime1));
	}

	private static void addFirstPlace() {
		List<Integer> array = new ArrayList<>();
		long currentTime = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			array.add(0, i);
		}
		System.out.println("Time Taken for Arraylist at first index:- " + (System.currentTimeMillis() - currentTime));

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		long currentTime1 = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedList.addFirst(i);
		}

		System.out.println("Time Taken for LinkedList at first index:- " + (System.currentTimeMillis() - currentTime1));
	}
}
