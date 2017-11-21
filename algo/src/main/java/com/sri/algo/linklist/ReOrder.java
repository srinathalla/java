package com.sri.algo.linklist;

/**
 * Given a singly linked list: A0→A1→…→An-1→An, 
 * reorder it to:
 * A0→An→A1→An-1→A2→An-2→…
 * 
 * Given 1->2->3->4->5 its reorder is 1->5->2->4->3.
 * 
 * Time Complexity : O(n).
 * 
 * Idea is to reverse the second half of the list and merge both lists.
 * 
 *
 */
public class ReOrder {

	public static Node<Integer> reorderlist(Node<Integer> head) {
		
		Node<Integer> fast = head, slow = head;

		// Slow points to the mid of the linked list.
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			
			// In case of even length list slow  pointer will be at the lower end of mid position's.
			// i.e 1->2->3->4 slow points to 2 and not 3.
			if (fast != null) {
				slow = slow.next;
			}
		}

		// Reverse the second half of the linked list.
		Node<Integer> node1 = head, node2 = reverse(slow.next);

		// Link null to the end of the first linked list.
		slow.next = null;

		// Merge both linked lists 
		/*
		 * This is iterative merge of two linked lists.
		 * while (node1 != null) {
			if (merged == null) {
				merged = node1;
				node1 = node1.next;
			} else {
				merged.next = node1;
				node1 = node1.next;
				merged = merged.next;
			}

			merged.next = node2;
			node2 = node2 != null ? node2.next : node2;
			merged = merged.next;

		}*/
		
		return merge(node1,node2);

	}
	
	/**
	 * Recursive merge of two linked lists.
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	private static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2)
	{	
		if (node1 == null)
		{
			return node2;
		}
		
		if(node2 == null)
		{
			return node1;
		}
		
		Node<Integer> mergedHead = node1;
		node1 = node1.next;
		
		mergedHead.next = node2;
		node2 = node2.next;
		
		mergedHead.next.next = merge(node1, node2);
		
		return mergedHead;	
	}

	private static Node<Integer> reverse(Node<Integer> node) {
		Node<Integer> prev = null, curr = node, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1, 2, 3);

		Node<Integer> nl = reorderlist(ll.getRoot());

		PrintNodes.printList(nl);

		LinkedList<Integer> l2 = new LinkedList<Integer>().withDataSet(1, 7, 3, 4);

		Node<Integer> nl2 = reorderlist(l2.getRoot());

		PrintNodes.printList(nl2);
	}

}
