package com.sri.algo.linklist.leet;

public class PlusOneLinkedList {

	public ListNode plusOne(ListNode head) {

		if (head == null) {
			return new ListNode(1);
		}

		ListNode revhead = head = reverseList(head);

		int carry = 0;
		ListNode prev = null;
		while (head != null) {

			 carry = (++head.val) / 10;

			if (carry > 0) {
				head.val = 0;
				prev = head;
				head = head.next;
			}
			else
			{
				break;
			}
		}

		if (carry > 0) {
			head = new ListNode(1);
			prev.next = head;
		}

		head = reverseList(revhead);
		return head;
	}

	private ListNode reverseList(ListNode head) {

		ListNode prev = null, curr = head, next;

		while (curr != null) {
			next = curr.next;

			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {

		PlusOneLinkedList plusone = new PlusOneLinkedList();

		ListNode head = new ListNode(9);

		head.next = new ListNode(9);

		head.next.next = new ListNode(8);

		head = plusone.plusOne(head);

		System.out.println(head);

	}

}
