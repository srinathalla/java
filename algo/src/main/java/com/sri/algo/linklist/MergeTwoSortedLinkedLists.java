package com.sri.algo.linklist;

public class MergeTwoSortedLinkedLists {

	/**
	 * Time Complexity O(n + m). Auxillary space : O(1).
	 * 
	 * This uses recursion, code is much cleaner but this uses stack space. not
	 * preferable in production.
	 * 
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static Node<Integer> merge(Node<Integer> node1, Node<Integer> node2) {
		// If either of the nodes are null return other list.
		if (node1 == null) {
			return node2;
		}

		if (node2 == null) {
			return node1;
		}

		Node<Integer> mergedHead = null;

		if (node1.data < node2.data) {
			mergedHead = node1;
			mergedHead.next = merge(node1.next, node2);
		} else {
			mergedHead = node2;
			mergedHead.next = merge(node1, node2.next);
		}

		return mergedHead;
	}

	/**
	 * Time Complexity O(n + m). 
	 * Auxillary space : O(1).
	 * 
	 * 
	 * @param node1
	 * @param node2
	 * @return
	 */
	public static Node<Integer> mergeUsingIteration(Node<Integer> node1, Node<Integer> node2) {

		// Base conditions.
		if (node1 == null)
		{
			return node2;
		}
		
		if (node2 == null)
		{
			return node1;
		}
		
		
		Node<Integer> mergedHead = null, mergedTail = null, i = node1, j = node2;
		
		if (node1.data < node2.data)
		{
			mergedHead = node1;
			mergedTail = node1;
			i = i.next;
		}
		else
		{
			mergedHead = node2;
			mergedTail = node2;
			j = j.next;
		}

		while (i != null && j != null) 
		{
			if (i.data < j.data) 
			{	
				mergedTail.next = i;
				i = i.next;
			} 
			else {
				mergedTail.next = j;
			    j = j.next;
			}
			mergedTail = mergedTail.next;
		}

		// If one of the list is traversed, link other list to the merged list.
		mergedTail.next = i == null ? j : i;

		return mergedHead;
	}

	public static void printList(Node<Integer> root) {
		
		System.out.println();
		while (root != null) {
			System.out.print(root.data);
			System.out.print("-->");

			root = root.next;
			if (root == null) {
				System.out.print("null");
			}
		}
	}

	public static void main(String[] args) {

		Node<Integer> root1 = new Node<Integer>(10);
		root1.next = new Node<Integer>(20);
		root1.next.next = new Node<Integer>(30);

		Node<Integer> root2 = new Node<Integer>(15);
		root2.next = new Node<Integer>(17);
		root2.next.next = new Node<Integer>(30);

		// Node<Integer> ms1 = merge(root1, root2);

		// printList(ms1);
		
		Node<Integer> ms2 = mergeUsingIteration(root1, root2);

		printList(ms2);

	}

}
