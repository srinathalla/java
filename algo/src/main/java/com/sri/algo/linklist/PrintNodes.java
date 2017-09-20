package com.sri.algo.linklist;

public class PrintNodes {
	

	public static void printList(Node<Integer> root) {
		
		System.out.println();
		while (root != null) {
			System.out.print(root.data);
			System.out.print("-->");

			root = root.next;
			if (root == null) {
				System.out.print("null");
			}
		}
	}

}
