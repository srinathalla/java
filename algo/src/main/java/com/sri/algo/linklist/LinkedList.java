package com.sri.algo.linklist;

public class LinkedList<T> {

	private Node<T> root;
	private Node<T> tail;
	private int count = 0;

	public int length() {
		return count;
	}

	public Node<T> getRoot() {
		return root;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	
	public LinkedList()
	{
		
	}
	
	public LinkedList(Node<T> root)
	{
		this.root = root;
	}

	public LinkedList<T> addEntry(T data) {
		Node<T> entry = new Node<T>().withData(data);
		root = root == null ? entry : entry.withNext(root);
		increment();
		return this;
	}

	public LinkedList<T> addEntryToTail(T data) {
		Node<T> entry = new Node<T>().withData(data);
		root = root == null ? entry : root;
		tail = tail == null ? root : tail.withNext(entry).next;
		increment();
		return this;
	}

	private void increment() {
		count++;
	}

	private void decrement() {
		count--;
	}

	public LinkedList<T> removeHead() {

		root = root != null ? root.next : null;

		decrement();
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

		if (root != null) {
			Node<T> entry = root;
			while (entry != null) {
				elements.append(entry.data);
				entry = entry.next;
				
				elements.append("-->");
				if (entry == null)
				{
					elements.append("null");
				}
			}

		}

		return elements.toString();
	}

	public static void main(String[] args) {

		LinkedList<Integer> myList = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5);
		System.out.println(myList.toString());

		myList.removeHead();
		System.out.println(myList.toString());
	}

}
