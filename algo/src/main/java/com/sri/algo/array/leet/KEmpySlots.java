package com.sri.algo.array.leet;

import java.util.TreeSet;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N
 * flowers will bloom one by one in N days. In each day, there will be exactly
 * one flower blooming and it will be in the status of blooming since then.
 * 
 * Given an array flowers consists of number from 1 to N. Each number in the
 * array represents the place where the flower will open in that day.
 * 
 * For example, flowers[i] = x means that the unique flower that blooms at day i
 * will be at position x, where i and x will be in the range from 1 to N.
 * 
 * Also given an integer k, you need to output in which day there exists two
 * flowers in the status of blooming, and also the number of flowers between
 * them is k and these flowers are not blooming.
 * 
 * If there isn't such day, output -1.
 * 
 * Example 1: Input: flowers: [1,3,2] k: 1 Output: 2 Explanation: In the second
 * day, the first and the third flower have become blooming. Example 2: Input:
 * flowers: [1,2,3] k: 1 Output: -1
 * 
 * @author salla
 *
 */
public class KEmpySlots {

	/**
	 * T.C O(nlogn);
	 * 
	 * @param flowers
	 * @param k
	 * @return
	 */
	public int kEmptySlotswithTreeSet(int[] flowers, int k) {

		TreeSet<Integer> slots = new TreeSet<>();

		int n = flowers.length;

		if (n < 2) {
			return -1;
		}

		for (int i = 0; i < n; i++) {

			slots.add(flowers[i]);
			Integer higherSlot = slots.higher(flowers[i]);

			if (higherSlot != null && higherSlot == (flowers[i] + k + 1)) {
				return i + 1;
			}

			Integer lowerSlot = slots.lower(flowers[i]);
			if (lowerSlot != null && lowerSlot == (flowers[i] - k - 1)) {
				return i + 1;
			}
		}

		return -1;
	}

	/**
	 * T.C O(nk) => O(n) if k is small..
	 * 
	 * @param flowers
	 * @param k
	 * @return
	 */
	public int kEmptySlots(int[] flowers, int k) {

		int n = flowers.length;
		if (n < 2) {
			return -1;
		}

		int[] slots = new int[n];
		for (int i = 0; i < n; i++) {

			int slot = flowers[i];
			slots[slot - 1] = 1;

			if (slot + k < n && slots[slot + k] == 1) {

				// check if all slots are empty to the right of current slot.
				boolean allEmpty = true;
				for (int j = 1; j <= k; j++) {
					if (slots[slot + j - 1] == 1) {
						allEmpty = false;
						break;
					}
				}

				if (allEmpty) {
					return i + 1;
				}
			}

			// check if all slots are empty to the left of current slot.
			if (slot - k - 2 >= 0 && slots[slot - k - 2] == 1) {
				boolean allEmpty = true;
				for (int j = 1; j <= k; j++) {
					if (slots[slot - j - 1] == 1) {
						allEmpty = false;
						break;
					}
				}

				if (allEmpty) {
					return i + 1;
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {

		KEmpySlots emptySlots = new KEmpySlots();

		System.out.println(emptySlots.kEmptySlots(new int[] { 1, 3, 2 }, 1));

		System.out.println(emptySlots.kEmptySlots(new int[] { 1, 2, 3 }, 1));

	}

}
