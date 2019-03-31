package com.sri.algo.stack;

import java.util.Stack;

import com.sri.algo.array.PrintArray;

public class NextGreaterElement {
	
	/**
	 * T.C : O(n*n)
	 * 
	 * @param nums
	 * @return
	 */
	 public int[] nextGreaterElementsNaive(int[] nums) {

           int[] res = new int[nums.length];
           
           for(int i=0; i< nums.length; i++)
           {
        	   res[i] = -1;
        	   for(int j=1; j < nums.length; j++)
               {		   
        		   if (nums[(i + j) % nums.length] > nums[i])
        		   {		   
        			   res[i] = nums[(i + j) % nums.length];
        			   break;
        		   }   
               }
           }
           
           return res;
	    }
	 
/**
 * T.C : O(n).
 * Two pass solution.
 * 
 * @param nums
 * @return
 */
	    public int[] nextGreaterElements(int[] nums) {
	        int[] res = new int[nums.length];
	        Stack<Integer> stack = new Stack<>();
	        for (int i = 2 * nums.length - 1; i >= 0; --i) {
	            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
	                stack.pop();
	            }
	            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
	            stack.push(i % nums.length);
	        }
	        return res;
	    }
	 
	 public static void main(String[] args) {
		 
		 
		 NextGreaterElement nge = new NextGreaterElement();
		 
		 int[] res = nge.nextGreaterElements(new int[] {1,2,1});
		 
		 PrintArray.print(res);
		
	}

}
