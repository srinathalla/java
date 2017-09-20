package com.sri.algo.linklist;

public class DeleteNodeWithoutHead {
	
	/**
	 * This copies the data of next node to current node and deletes the next node.
	 * 
	 * @param pointer
	 */
	public static <T> void deleteNode(Node<T> pointer) 
	{
		
		if (pointer == null)
		{
			return;
		}
		
		pointer.data = pointer.next.data;
		pointer.next = pointer.next.next;
	}
	
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5, 6);
		

		PrintNodes.printList(ll.getRoot());
		
		deleteNode(ll.getRoot().next.next);
		
		PrintNodes.printList(ll.getRoot());
	}


}
