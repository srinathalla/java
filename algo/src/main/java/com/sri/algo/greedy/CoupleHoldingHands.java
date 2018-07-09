package com.sri.algo.greedy;

/**
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want
 * to know the minimum number of swaps so that every couple is sitting side by
 * side. A swap consists of choosing any two people, then they stand up and
 * switch seats.
 * 
 * The people and seats are represented by an integer from 0 to 2N-1, the
 * couples are numbered in order, the first couple being (0, 1), the second
 * couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
 * 
 * The couples' initial seating is given by row[i] being the value of the person
 * who is initially sitting in the i-th seat.
 * 
 * Example 1:
 * 
 * Input: row = [0, 2, 1, 3] Output: 1 Explanation: We only need to swap the
 * second (row[1]) and third (row[2]) person. Example 2:
 * 
 * Input: row = [3, 2, 0, 1] Output: 0 Explanation: All couples are already
 * seated side by side.
 * 
 * @author salla
 *
 */
public class CoupleHoldingHands {

	/**
	 * T.C O(n * n)
	 * 
	 * 
	 * 
	 * If a person is number x, their partner is x ^ 1, where ^ is the bitwise XOR
	 * operator.
	 * 
	 * For each first person x = row[i] on a couch who is unpartnered, let's find
	 * their partner at row[j] and have them swap seats with row[i+1].
	 * 
	 * @param row
	 * @return
	 */
	public int minSwapsCouples(int[] row) {

		int ans = 0;

		for (int i = 0; i < row.length - 1; i = i + 2) {

			int x = row[i];

			if (row[i + 1] != (x ^ 1)) {
				ans++;
				for (int j = i + 2; j < row.length; j++) {
					if (row[j] == (x ^ 1)) {
						row[j] = row[i + 1];
						row[i + 1] = x ^ 1;
						break;
					}
				}
			}
		}

		return ans;

	}

	public static void main(String[] args) {

		CoupleHoldingHands chh = new CoupleHoldingHands();

		System.out.println(chh.minSwapsCouples(new int[] { 0, 2, 1, 3 }));

	}

}
