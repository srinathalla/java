package com.sri.algo.linklist.cp;

/**
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL rotate 2 steps to the right:
 * 4->5->1->2->3->NULL Example 2:
 * 
 * Input: 0->1->2->NULL, k = 4 Output: 2->0->1->NULL Explanation: rotate 1 steps
 * to the right: 2->0->1->NULL rotate 2 steps to the right: 1->2->0->NULL rotate
 * 3 steps to the right: 0->1->2->NULL rotate 4 steps to the right:
 * 2->0->1->NULL
 * 
 * @author salla
 *
 */
public class RotateList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {

		int count = 0;

		ListNode curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}

		if (k >= count) {
			k = k % count;
		}

		if (k == 0) {
			return head;
		}

		ListNode fast = head, slow = head;

		int i = 0;
		while (i != k) {
			fast = fast.next;
			i++;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		head = newHead;

		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		RotateList rl = new RotateList();

		head = rl.rotateRight(head, 2);
		
		System.out.println(head);
		
		
	}

}
