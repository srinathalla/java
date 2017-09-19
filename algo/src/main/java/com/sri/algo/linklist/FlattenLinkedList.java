package com.sri.algo.linklist;

public class FlattenLinkedList {

	/**
	 *  Let us create the following linked list
	 *  
	 *      i/p :
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
            
            o/p :
            5-->7-->8-->10-->19-->20-->22-->28-->30-->35-->40-->45-->50-->null. 
	 * @param root
	 * @return
	 */
	public static Node<Integer> flatten(Node<Integer> root) {
		
		Node<Integer> flatten = root;
		while(root != null)
		{
			// Merge two lists at a time.
			flatten = merge(flatten , root.next);
			
			root = root.next;
		}
			
		return flatten;
	}

	private static  Node<Integer> merge(Node<Integer> node1, Node<Integer> node2)
	{
		if (node1 == null)
		{
			return node2;
		}
		
		if (node2 == null)
		{
			return node1;
		}
		
		Node<Integer> mergedHead = null;
		
	
		if (node1.data < node2.data)
		{
			mergedHead = node1;
			mergedHead.down = merge(node1.down , node2);
		}
		else
		{
			mergedHead = node2;
			mergedHead.down = merge(node1 , node2.down);
		}
			
		return mergedHead;	
	}
	
	public static void printList(Node<Integer> root)
	{
		while(root != null)
		{
			System.out.print(root.data);	
			System.out.print("-->");
			
			root = root.down;	
			if (root == null)
			{
				System.out.print("null");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Node<Integer> root = new Node<Integer>(5);
		root.down = new Node<Integer>(7); 
		root.down.down =  new Node<Integer>(8); 
		root.down.down.down = new Node<Integer>(30); 
		
		root.next = new Node<Integer>(10);
		root.next.down = new Node<Integer>(20);
		
		Node<Integer> node19 = new Node<Integer>(19);
		node19.down = new Node<Integer>(22);
		node19.down.down = new Node<Integer>(50);
		root.next.next = node19;
		
		Node<Integer> node28 = new Node<Integer>(28);
		node28.down = new Node<Integer>(35);
		node28.down.down = new Node<Integer>(40);
		node28.down.down.down = new Node<Integer>(45);
		root.next.next.next = node28;
		
		root = flatten(root);
		
		printList(root);	
	}

}
