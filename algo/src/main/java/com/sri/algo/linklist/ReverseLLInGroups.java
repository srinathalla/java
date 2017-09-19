package com.sri.algo.linklist;

public class ReverseLLInGroups {

	/**
	 * Linked list will be reversed in groups.
	 * 
	 *   i/p : a -> b -> c -> d -> e ->f 
	 *   k : 3
	 *   o/p : c -> b -> a -> f -> e -> d -> null
	 *   
	 *   Time Complexity O(n).
	 *   Auxillary Space : O(1).
	 *   
	 * @param head
	 * @param k
	 * @return
	 */
	public static <T> Node<T> reverseLLInGroup(Node<T> head, int k) {

		Node<T> prev = null, curr = head, next = null;
		int index = 0;

		// Reverse linked list of size k.
		while (curr != null && index < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			index++;
		}

		// If nodes are still present recursively call the same method.
		if (next != null) {
			head.next = reverseLLInGroup(next, k);
		}

		return prev;
	}

	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5, 6);

		Node<Integer> clonedList = reverseLLInGroup(ll.getRoot(), 3);

		System.out.println(new LinkedList<>(clonedList));
	}

}
