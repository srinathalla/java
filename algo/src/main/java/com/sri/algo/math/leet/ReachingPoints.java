package com.sri.algo.math.leet;

/**
 * A move consists of taking a point (x, y) and transforming it to either (x,
 * x+y) or (x+y, y).
 * 
 * Given a starting point (sx, sy) and a target point (tx, ty), return True if
 * and only if a sequence of moves exists to transform the point (sx, sy) to
 * (tx, ty). Otherwise, return False.
 * 
 * Examples: Input: sx = 1, sy = 1, tx = 3, ty = 5 Output: True Explanation: One
 * series of moves that transforms the starting point to the target is: (1, 1)
 * -> (1, 2) (1, 2) -> (3, 2) (3, 2) -> (3, 5)
 * 
 * Input: sx = 1, sy = 1, tx = 2, ty = 2 Output: False
 * 
 * Input: sx = 1, sy = 1, tx = 1, ty = 1 Output: True
 * 
 * @author salla
 *
 */
public class ReachingPoints {

	/**
	 * Start from give point and check all possible paths..
	 * 
	 * Time Complexity: O(2^{tx + ty}), a loose bound found by considering every
	 * move as (x, y) -> (x+1, y) or (x, y) -> (x, y+1) instead.
	 * 
	 * Space Complexity: O(tx * ty), the size of the implicit call stack.
	 * 
	 * @param sx
	 * @param sy
	 * @param tx
	 * @param ty
	 * @return
	 */
	public boolean reachingPointsMoveForward(int sx, int sy, int tx, int ty) {

		System.out.println("sx :" + sx + " sy:" + sy);
		if (sx == tx && sy == ty) {
			return true;
		}

		if (sx > tx || sy > ty) {
			return false;
		}

		return reachingPointsMoveForward(sx + sy, sy, tx, ty) || reachingPointsMoveForward(sx, sy + sx, tx, ty);
	}

	/**
	 * Time Complexity: O(max(tx,ty)). If say ty = 1, we could be subtracting tx
	 * times.
	 * 
	 * Space Complexity: O(1)O(1).
	 * 
	 * @param sx
	 * @param sy
	 * @param tx
	 * @param ty
	 * @return
	 */
	public boolean reachingPointsMoveBackward(int sx, int sy, int tx, int ty) {

		while (tx >= sx && ty >= sy) {
			if (sx == tx && sy == ty) {
				return true;
			}

			if (tx > ty) {
				tx -= ty;
			} else {
				ty -= tx;
			}
		}

		return false;
	}

	/**
	 * Accepted solution ..
	 * @param sx
	 * @param sy
	 * @param tx
	 * @param ty
	 * @return
	 */
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {

		while (tx >= sx && ty >= sy) {
			if (tx == ty) {
				break;
			}

			if (tx > ty) {

				if (ty > sy) {
					tx %= ty;
				} else {
					return (tx - sx) % ty == 0;
				}

			} else {

				if (tx > sx) {
					ty %= tx;
				} else {
					return (ty - sy) % tx == 0;
				}
			}
		}

		return tx == sx && ty == sy;
	}

	public static void main(String[] args) {

		ReachingPoints rp = new ReachingPoints();

		System.out.println(rp.reachingPoints(1, 1, 3, 5));

		// System.out.println(rp.reachingPointsMoveBackward(1, 1, 1000000000, 1));

	}

}
