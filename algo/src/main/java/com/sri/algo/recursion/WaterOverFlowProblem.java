package com.sri.algo.recursion;

public class WaterOverFlowProblem {

	/**
	 * Returns the amount of water in jth glass of ith row
	 * 
	 * @param i
	 * @param j
	 * @param X
	 * @return
	 */
	static float findWater(int i, int j, float X) {
		// A row number i has maximum i columns. So input column number must
		// be less than i
		if (j > i) {
			return Float.MAX_VALUE;

		}

		// There will be i*(i+1)/2 glasses till ith row (including ith row)
		float[] glass = new float[i * (i + 1) / 2];

		// Put all water in first glass
		int index = 0;
		glass[index] = X;

		// Now let the water flow to the downward glassses till the
		// amount of water X is not 0 and row number is less than or
		// equal to i (given row)
		for (int row = 1; row <= i && X != 0.0; ++row) {
			// Fill glasses in a given row. Number of columns in a row
			// is equal to row number
			for (int col = 1; col <= row; ++col, ++index) {
				// Get the water from current glass
				System.out.println("Index : " + index);
				X = glass[index];

				// Keep the amount less than or equal to
				// capacity in current glass
				glass[index] = (X >= 1.0f) ? 1.0f : X;

				// Get the remaining amount
				X = (X >= 1.0f) ? (X - 1) : 0.0f;

				// Distribute the remaining amount to the down two glasses except for the last
				// row.
				// As we have fixed the array size to contain elements only till ith row.
				if (row != i) {
					glass[index + row] += X / 2;
				}
				if (row != i) {
					glass[index + row + 1] += X / 2;
				}
			}
		}

		// The index of jth glass in ith row will be i*(i-1)/2 + j - 1
		return glass[i * (i - 1) / 2 + j - 1];
	}

	/**
	 * Time Complexity O(i*(i+1)/2) or O(i^2).
	 * 
	 * @param i
	 * @param j
	 * @param X
	 * @return
	 */
	public static float findWaterInGlass(int i, int j, float X) {

		// No of columns in ith row is i so j cant be greater than i.
		if (X <= 0 || j > i) {
			return 0;
		}

		int index = 0;

		// Number of elements till ith row is 1,2,3.. i.e i*(i+1)/2.
		float[] glasses = new float[i * (i + 1) / 2];

		// Fill first glass with all the water present.
		glasses[index] = X;

		for (int r = 1; r <= i; r++) {
			for (int c = 1; c <= r; c++, index++) {

				float water = glasses[index];

				// glass can hold only 1 litre of water.
				glasses[index] = water >= 1.0f ? 1.0f : glasses[index];

				// Water remaining.
				water = water >= 1.0f ? water - 1.0f : 0;

				// Distribution not required for the last row.
				if (r != i) {
					// distribute water to its children.
					glasses[index + r] += water / 2.0f;

					glasses[index + r + 1] += water / 2.0f;
				}

			}
		}

		// Index of ith row, jth column is no of elements till (i-1)row + j -1
		return glasses[i * (i - 1) / 2 + j - 1];

	}

	public static void main(String[] args) {

		int i = 3, j = 2;
		float X = 5.5f; // Total amount of water

		System.out.println(findWater(i, j, X));
		System.out.println(findWaterInGlass(i, j, X));

	}

}
