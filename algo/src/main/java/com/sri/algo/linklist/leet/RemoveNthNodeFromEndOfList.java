package com.sri.algo.linklist.leet;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 * @author salla
 *
 */
public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode fast = dummyHead, slow = dummyHead;

		while (n > 0) {
			fast = fast.next;
			n--;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return dummyHead.next;
	}

	public static void main(String[] args) {

		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);

		RemoveNthNodeFromEndOfList remove = new RemoveNthNodeFromEndOfList();

		listNode = remove.removeNthFromEnd(listNode, 2);
		System.out.println(listNode);

	}

}
