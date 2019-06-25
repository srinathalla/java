package com.sri.algo.linklist.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sri.algo.array.PrintArray;

/**
		We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).

Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list with a head node value of 2, second node value of 1, and third node value of 5.

 

Example 1:

Input: [2,1,5]
Output: [5,5,0]
@author salla
 *
 */
public class NextLargerNodes {
	
	public static class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		}
		 

	public int[] nextLargerNodes(ListNode head) {
		
		List<Integer> a = new ArrayList<>();
		
		while(head != null)
		{
			a.add(head.val);
			head = head.next;
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[a.size()];
		
		for(int i=0; i < a.size(); i++)
		{
			while(!stack.isEmpty() && a.get(stack.peek()) < a.get(i))
			{
				res[stack.pop()] = a.get(i);
			}
			
			stack.push(i);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		
		NextLargerNodes nln = new NextLargerNodes();
		
		
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);
		
		
		int[] res = nln.nextLargerNodes(head);
		
		PrintArray.print(res);
		
	}
	
	

}
