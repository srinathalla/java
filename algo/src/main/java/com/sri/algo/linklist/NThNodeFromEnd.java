package com.sri.algo.linklist;

public class NThNodeFromEnd {
	
	/**
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static <T> Node<T> nThNodeFromEnd(Node<T> head,int n)
	{
		Node<T> fast = head;
		Node<T> slow = head;
		int index = 1;
		
		while(fast != null)
		{
			// Move fast pointer by n.
			while (index <= n)
			{
				fast = fast.next;
				index++;
			}
			 
			// Move both pointers by 1 till fast reaches end.
			// When fast pointer reaches end, slow pointer will be at 
			// a distance of n from last.
			if (fast != null)
			{
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		
		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5, 6);

		Node<Integer> nthNode = nThNodeFromEnd(ll.getRoot(), 6);

		if (nthNode != null)
		{
			System.out.println(nthNode.data);
		}
	}

}
