package com.sri.algo.linklist.leet;

import com.sri.algo.linklist.leet.ReverseLinkedList2.ListNode;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {

		ListNode oheaddummy = new ListNode(-1), otail = oheaddummy;
		ListNode eheaddummy = new ListNode(-2), etail= eheaddummy;

		ListNode curr = head;int i =1;
		while (curr != null)
		{	
			if (i % 2 == 0)
			{
				etail.next = curr;
				etail = etail.next;
			}
			else
			{
				otail.next = curr;
				otail = otail.next;
			}
			i++;
			curr = curr.next;
		}
		
		etail.next = null;
		otail.next = eheaddummy.next;

		return oheaddummy.next;

	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();

		oddEvenLinkedList.oddEvenList(head);

		System.out.println(head);

	}

}
