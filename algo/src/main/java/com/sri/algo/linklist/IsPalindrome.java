package com.sri.algo.linklist;

import java.util.Stack;

public class IsPalindrome {
	
	/**
	 * T.C O(n)
	 * Auxillary Space : O(n)
	 * 
	 * This uses stack.
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isPalindrome(Node<Integer> root)
	{	
		Stack<Node<Integer>> nodeStack = new Stack<>();
		
		Node<Integer> curr = root;	
		while (curr != null)
		{
			nodeStack.push(curr);
			curr = curr.next;
		}
		
		curr = root;	
		while (curr != null)
		{
			if (nodeStack.pop().data != curr.data)
			{
				return false;
			}
			curr = curr.next;
		}
		
		return true;
	}
	
	/**
	 *  T.C : O(n).
	 *  Auxillary space : O(1).
	 *  
	 * @param root
	 * @return
	 */
	public static boolean isPalindromeWithoutStack(Node<Integer> root)
	{
		if (root == null || root.next == null)
		{
			return false;
		}
		
		Node<Integer> fast = root,slow = root,fh = root,sh;	
		try
		{
			// Slow stops at mid point of the list.
			while (fast.next != null && fast.next.next != null)
			{
				fast = fast.next.next;
				slow = slow.next;
			}
			
			// Reverse the second half of the list.
			slow.next = reverse(slow.next);
			
			sh = slow.next;
			// first half and second half should be identical
			while(fh != slow)
			{
				if (fh.data != sh.data)
				{	
					return false;
				}
				
				fh = fh.next;
				sh = sh.next;
			}
		
			// This happens with even length list  1->2->2->1
			if(sh != null)
			{
				return fh.data == sh.data;
			}
		}
		finally
		{
			// Reverse the second half to get the original list.
			slow.next = reverse(slow.next);
		}
		
		return true;
	}
	
	private static Node<Integer> reverse(Node<Integer> head)
	{
		Node<Integer> prev = null,curr = head,next = null;
		
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1,2,2,1);
		
		System.out.println(isPalindrome(ll.getRoot()));
		
		System.out.println(isPalindromeWithoutStack(ll.getRoot()));
		
		PrintNodes.printList(ll.getRoot());
	}

}
