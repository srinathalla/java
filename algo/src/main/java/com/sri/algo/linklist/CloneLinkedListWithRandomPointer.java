package com.sri.algo.linklist;

public class CloneLinkedListWithRandomPointer {
	
	
	public static <T> Node<T> clone(Node<T> head)
	{
		Node<T> clonedHead = null;
		Node<T> curr = head;
		
		// Traverse through the list and at each node clone it and insert it as next node.
		// I/p : 1-> 2 ->3
		// o/p  : 1 -> 1' -> 2 -> 2' -> 3 -> 3'
		while(curr != null)
		{
			
			Node<T> clonedNode = new Node<>(curr.data); 
			
			clonedNode.next = curr.next;	
			curr.next = clonedNode;
			
			curr = curr.next.next;
		}
		
		curr = head;	
		// Traverse through the list and link random pointers of each cloned node.
		while (curr != null)
		{
			curr.next.random = curr.random.next;
			
			curr = curr.next.next;
		}
		
		// Traverse the list and split the main linked list into two lists i.e even, odd nodes list's.
		curr = head;
	
		Node<T> clonedTail = head.next;
		clonedHead = head.next;
		while (curr.next.next != null)
		{
			
			curr.next = curr.next.next;
			curr = curr.next;
			
			
			clonedTail.next = clonedTail.next.next;
			clonedTail = clonedTail.next;		
		}
		
		curr.next = null;
		
		return clonedHead;
	}
	
	public static void main(String[] args) {
		
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node3 = new Node<>(3);
		
		node1.next = node2;
		node1.random = node3;
		node2.next = node3;
		node2.random = node1;
		node3.next = null;
		node3.random = node1;
		
		Node<Integer> clonedList = clone(node1);
		
		System.out.println(new LinkedList<>(clonedList));
		
		
	}

}
