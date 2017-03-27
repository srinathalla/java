package com.sri.algo;

public class LinkedList<T> {

	private Node root;
	private Node tail;
	
	public Node getRoot() {
		return root;
	}

	public LinkedList<T> addEntry(T data) {
		Node entry = new Node().withData(data);
		root = root == null ? entry : entry.withNext(root);
		return this;
	}

	public LinkedList<T> addEntryToTail(T data) {
		Node entry = new Node().withData(data);
		root = root == null ? entry : root;
		tail = tail == null ? root : tail.withNext(entry).next;
		return this;
	}
	
	public LinkedList<T> removeHead() {
		
		root = root != null ? root.next : null;
		return this;
	}

	@SuppressWarnings("unchecked")
	public LinkedList<T> withDataSet(T... elements) {
		for (T element : elements) {
			addEntryToTail(element);
		}
		return this;
	}

	
	public String toString() {
		StringBuilder elements = new StringBuilder();

		Node entry = root;
		while (entry != null) {
			elements.append(entry.data);
			elements.append("-->");
			entry = entry.next;
		}
		
		elements.replace(elements.lastIndexOf("-->"), elements.length(), "");

		return elements.toString();
	}

	class Node {
		T data;
		Node next;

		Node withData(T data) {
			this.data = data;
			return this;
		}

		Node withNext(Node next) {
			this.next = next;
			return this;
		}
	}

	public static void main(String[] args) {
		
		LinkedList<Integer> myList = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5);		
		System.out.println(myList.toString());	
		
		myList.removeHead();	
		System.out.println(myList.toString());
	}

}
