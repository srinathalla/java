package com.sri.algo.linklist;

public class PairwiseSwapOfNodes {
	
	/**
	 * Linked list will be reversed in groups.
	 * 
	 *   i/p : a -> b -> c -> d -> e ->f 
	 *   
	 *   o/p : b -> a -> d -> c -> f -> e -> null
	 *   
	 *   Time Complexity O(n).
	 *   Auxillary Space : Uses stack space .
	 *   
	 * @param head
	 * @param k
	 * @return
	 */
	public static <T> Node<T> pairwiseSwap(Node<T> head) 
	{
		return ReverseLLInGroups.reverseLLInGroup(head, 2);
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1,2,3,4,5,6);
		
		
		Node<Integer> swappedRoot = pairwiseSwap(ll.getRoot());
		
		PrintNodes.printList(swappedRoot);
	}

}
