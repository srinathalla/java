package com.sri.algo.dp.cp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array A (index starts at 1) consisting of N integers: A1, A2, ...,
 * AN and an integer B. The integer B denotes that from any place (suppose the
 * index is i) in the array A, you can jump to any one of the place in the array
 * A indexed i+1, i+2, …, i+B if this place can be jumped to. Also, if you step
 * on the index i, you have to pay Ai coins. If Ai is -1, it means you can’t
 * jump to the place indexed i in the array.
 * 
 * Now, you start from the place indexed 1 in the array A, and your aim is to
 * reach the place indexed N using the minimum coins. You need to return the
 * path of indexes (starting from 1 to N) in the array you should take to get to
 * the place indexed N using minimum coins.
 * 
 * If there are multiple paths with the same cost, return the lexicographically
 * smallest such path.
 * 
 * If it's not possible to reach the place indexed N then you need to return an
 * empty array.
 * 
 * Example 1: Input: [1,2,4,-1,2], 2 Output: [1,3,5] Example 2: Input:
 * [1,2,4,-1,2], 1 Output: [] Note: Path Pa1, Pa2, ..., Pan is lexicographically
 * smaller than Pb1, Pb2, ..., Pbm, if and only if at the first i where Pai and
 * Pbi differ, Pai < Pbi; when no such i exists, then n < m. A1 >= 0. A2, ...,
 * AN (if exist) will in the range of [-1, 100]. Length of A is in the range of
 * [1, 1000]. B is in the range of [1, 100].
 * 
 * @author salla
 *
 */
public class CheapestJump {
	

	/**
	 * T.C : O(n*B).
	 * Auxillary Space : O(3*n).
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	 public List<Integer> cheapestJump(int[] A, int B) 
	 {
		 int n = A.length;
		 
		 int c[] = new int[n];
		 int p[] = new int[n];
		 int len[] = new int[n];
		 
		 Arrays.fill(c, Integer.MAX_VALUE);
		 Arrays.fill(p, -1);
		 Arrays.fill(len, 0);
		 c[0] = 0;
		 
		 for (int i=0; i< n; i++)
		 {
			 if (A[i] != -1)
			 {
				 for (int j = Integer.max(0, (i- B)) ;j < i; j++)
				 { 
					 if (A[j] != -1)
					 {
						 int alt = c[j] + A[i]; 
						 if(alt < c[i] || (alt == c[i] && len[i] < len[j] + 1))
						 {
							 c[i] = alt;
							 p[i] = j;
							 len[i] = len[j] + 1;
						 } 
					 }
				 } 
			 }
		 }
		 
		 List<Integer> jumps = new ArrayList<>();
		 
		 for (int i = n-1; i >= 0 ; i = p[i])
		 {
			 jumps.add(0,i +1);
		 }
		 
		 return jumps.get(0) == 1 ? jumps : new ArrayList<Integer>();	 
	 }

	
	public static void main(String[] args) {
		
		CheapestJump cj = new CheapestJump();
		System.out.println(cj.cheapestJump(new int[] {1,2,4,-1,2}, 2));
		System.out.println(cj.cheapestJump(new int[] {1,2,4,-1,2}, 1));
		
	}
}
