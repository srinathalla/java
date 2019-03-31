package com.sri.algo.dp.leet;

import java.util.Stack;

import com.sri.algo.array.PrintArray;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, 
 * tells you how many days you would have to wait until a warmer temperature. 
 * 
 * If there is no future day for which this is possible, put 0 instead.

   For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
   your output should be [1, 1, 4, 2, 1, 1, 0, 0].

   Note: The length of temperatures will be in the range [1, 30000]. Each temperature will 
   be an integer in the range [30, 100].
   
 * @author salla
 *
 */
public class DailyTemperatures {
	
	
   public int[] dailyTemperaturesWithStack(int[] T) {
	   
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
				stack.pop();
			}

			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}

		return ans;  
    }
   
   public int[] dailyTemperatures(int[] temp) {
       
	   int[] ans = new int[temp.length];
	   int[] p = new int[temp.length];
	   
	   int pid = -1;
	   for (int i=0; i< temp.length;i++)
	   {
		   
		   while (pid != -1 && temp[i] > temp[p[pid]])
		   {
			   ans[p[pid]] = i - p[pid];
			   pid--;
		   }	   
		   pid++;
		   p[pid] = i;	   
	   }
	   
	   
	   return ans;
   }
   
   public static void main(String[] args) {   
	   
	   DailyTemperatures dailyTemperatures = new DailyTemperatures();
	   
	   int[] result = 
		   dailyTemperatures.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
	   
	   PrintArray.print(result);
	
    }

}
