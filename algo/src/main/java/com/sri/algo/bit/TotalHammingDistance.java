package com.sri.algo.bit;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Now your job is to find the total Hamming distance between all pairs of the
 * given numbers.
 * 
 * Example: Input: 4, 14, 2
 * 
 * Output: 6
 * 
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is
 * 0010 (just showing the four bits relevant in this case). So the answer will
 * be: HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) =
 * 2 + 2 + 2 = 6.
 * 
 * @author srialla
 *
 */
public class TotalHammingDistance {

	public int totalHammingDistance(int[] nums) {

		int total = 0;
		int n = nums.length;

		for (int j = 0; j < 32; j++) {
			int count = 0;
			for (int no : nums) {
				count += (no >> j) & 1;
			}
			total += count*(n - count);
		}
		return total;

	}
	
	public static void main(String[] args) {
		
		TotalHammingDistance totalHammingDistance = new TotalHammingDistance();
		System.out.println(
			totalHammingDistance.totalHammingDistance(new int[] {4, 14, 2}));
			
		
		
	}

}
