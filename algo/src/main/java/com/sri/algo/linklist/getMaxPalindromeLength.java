package com.sri.algo.linklist;

/**
 * Length of longest palindrome in linked list 
 * 
 *  Input  : List = 2->3->7->3->2->12->24
	Output : 5
	The longest palindrome list is 2->3->7->3->2

	Input  : List = 12->4->4->3->14
	Output : 2
	The longest palindrome list is 4->4
 *
 *
 */
public class getMaxPalindromeLength {

	public static int maxPalindrome(Node<Integer> head) {

		Node<Integer> curr = head, prev = null, next;
		int len = 0;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;

			len = Integer.max(len, 2 * getCommonListLength(prev, next) + 1);

			len = Integer.max(len, 2 * getCommonListLength(curr, next));

			prev = curr;
			curr = next;

		}

		return len;
	}

	private static int getCommonListLength(Node<Integer> a, Node<Integer> b) {
		int count = 0;

		if (a == null || b == null) {
			return count;
		}

		while (a != null && b != null) {
			if (a.data == b.data) {
				count++;
				a = a.next;
				b = b.next;
			}
			else
			{
				break;
			}
			
		}

		return count;
	}

	public static void main(String[] args) {

	/*	Node<Integer> root = new LinkedList<Integer>().withDataSet(2, 3, 7, 3, 2, 12, 24).getRoot();

		System.out.println(maxPalindrome(root));
		
		Node<Integer> root1 = new LinkedList<Integer>().withDataSet(12 ,4 ,4 ,3 ,14).getRoot();
		System.out.println(maxPalindrome(root1));*/
		
		Node<Integer> root2 = new LinkedList<Integer>().withDataSet(
				87,78,16,94,36,87,93,50,22,63,28,91,60,64,27,41,27,73,37,12,69,68,
				30,83,31,63,24,68,36,30,3,23,59,70,68,94,57,12,43,30,74,22,20,85,
				38,99,25,16,71,14,27,92,81,57,74,63,71,97,82,6,26,
				85,28,37,6,47,30,14,58,25,96,83,46,15,68,35,65,44,51,88,9,77,79,89).getRoot();

		System.out.println(maxPalindrome(root2));
	}

}
