package com.sri.algo.array.leet;

import java.util.Arrays;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and
 * nums[i] > 2*nums[j].
 * 
 * You need to return the number of important reverse pairs in the given array.
 * 
 * Example1:
 * 
 * Input: [1,3,2,3,1] Output: 2 Example2:
 * 
 * Input: [2,4,3,5,1] Output: 3 Note: The length of the given array will not
 * exceed 50,000. All the numbers in the input array are in the range of 32-bit
 * integer.
 * 
 * @author salla
 *
 */
public class ReversePairs {

	/**
	 * T.c o(n*n)
	 * 
	 * @param nums
	 * @return
	 */
	public int reversePairsNaive(int[] nums) {

		int n = nums.length;

		if (n < 2) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (nums[i] > 2 * nums[j]) {
					count++;
				}
			}
		}

		return count;
	}

	private static class Node {
		Node left;
		Node right;
		int val;
		int count_ge;

		public Node(int val) {
			super();
			this.left = null;
			this.right = null;
			this.val = val;
			this.count_ge = 1;
		}
	}

	private Node insert(Node head, int val) {

		if (head == null) {
			return new Node(val);
		}

		if (val < head.val) {
			head.left = insert(head.left, val);
		} else if (val == head.val) {
			head.count_ge++;
		} else if (val > head.val) {
			head.count_ge++;
			head.right = insert(head.right, val);
		}

		return head;
	}

	private int search(Node head, long val) {

		if (head == null) {
			return 0;
		}

		if (val == head.val) {
			return head.count_ge;
		} else if (val < head.val) {
			return head.count_ge + search(head.left, val);
		}

		return search(head.right, val);
	}

	public int reversePairsWithBST(int[] nums) {

		int n = nums.length;

		if (n < 2) {
			return 0;
		}

		int count = 0;
		Node head = null;
		for (int i = 0; i < n; i++) {

			count += search(head, 2L * nums[i] + 1);

			head = insert(head, nums[i]);

		}

		return count;
	}

	private int search(int[] bit, int i) {
		int sum = 0;

		while (i < bit.length) {
			sum += bit[i];
			i += i & -i;
		}

		return sum;
	}

	private void insert(int[] bit, int i) {
		while (i > 0) {
			bit[i] += 1;
			i -= i & -i;
		}
	}

	public int reversePairs(int[] nums) {
		int res = 0;
		int[] copy = Arrays.copyOf(nums, nums.length);
		int[] bit = new int[copy.length + 1];

		Arrays.sort(copy);

		for (int ele : nums) {
			res += search(bit, index(copy, 2L * ele + 1));
			insert(bit, index(copy, ele));
		}

		return res;
	}

	private int index(int[] arr, long val) {
		int l = 0, r = arr.length - 1, m = 0;

		while (l <= r) {
			m = l + ((r - l) >> 1);

			if (arr[m] >= val) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}

		return l + 1;
	}

	public static void main(String[] args) {

		ReversePairs rp = new ReversePairs();

		System.out.println(rp.reversePairs(new int[] { 1, 3, 2, 3, 1 }));

		System.out
				.println(rp.reversePairs(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }));

	}

}
