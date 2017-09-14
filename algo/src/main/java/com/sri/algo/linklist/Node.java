package com.sri.algo.linklist;


public class Node<T> {

	T data;
	Node<T> next;
	Node<T> random;
	
	public Node(T data)
	{
		this.data = data;
	}
	
	public Node()
	{
		
	}

	Node<T> withData(T data) {
		this.data = data;
		return this;
	}

	Node<T> withNext(Node<T> next) {
		this.next = next;
		return this;
	}
	
	public T getData() {
		return data;
	}

}
