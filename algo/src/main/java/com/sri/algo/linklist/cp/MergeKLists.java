package com.sri.algo.linklist.cp;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * T.C : nlogk.
 * n is no of nodes, k is size of list.
 * 
 * Priority queue based implementation.
 * 
 * @author salla
 *
 */
public class MergeKLists {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		ListNode head = null, tail = null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode n1, ListNode n2) {

				return n1.val - n2.val;
			}
		});

		for (int i = lists.length -1; i >= 0; i--) {
			ListNode node = lists[i];
			if (node != null) {
				queue.add(node);
			}
		}

		while (!queue.isEmpty()) {

			ListNode node = queue.poll();
			if (node.next != null) {
				queue.add(node.next);
			}

			if (tail == null) {
				head = node;
				tail = node;
			} else {
				tail.next = node;
				tail = tail.next;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		
		ListNode[] lists = new ListNode[2];
		
		ListNode node5  = new ListNode(5);
		node5.next = new ListNode(7);
		
        ListNode node1  = new ListNode(1);
        node1.next = new ListNode(3);
        
        lists[0] = node5;
        lists[1] = node1;
        
        MergeKLists mergeKLists = new MergeKLists();
        
        ListNode head =  mergeKLists.mergeKLists(lists);
        
        while(head != null)
        {
        	System.out.print(head.val + " ");
        	head = head.next;
        }
		
		
	}

}
