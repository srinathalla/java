package com.sri.algo.array.leet.medium;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

	public int minIncrementForUniqueON(int[] A) {

		int[] count = new int[100000];

		for (int no : A) {
			count[no]++;
		}
		int ans = 0, taken = 0;
		for (int i = 0; i < 100000; i++) {

			if (count[i] >= 2) {
				taken += count[i] - 1;
				ans -= i * (count[i] - 1);
			} else if (taken > 0 && count[i] == 0) {
				taken--;
				ans += i;
			}
		}

		return ans;
	}
	
	 public int minIncrementForUnique(int[] A) {
	        Arrays.sort(A);
	        int res = 0, need = 0;
	        for (int a : A) {
	            res += Math.max(need - a, 0);
	            need = Math.max(a, need) + 1;
	        }
	        return res;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique =
	    			
	    			new MinimumIncrementToMakeArrayUnique();
	    	
	    	System.out.println(
    			minimumIncrementToMakeArrayUnique.minIncrementForUnique(new int[] {1,2,2}));
			
	    	System.out.println(
	    			minimumIncrementToMakeArrayUnique.minIncrementForUnique(new int[] {3,2,1,2,1,7}));
				
		}

}
