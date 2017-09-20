package com.sri.algo.linklist;

public class AddTwoNosRepresentedAsLists {
	
	/**
	 *   5->4 (45)
	 *   5->4->3 (345)
	 *   
	 *   o/p : 0->9->3
	 * @param root1
	 * @param root2
	 * @return
	 */
	public static  Node<Integer>  addTwoNos(Node<Integer> root1,Node<Integer> root2)
	{
		
		int no1 = 0, no2 = 0,sum = 0;
		
		Node<Integer> curr = root1,sumHead = null,sumTail =null;
		int index = 0;
		while (curr != null)
		{
			no1 = no1 + (curr.data * (int)Math.pow(10,index));
			index++;
			curr = curr.next;
		}
		
		index = 0;
		curr =  root2;
		while (curr != null)
		{
			no2 = no2 + (curr.data * (int)Math.pow(10,index));
			index++;
			
			curr = curr.next;
		}
		
		sum = no1 + no2;
		
		sumHead = new Node<Integer>(sum %10);
		sumTail = sumHead;
		
		sum = sum/10;
		
		while(sum != 0)
		{
			
			 sumTail.next = new Node<Integer>(sum %10);
			 sumTail = sumTail.next; 
			 sum = sum/10;
		}
		
		return sumHead;
	} 
	
	public static  Node<Integer>  addTwoNosUsingCarry(Node<Integer> root1,Node<Integer> root2)
	{
		if (root1 == null)
		{
			return root2;
		}
		
		if (root2 == null)
		{
			return root1;
		}
		
		int carry = 0;
		Node<Integer> head = null,tail = null;
		
		while(root1 != null && root2 != null)
		{	
			int sum = root1.data + root2.data + carry;	
			Node<Integer> node = sum >= 10 ? new Node<Integer>(sum %10) : new Node<Integer>(sum);
			
			carry = sum/10;		
			if (tail == null)
			{
				head= tail = node;
			}
			else
			{
				tail.next = node;
				tail = tail.next;
			}
			
			root1= root1.next;
			root2 = root2.next;	
		}
		
		while (root1 != null)
		{
			
			int sum = root1.data + carry;	
			Node<Integer> node = sum >= 10 ? new Node<Integer>(sum %10) : new Node<Integer>(sum);
			tail.next = node;
			tail = tail.next;
			
			carry = sum/10;	
			root1 = root1.next;
		}
		
		while (root2 != null)
		{
			int sum = root2.data + carry;	
			Node<Integer> node = sum >= 10 ? new Node<Integer>(sum %10) : new Node<Integer>(sum);
			tail.next = node;
			tail = tail.next;
			
			carry = sum/10;	
			root2 = root2.next;
		}
	
		return head;
	} 
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> l1 = new LinkedList<Integer>().withDataSet(7,5,9,4,6);
		
		LinkedList<Integer> l2 = new LinkedList<Integer>().withDataSet(8,4);
		
		Node<Integer> sumList = addTwoNos(l1.getRoot(),l2.getRoot());
		
		PrintNodes.printList(sumList);
		
		 sumList = addTwoNosUsingCarry(l1.getRoot(),l2.getRoot());
		
		PrintNodes.printList(sumList);
	}
	

}
