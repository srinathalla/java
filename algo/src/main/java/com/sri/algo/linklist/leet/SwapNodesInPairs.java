package com.sri.algo.linklist.leet;

public class SwapNodesInPairs {
	
	
	public static class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		}
	
	 public ListNode swapPairs(ListNode head) {
		 
		 
		 ListNode curr = head, prev= null,next = null;
		 
		 int count = 0;
		 
		 while (count < 2)
		 {
			 next = curr.next;
			 curr.next = prev;
			 prev = curr;
			 curr = next;
			 
			 count++;
		 }
		 
		 head.next = swapPairs(curr);
		 
		 return prev;
	        
	    }

}
