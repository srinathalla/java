package com.sri.algo;

//Stack Implementation using linked list.
public class MyStack<T> {
	private LinkedList<T> delegatedLinkedList = new LinkedList<>();

	public void push(T t) {
		delegatedLinkedList.addEntry(t);
	}

	public T pop() {
		T data = delegatedLinkedList.getRoot().data;
		delegatedLinkedList.removeHead();
		return data;
	}

	public T peek() {
		return delegatedLinkedList.getRoot() != null ? delegatedLinkedList.getRoot().data : null;
	}

	@SuppressWarnings("unchecked")
	public void pushAll(T... elements) {
		for (T t : elements) {
			push(t);
		}
	}

	public String toString() {
		return delegatedLinkedList.toString();
	}

	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.pushAll(1, 2, 3, 4, 5);
		System.out.println(stack.toString());

		stack.pop();
		stack.pop();
		System.out.println(stack.toString());
	}

}