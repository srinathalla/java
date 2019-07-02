package com.sri.algo.math;

public class Solution {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode xN, yN, xp, yp;

	int xd, yd;

	public boolean isCousins(TreeNode root, int x, int y) {
		
		search(root,0,x,y,null);
		
		
		return xd == yd && xp != yp;

	}

	private void search(TreeNode curr, int d, int x, int y, TreeNode p) {
		
		if (curr == null)
		{
			return;
		}
		if (xN != null && yN != null)
		{
			return;
		}

		if (curr.val == x) {
			xN = curr;
			xp = p;
			xd = d;
		} else if (curr.val == y) {
			yN = curr;
			yp = p;
			yd = d;
		}
		
		search(curr.left,d + 1,x,y,curr);
		
		search(curr.right,d + 1,x,y,curr);
	}

	public static void main(String[] args) {

	}

}