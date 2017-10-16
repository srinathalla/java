package com.sri.algo.linklist.duble;

public class DLL<T> {

	DLLNode<T> head;
	DLLNode<T> tail;

	public DLL() {
		this.head = null;
		this.tail = null;
	}

	public DLL(T t, int pageId) {
		DLLNode<T> dllNode = new DLLNode<T>(t, pageId);
		dllNode.next = null;
		dllNode.prev = null;

		head = tail = dllNode;
	}

	public DLLNode<T> addFirst(T t, int pageId) {

		DLLNode<T> node = new DLLNode<T>(t, pageId);
		node.prev = null;
		node.next = head;

		if (head == null) {
			head = node;
			tail = node;
		} else {
			// Link head.
			head.prev = node;
			head = head.prev;
		}

		return node;
	}

	public DLLNode<T> addFirst(DLLNode<T> node) {

		node.prev = null;
		node.next = head;
		
		if (head == null) {
			head = node;
			tail = node;
		} else {
			// Link head.
			head.prev = node;
			head = head.prev;
		}

		return node;
	}

	public DLLNode<T> removeFirst() {

		if (tail == head) {
			DLLNode<T> temp = head;
			head = tail = null;
			return temp;
		} else {
			DLLNode<T> temp = head;
			head = head.next;
			head.prev = null;

			return temp;
		}
	}

	public DLLNode<T> addLast(T t, int pageId) {

		DLLNode<T> node = new DLLNode<T>(t, pageId);
		node.prev = tail;
		node.next = null;

		// Link tail.
		tail.next = node;
		tail = tail.next;

		return node;
	}

	public DLLNode<T> addLast(DLLNode<T> node) {

		node.prev = tail;
		node.next = null;

		// Link tail.
		tail.next = node;
		tail = tail.next;

		return node;
	}

	public DLLNode<T> removeLast() {
		if (tail == head) {
			DLLNode<T> temp = head;
			head = tail = null;
			return temp;
		} else {
			DLLNode<T> temp = tail;
			tail = tail.prev;
			tail.next = null;

			return temp;
		}
	}

	public DLLNode<T> remove(DLLNode<T> valNode) {

		if (valNode == head) {
			removeFirst();
		}
		else if (valNode == tail) {
			removeLast();
		} else {
			valNode.prev.next = valNode.next;
			valNode.next.prev = valNode.prev;
		}

		return valNode;
	}

}
