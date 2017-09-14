package com.sri.algo.linklist;

public class DetectLoopInLinkedList {

	/**
	 * Detects loop based on Floyd Cycle detection algorithm using fast and slow 
	 * pointers.
	 * 
	 * If both fast,slow pointers meet then linked list has cycle.
	 * 
	 * @param head
	 * @return
	 */
	public static <T> boolean detectLoop(Node<T> head) {
		Node<T> fast = head;
		Node<T> slow = head;

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		// i/p 1 ->2 ->3 -> 4 -> 2
		// Expected o/p : true

		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node4 = new Node<>(4);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;

		System.out.println(detectLoop(node1));

	}

}
