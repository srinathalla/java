package com.sri.algo;

import com.sri.algo.linklist.LinkedList;

//Queue implementation using linked list.
public class MyQueue<T> {
	private LinkedList<T> delegatedLinkedList = new LinkedList<>();

	public void add(T data) {
		delegatedLinkedList.addEntryToTail(data);
	}

	public T remove() {
		T data = delegatedLinkedList.getRoot() != null ? delegatedLinkedList.getRoot().getData() : null;
		delegatedLinkedList.removeHead();
		return data;
	}

	public T peek() {
		return delegatedLinkedList.getRoot() != null ? delegatedLinkedList.getRoot().getData() : null;
	}

	public int size() {
		return delegatedLinkedList.length();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@SuppressWarnings("unchecked")
	public void addAll(T... elements) {
		for (T t : elements) {
			add(t);
		}
	}

	public String toString() {
		return delegatedLinkedList.toString();
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.addAll(1, 2, 3, 4, 5);
		System.out.println(queue.toString());

		queue.remove();
		queue.remove();
		System.out.println(queue.toString());
	}

}