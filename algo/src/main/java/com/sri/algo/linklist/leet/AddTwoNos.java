package com.sri.algo.linklist.leet;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 * 
 * @author salla
 *
 */
public class AddTwoNos {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode res = new ListNode(-1);
		int carry = 0;

		ListNode node1 = l1, node2 = l2, curr = res;
		while (node1 != null && node2 != null) {
			int val = node1.val + node2.val + carry;

			carry = val / 10;

			val = val % 10;
			curr.next = new ListNode(val);
			curr = curr.next;

			node1 = node1.next;
			node2 = node2.next;
		}

		while (node1 != null) {
			int val = node1.val + carry;

			carry = val / 10;

			val = val % 10;
			curr.next = new ListNode(val);
			curr = curr.next;

			node1 = node1.next;

		}

		while (node2 != null) {
			int val = node2.val + carry;

			carry = val / 10;

			val = val % 10;
			curr.next = new ListNode(val);
			curr = curr.next;

			node2 = node2.next;
		}

		if (carry > 0) {
			curr.next = new ListNode(carry);
			curr = curr.next;
		}

		curr.next = null;

		return res.next;
	}

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTwoNos add = new AddTwoNos();

		ListNode res = add.addTwoNumbers(l1, l2);
		System.out.println(res);

	}

}
