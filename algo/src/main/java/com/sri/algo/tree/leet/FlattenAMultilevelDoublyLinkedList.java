package com.sri.algo.tree.leet;

/**
 * You are given a doubly linked list which in addition to the next and previous
 * pointers, it could have a child pointer, which may or may not point to a
 * separate doubly linked list. These child lists may have one or more children
 * of their own, and so on, to produce a multilevel data structure, as shown in
 * the example below.
 * 
 * Flatten the list so that all the nodes appear in a single-level, doubly
 * linked list. You are given the head of the first level of the list.
 * 
 * Example:
 * 
 * Input: 1---2---3---4---5---6--NULL | 7---8---9---10--NULL | 11--12--NULL
 * 
 * Output: 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * 
 * @author salla
 *
 */
public class FlattenAMultilevelDoublyLinkedList {

	private static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {
		}

		public Node(int _val) {
			this.val = _val;
		}

		public Node(int _val, Node _prev) {
			val = _val;
			prev = _prev;
		}

		public Node(int _val, Node _prev, Node _next, Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	}

	public Node flatten(Node head) {

		flatten(head, new Node[] { null });

		return head;
	}

	public void flatten(Node curr, Node[] p) {

		if (curr == null) {
			return;
		}

		p[0] = curr;
		flatten(curr.child, p);

		if (curr.child != null) {
			p[0].next = curr.next;
			curr.next.prev = p[0];

			curr.next = curr.child;
			curr.child = null;
		}

		flatten(p[0].next, p);

	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2, head);
		head.next.next = new Node(3, head.next);
		head.next.next.next = new Node(4, head.next.next);
		head.next.next.child = new Node(7, head.next.next);
		head.next.next.child.next = new Node(8, head.next.next.child);
		head.next.next.child.next.child = new Node(11, head.next.next.child.next);

		FlattenAMultilevelDoublyLinkedList flattenAMultilevelDoublyLinkedList = new FlattenAMultilevelDoublyLinkedList();

		flattenAMultilevelDoublyLinkedList.flatten(head);

		System.out.println(head);

	}

}
