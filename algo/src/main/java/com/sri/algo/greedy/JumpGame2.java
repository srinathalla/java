package com.sri.algo.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to
 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
 * last index.
 * 
 * @author salla
 *
 */
public class JumpGame2 {

	private static class Node {
		int pos;
		int val;
		int hops;

		public Node(int pos, int val, int hops) {
			super();
			this.pos = pos;
			this.val = val;
			this.hops = hops;
		}
	}

	/**
	 * BFS based approach to find the shortest path from start index to end index.
	 * 
	 * T.C O(n) Auxillary space : O(n)
	 * 
	 * can we do better ?
	 * 
	 * @param nums
	 * @return
	 */
	public int jumpWithBfs(int[] nums) {
		int n = nums.length;

		if (n < 2) {
			return 0;
		}

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(0, nums[0], 0));
		nums[0] = -1;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (int i = 1; i <= curr.val; i++) {
				if (curr.pos + i == n - 1) {
					return curr.hops + 1;
				}

				if (nums[curr.pos + i] != -1) {
					Node adj = new Node(curr.pos + i, nums[curr.pos + i], curr.hops + 1);
					queue.add(adj);
					nums[curr.pos + i] = -1;
				}
			}
		}

		return -1;
	}

	/**
	 * T.C : O(n)
	 * 
	 * Idea is to to increase jumps counter by 1 and move to next max jump calculated from existing jumps..
	 * since solution is guaranteed by the time we reach n-1 position we have jumps counter with min value..
	 * Single pass ..
	 * 
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {

		int jumps = 0;
		int nextMaxJump = 0;
		int currMaxJump = 0;

		for (int i = 0; i < A.length - 1; i++) {
			nextMaxJump = Integer.max(nextMaxJump, i + A[i]);

			if (i == currMaxJump) {
				jumps++;
				currMaxJump = nextMaxJump;
			}
		}

		return jumps;
	}

	public static void main(String[] args) {

		JumpGame2 jg2 = new JumpGame2();

		System.out.println(jg2.jump(new int[] { 2, 3, 1, 1, 4 }));

	}

}
