package com.sri.algo.linklist;

public class SortAlinkedListOf012 {
	
	/**
	 * Single Pass..
	 * Time Complexity O(n).
	 * 
	 * @param root
	 * @return
	 */
	public static Node<Integer> sort(Node<Integer> root)
	{
		// No nodes or single node present no sorting required.
		if (root == null || root.next == null)
		{
			return root;
		}
		
		Node<Integer> sortedRoot = null,
		zeroPointerTail = null, zeroPointerHead = null,
		onePointerTail = null, onePointerHead = null,
		twoPointerTail = null, twoPointerHead = null;
		
		while (root != null)
		{	
			if (root.data == 0)
			{
				zeroPointerTail = unlinkOrigNode(zeroPointerTail,root);		
				zeroPointerHead = zeroPointerHead != null ? zeroPointerHead : zeroPointerTail;
			}
			
			else if (root.data == 1)
			{
				onePointerTail = unlinkOrigNode(onePointerTail,root);	
				onePointerHead = onePointerHead != null ? onePointerHead : onePointerTail;
			}
			
			else if (root.data == 2)
			{
				twoPointerTail = unlinkOrigNode(twoPointerTail,root);
				twoPointerHead = twoPointerHead != null ? twoPointerHead : twoPointerTail;
			}	
			root = root.next;
		}
		
		zeroPointerTail.next = onePointerHead;
		onePointerTail.next = twoPointerHead;
	
		sortedRoot = 
			zeroPointerHead != null ? 
				zeroPointerHead :
				(onePointerHead != null ? 
					onePointerHead :
					twoPointerHead);
		return sortedRoot;
	}
	
	private static Node<Integer> unlinkOrigNode(Node<Integer> zeroOneTwoPointer,
			Node<Integer> origNode)
	{
		if(zeroOneTwoPointer == null)
		{
			zeroOneTwoPointer = origNode;
		}
		else
		{
			zeroOneTwoPointer.next = origNode;
			zeroOneTwoPointer = zeroOneTwoPointer.next;	
		}
		
		return zeroOneTwoPointer;
	}
	
	/**
	 * Two pass solution.
	 * First pass keep counter of zeros,ones,twos.
	 * Second pass override the data based on count.
	 * 
	 * @param root
	 * @return
	 */
	public static Node<Integer> sortUsingCounter(Node<Integer> root)
	{
		int[] cnt = new int[3];	
		Node<Integer> curr = root;		
		while(curr != null)
		{
			cnt[curr.data] = cnt[curr.data] + 1;	
			curr = curr.next;
		}
		
		curr = root;
		for (int i =0 ;i <= 2;i++)
		{
			int count = cnt[i];
			while(count != 0 && curr != null)
			{
				curr.data = i;
				count --;
				curr = curr.next;
			}
		}
 		
		return root;
	}
	
	public static void main(String[] args) {	
		LinkedList<Integer> myList = new LinkedList<Integer>().withDataSet(1, 1, 0, 2,0, 2);
		
		Node<Integer> sortedRoot = sort(myList.getRoot());	
		PrintNodes.printList(sortedRoot);
		
		LinkedList<Integer> myList1 = new LinkedList<Integer>().withDataSet(1, 1, 0, 2,0, 2);
		sortedRoot = sortUsingCounter(myList1.getRoot());	
		PrintNodes.printList(sortedRoot);
	}

}
