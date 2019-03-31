package com.sri.algo.linklist.leet;

public class PartitionList {
	
	public class ListNode {
		   int val;
		   ListNode next;
		   ListNode(int x) { val = x; }
		}
	
public ListNode partition(ListNode head, int x) {
	
		ListNode curr = head;
		ListNode before_head = new ListNode(0), before = before_head;
		ListNode after_head = new ListNode(0), after = after_head;

		while (curr != null) {
			if (curr.val < x) {
				before.next = curr;
				before = before.next;

			} else {
				after.next = curr;
				after = after.next;
			}

			curr = curr.next;
		}

		before.next = after_head.next;

		return before_head.next;
    }
}
