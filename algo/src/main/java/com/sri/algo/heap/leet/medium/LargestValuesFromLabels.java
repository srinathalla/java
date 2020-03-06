package com.sri.algo.heap.leet.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * We have a set of items: the i-th item has value values[i] and label
 * labels[i].
 * 
 * Then, we choose a subset S of these items, such that:
 * 
 * |S| <= num_wanted For every label L, the number of items in S with label L is
 * <= use_limit. Return the largest possible sum of the subset S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit
 * = 1 Output: 9 Explanation: The subset chosen is the first, third, and fifth
 * item. Example 2:
 * 
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit
 * = 2 Output: 12 Explanation: The subset chosen is the first, second, and third
 * item.
 * 
 * @author srialla
 *
 */
public class LargestValuesFromLabels {

	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int label : labels) {
			map.put(label, 0);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		for (int i = 0; i < values.length; i++) {
			pq.add(new int[] { values[i], labels[i] });
		}

		int sum = 0;
		while (num_wanted > 0 && !pq.isEmpty()) {
			int[] item = pq.poll();
			if (map.get(item[1]) < use_limit) {
				map.put(item[1], map.get(item[1]) + 1);
				sum += item[0];
				num_wanted--;
			}
		}

		return sum;
	}

	public static void main(String[] args) {

		LargestValuesFromLabels largestValuesFromLabels = new LargestValuesFromLabels();
		System.out.println(largestValuesFromLabels.largestValsFromLabels(new int[] { 9, 8, 8, 7, 6 },
				new int[] { 0, 0, 0, 1, 1 }, 3, 1));

	}

}
