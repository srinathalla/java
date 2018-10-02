package com.sri.algo.math.leet;

/**
 *  There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 
 *  2D grid. Your goal is to find the minimal distance for the squirrel to collect all the 
 *  nuts and put them under the tree one by one. The squirrel can only take at most one nut 
 *  at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
	
	Example 1:
	Input: 
	Height : 5
	Width : 7
	Tree position : [2,2]
	Squirrel : [4,4]
	Nuts : [[3,0], [2,5]]
	Output: 12
	Explanation:
	
	Note:
	All given positions won't overlap.
	The squirrel can take at most one nut at one time.
	The given positions of nuts have no order.
	Height and width are positive integers. 3 <= height * width <= 10,000.
	The given positions contain at least one nut, only one tree and one squirrel.

 * @author salla
 *
 */
public class SquirrelSimulation {

	/**
	 * T.C : O(n) where n is no of nuts.
	 * 
	 * Idea here is not to pick nut nearest to the
	 * 
	 * @param height
	 * @param width
	 * @param tree
	 * @param squirrel
	 * @param nuts
	 * @return
	 */
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {

		int total = 0, d = Integer.MIN_VALUE;
		for (int[] nut : nuts) {
			total += 2 * distance(nut, tree);

			d = Integer.max(d, distance(nut, tree) - distance(nut, squirrel));

		}

		return total - d;
	}

	private int distance(int[] a, int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static void main(String[] args) {

		SquirrelSimulation ss = new SquirrelSimulation();

		System.out.println(ss.minDistance(5, 7, new int[] { 2, 2 }, //
				new int[] { 4, 4 }, //
				new int[][] 
						{ //
			            { 3, 0 }, //
						{ 2, 5 } }));

	}

}
