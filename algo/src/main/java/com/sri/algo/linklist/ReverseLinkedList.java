package com.sri.algo.linklist;

public class ReverseLinkedList extends LinkedList<Integer>
{
	
	public void reverse(LinkedList<Integer>  ll)
	{
		
		Node<Integer> head = ll.getRoot();
		Node<Integer> prev = null;
		Node<Integer> curr = head,next = curr.next;
		
		while (next != null)
		{
			curr.next = prev;
			
			prev = curr;
			curr = next;	
			next = next.next;
		}
		
		ll.setRoot(prev);
	}
	
	public static void main(String[] args) {
			
		LinkedList<Integer> ll = new LinkedList<Integer>().withDataSet(1,2,3,4,5,6);
		
		ReverseLinkedList rl = new ReverseLinkedList();
		rl.reverse(ll);
		
		System.out.println(ll.toString());	
		
	}

}
