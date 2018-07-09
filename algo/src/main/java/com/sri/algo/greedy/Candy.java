package com.sri.algo.greedy;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * Input: [1,0,2] Output: 5 Explanation: You can allocate to the first, second
 * and third child with 2, 1, 2 candies respectively. Example 2:
 * 
 * Input: [1,2,2] Output: 4 Explanation: You can allocate to the first, second
 * and third child with 1, 2, 1 candies respectively. The third child gets 1
 * candy because it satisfies the above two conditions.
 * 
 * @author salla
 *
 */
public class Candy {

	/**
	 * T.C : O(n)
	 * Auxillary space : O(n)
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {

		int n = ratings.length;

		if (n < 2) {
			return n;
		}

		int[] candiesCount = new int[n];

		for (int i = 0; i < n; i++) {
			candiesCount[i] = 1;
		}

		// add one candy more to the current child than previous child if current child rating is higher 
		// than previous child, do this by traversing left to right ..
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candiesCount[i] = candiesCount[i - 1] + 1;
			}
		}

		// add one candy more to the current child than previous child if current child rating is higher 
		// than previous child, do this by traversing right to left ..
		// Ignore if current child already has higher candy count value than prevChild + 1.
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candiesCount[i] = Integer.max(candiesCount[i], candiesCount[i + 1] + 1);
			}
			
		}

		// All the candies present in the array is the result ..
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += candiesCount[i];
		}

		return total;
	}

	public static void main(String[] args) {

		Candy candy = new Candy();

		System.out.println(candy.candy(new int[] { 1, 0, 2 }));

		System.out.println(candy.candy(new int[] { 1, 2, 2 }));

	}

}
