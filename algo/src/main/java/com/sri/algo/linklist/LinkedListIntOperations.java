package com.sri.algo.linklist;

public class LinkedListIntOperations extends LinkedList<Integer> {

	public LinkedList<Integer> addListsWithDigitsReversed(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		Integer sum = prepareNumberFromListHavingDigitsStoredInReverseOrder(l1.getRoot())
				+ prepareNumberFromListHavingDigitsStoredInReverseOrder(l2.getRoot());
		return createLinkedListWithDigitsReversed(sum);
	}
	
	public LinkedList<Integer> addLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		Integer sum = prepareNumberFromList(l1.getRoot())
				+ prepareNumberFromList(l2.getRoot());
		return createLinkedList(sum);
	}

	/**
	 * Creates a linked list from the given integer having its digits spread 
	 * across the list in reverse order.
	 * 
	 * For i/p 1234 o/p is 4-> 3-> 2-> 1
	 * 
	 */
	public LinkedList<Integer> createLinkedListWithDigitsReversed(Integer number) {
		LinkedList<Integer> list = new LinkedList<>();
		Integer currentNumber = number;

		while (currentNumber != 0) {
			list.addEntryToTail(currentNumber % 10);
			currentNumber = currentNumber / 10;
		}
		return list;
	}
	
	/**
	 * Creates a  linked list from the given integer having its digits spread across the list.
	 * 
	 * For input 1234 o/p is 1-> 2-> 3-> 4
	 * 
	 */
	public LinkedList<Integer> createLinkedList(Integer number) {
		LinkedList<Integer> list = new LinkedList<>();
		Integer currentNumber = number;

		while (currentNumber != 0) {
			list.addEntry(currentNumber % 10);
			currentNumber = currentNumber / 10;
		}
		return list;
	}

	// For input 7->1->6 output is 617
	private Integer prepareNumberFromListHavingDigitsStoredInReverseOrder(Node<Integer> node) {
		if (node == null) {
			return 0;
		}
		return node.data + prepareNumberFromListHavingDigitsStoredInReverseOrder(node.next) * 10;
	}

	// For input 7->1->6 output is 716
	private Integer prepareNumberFromList(Node<Integer> node) {

		Node<Integer> current = node;
		Integer number = 0;
		while (current != null) {
			number = number * 10 + current.data;
			current = current.next;
		}
		return number;
	}

	public static void main(String[] args) {
		LinkedListIntOperations operations = new LinkedListIntOperations();

		System.out.println(operations.addListsWithDigitsReversed(new LinkedList<Integer>().withDataSet(7, 1, 6),
				new LinkedList<Integer>().withDataSet(5, 9, 2)).toString());
		
		System.out.println(operations.addLists(new LinkedList<Integer>().withDataSet(6, 1, 7),
				new LinkedList<Integer>().withDataSet(2, 9, 5)).toString());
	}

}
