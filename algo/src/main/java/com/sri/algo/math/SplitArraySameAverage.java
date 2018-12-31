package com.sri.algo.math;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * In a given integer array A, we must move every element of A to either list B
 * or list C. (B and C initially start empty.)
 * 
 * Return true if and only if after such a move, it is possible that the average
 * value of B is equal to the average value of C, and B and C are both
 * non-empty.
 * 
 * Example : Input: [1,2,3,4,5,6,7,8] Output: true Explanation: We can split the
 * array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 * Note:
 * 
 * The length of A will be in the range [1, 30]. A[i] will be in the range of
 * [0, 10000].
 * 
 * @author salla
 *
 */
public class SplitArraySameAverage {

	/**
	 * Time Complexity: O(2 ​N/2 ​​ ), where NN is the length of A.
	 * 
	 * Space Complexity: O(2 ​N/2 ​​ ).
	 * 
	 * 
	 * @param A
	 * @return
	 */
	public boolean splitArraySameAverage(int[] A) {
		int N = A.length;
		int S = 0;
		for (int x : A)
			S += x;
		if (N == 1)
			return false;

		int g = gcd(S, N);
		Point mu = new Point(-(S / g), N / g);
		// A[i] -> fracAdd(A[i], mu)
		List<Point> A2 = new ArrayList();
		for (int x : A)
			A2.add(fracAdd(new Point(x, 1), mu));

		Set<Point> left = new HashSet();
		left.add(A2.get(0));
		for (int i = 1; i < N / 2; ++i) {
			Set<Point> left2 = new HashSet();
			Point z = A2.get(i);
			left2.add(z);
			for (Point p : left) {
				left2.add(p);
				left2.add(fracAdd(p, z));
			}
			left = left2;
		}

		if (left.contains(new Point(0, 1)))
			return true;

		Set<Point> right = new HashSet();
		right.add(A2.get(N - 1));
		for (int i = N / 2; i < N - 1; ++i) {
			Set<Point> right2 = new HashSet();
			Point z = A2.get(i);
			right2.add(z);
			for (Point p : right) {
				right2.add(p);
				right2.add(fracAdd(p, z));
			}
			right = right2;
		}

		if (right.contains(new Point(0, 1)))
			return true;

		Point sleft = new Point(0, 1);
		for (int i = 0; i < N / 2; ++i)
			sleft = fracAdd(sleft, A2.get(i));

		Point sright = new Point(0, 1);
		for (int i = N / 2; i < N; ++i)
			sright = fracAdd(sright, A2.get(i));

		for (Point ha : left) {
			Point ha2 = new Point(-ha.x, ha.y);
			if (right.contains(ha2) && (!ha.equals(sleft) || !ha2.equals(sright)))
				return true;
		}
		return false;
	}

	public Point fracAdd(Point A, Point B) {
		int numer = A.x * B.y + B.x * A.y;
		int denom = A.y * B.y;
		int g = gcd(numer, denom);
		numer /= g;
		denom /= g;

		if (denom < 0) {
			numer *= -1;
			denom *= -1;
		}

		return new Point(numer, denom);
	}

	public int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {

		SplitArraySameAverage splitArray = new SplitArraySameAverage();

		System.out.println(splitArray.splitArraySameAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));

	}

}
