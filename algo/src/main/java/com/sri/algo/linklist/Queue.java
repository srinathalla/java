package com.sri.algo.linklist;

public class Queue<T> {

	private Node<T> front = null, rear = null;

	public Queue() {

	}

	public void enqueue(T t) {
		Node<T> node = new Node<T>(t);

		if (rear == null) {
			rear = node;
			front = node;
		} else {
			rear.next = node;
			rear = rear.next;
		}
	}

	public T dequeue() {
		Node<T> node = front;

		front = front.next;
		return node.data;
	}
	
	public String toString() {
		StringBuilder elements = new StringBuilder();

		if (front != null) {
			Node<T> entry = front;
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
		
		Queue<String> queue = new Queue<String>();
		
		queue.enqueue("ram");	
		queue.enqueue("raj");
		queue.enqueue("raghu");
		queue.enqueue("sandeep");
		
		System.out.println(queue);
		
		queue.dequeue();
		queue.dequeue();
		
		System.out.println(queue);
		
	}

}
