package com.sri.algo.linklist.leet;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

	Example 1:
	
	Input: 1->1->2
	Output: 1->2
 * @author salla
 *
 */
public class RemoveDuplicatesFromASortedList {
	
	public static class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	
	/**
	 * T.C : O (n)
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode curr = head;
		
		while (curr != null)
		{
			
			while (curr.val == curr.next.val)
			{
				curr = curr.next.next;
			}
			
			curr = curr.next;
		}
		
		return head;

	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		
	}

}
