package com.sri.algo.linklist;

public class Stack<T> {

	private Node<T> top = null;

	public void push(T t) {
		Node<T> node = new Node<T>(t);

		if (top == null) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
	}

	public T pop() {
		Node<T> node = top;
		top = top.next;

		return node.data;
	}

	public String toString() {
		StringBuilder elements = new StringBuilder();

		if (top != null) {
			Node<T> entry = top;
			while (entry != null) {
				elements.append(entry.data);
				entry = entry.next;

				elements.append("-->");
				if (entry == null) {
					elements.append("null");
				}
			}

		}

		return elements.toString();
	}

	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();

		stack.push("ram");
		stack.push("raj");
		stack.push("raghu");
		stack.push("sandeep");

		System.out.println(stack);

		System.out.println("Popped: " + stack.pop());
		System.out.println("Popped: " + stack.pop());

		System.out.println(stack);

	}

}
