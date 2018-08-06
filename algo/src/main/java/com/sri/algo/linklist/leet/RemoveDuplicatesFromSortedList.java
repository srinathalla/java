package com.sri.algo.linklist.leet;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->3->4->4->5 Output: 1->2->5 Example 2:
 * 
 * Input: 1->1->1->2->3 Output: 2->3
 * 
 * @author salla
 *
 */
public class RemoveDuplicatesFromSortedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = null, curr = head;

		while (curr != null && curr.next != null) {

			if (curr.val == curr.next.val) {
				while (curr.next != null && curr.val == curr.next.val) {
					curr.next = curr.next.next;
				}

				if (prev != null) {
					prev.next = curr.next;
					curr = prev.next;
				} else {
					head = curr.next;
					curr = head;
				}
			}

			else {
				prev = curr;
				curr = curr.next;
			}
		}

		return head;
	}

	public ListNode deleteDuplicateswithFakeHead(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode curr = head;
		ListNode prev = fakeHead;

		while (curr != null && curr.next != null) {

			while (curr.next != null && curr.val == curr.next.val) {
				curr = curr.next;
			}

			if (prev.next != curr) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}

		return fakeHead.next;
	}

	public static void main(String[] args) {

		RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();

		/*
		 * ListNode head = new ListNode(1); head.next = new ListNode(2); head.next.next
		 * = new ListNode(3); head.next.next.next = new ListNode(3);
		 * head.next.next.next.next = new ListNode(4); head.next.next.next.next.next =
		 * new ListNode(4); head.next.next.next.next.next.next = new ListNode(5);
		 * 
		 * System.out.println(rd.deleteDuplicates(head));
		 */

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(1);
		head2.next.next = new ListNode(2);
		head2.next.next.next = new ListNode(2);
		head2.next.next.next.next = new ListNode(3);

		System.out.println(rd.deleteDuplicateswithFakeHead(head2));

	}

}
