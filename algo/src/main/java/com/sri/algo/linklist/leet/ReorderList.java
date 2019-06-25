package com.sri.algo.linklist.leet;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
   reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

   You may not modify the values in the list's nodes, only nodes itself 
   may be changed.
   
 * @author salla
 *
 */
public class ReorderList {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void reorderList(ListNode head) {
		
		if (head == null || head.next == null)
		{
			return;
		}

		ListNode slow = head, fast = head.next;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode curr = slow.next, next = null, prev = null;

		slow.next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		ListNode head2 = prev, head1 = head;

		while (head1 != null && head2 != null) {
			next = head1.next;

			head1.next = head2;
			head1 = next;

			next = head2.next;

			head2.next = head1;
			head2 = next;
		}

	}
	
	public static void main(String[] args) {
		
		ReorderList rl = new ReorderList();
		
		ListNode head=  new ListNode(1);
		head.next = new ListNode(2);
		
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		rl.reorderList(head);
		
		while (head  != null)
		{
			System.out.print(head.val + "->");
			head = head.next;
		}
		
	}

}
