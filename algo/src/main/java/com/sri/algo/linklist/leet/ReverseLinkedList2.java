package com.sri.algo.linklist.leet;

public class ReverseLinkedList2 {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode curr, prev = dummy, next, prevListTail, reversedTail;

		int count = 1;

		while (count < m) {
			prev = prev.next;
			count++;
		}

		curr = prev.next;
		prevListTail = prev;
		reversedTail = curr;
		prev = null;
		while (count <= n && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

			count++;
		}

		prevListTail.next = prev;
		reversedTail.next = curr;

		return dummy.next;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ReverseLinkedList2 reverse = new ReverseLinkedList2();

		head = reverse.reverseBetween(head, 2, 5);

		System.out.println(head);

	}

}
