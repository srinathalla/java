package com.sri.algo.linklist;

public class IntersectionPoint {
	
	/**
	 * Keep the longest list pointer at a distance of  Math.abs(len(l1) - len(l2));
	 * and keep moving both pointers one by one both will intersect at some point.
	 * 
	 * TC : O(m + n)
	 * SC : O(1).
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static <T> Node<T>  getIntersectionPoint(Node<T> root1,Node<T> root2)
	{
		
		int c1 = getCount(root1);	
		int c2 = getCount(root2);
		
		int d = Math.abs(c1 - c2);
		
		Node<T> longestListPtr, shortListPtr;
		
		if(c1 > c2)
		{
			longestListPtr = traverseList(root1,d);
			shortListPtr = root2;
		}
		else
		{
			longestListPtr = traverseList(root2,d);
			shortListPtr = root1;
		}
		
		while(longestListPtr != null && shortListPtr != null)
		{
			if (longestListPtr == shortListPtr)
			{
				return longestListPtr;
			}
			
			longestListPtr = longestListPtr.next;
			shortListPtr = shortListPtr.next;
			
		}
		
		return null;
		
	}
	
	private static <T> Node<T>  traverseList(Node<T> node,int k)
	{	
		while(k > 0)
		{
			node = node.next;
			k--;
		}	
		return node;
	}
	
	
	public static <T> int getCount(Node<T> n1)
	{
		int count = 0;	
		while(n1 != null)
		{
			count++;
			n1 = n1.next;
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1, 2, 3, 4, 5, 6);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>().withDataSet(20);

		l2.getRoot().next = ll.getRoot().next.next.next;

		System.out.println(getIntersectionPoint(ll.getRoot(), l2.getRoot()).data);
	}

}
