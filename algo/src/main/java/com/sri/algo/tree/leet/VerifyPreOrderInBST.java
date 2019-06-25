package com.sri.algo.tree.leet;

import java.util.Stack;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

   You may assume each number in the sequence is unique.

   Consider the following binary search tree: 
   
 * @author salla
 *
 */
    public class VerifyPreOrderInBST 
    {
	
    	/**
    	 * T.C : O(n)
    	 * S.C : O(n)
    	 * 
    	 * @param preorder
    	 * @return
    	 */
		public boolean verifyPreorderWithStack(int[] preorder) {
			
			    int low = Integer.MIN_VALUE;
			    Stack<Integer> stack = new Stack<>();
			    
			    for (int no : preorder)
			    {
			    	if (no < low)
			    	{
			    		return false;
			    	}
			    	while (!stack.isEmpty() && stack.peek() < no)
			    	{
			    		low = stack.pop();
			    	}
			    	stack.push(no);
			    }
			    
			    return true;
		}
		
	public boolean verifyPreorder(int[] preorder) {
		int low = Integer.MIN_VALUE, i = -1;

		for (int p : preorder) {
			if (p < low) {
				return false;
			}

			while (i >= 0 && p > preorder[i]) {
				low = preorder[i--];
			}
			preorder[++i] = p;
		}

		return true;
	}
		
		public static void main(String[] args) {
			
			VerifyPreOrderInBST verifyPreOrderInBST = new
					VerifyPreOrderInBST();
			
			System.out.println(
				verifyPreOrderInBST.verifyPreorder(new int[] {5,2,6,1,3}));
			System.out.println(
					verifyPreOrderInBST.verifyPreorder(new int[] {5,2,1,3,6}));
			
		}

}
