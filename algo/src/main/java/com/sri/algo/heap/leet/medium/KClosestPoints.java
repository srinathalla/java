package com.sri.algo.heap.leet.medium;

import java.util.PriorityQueue;

import com.sri.algo.array.PrintArray;

/**
 * 	e have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

	Example 1:
	
	Input: points = [[1,3],[-2,2]], K = 1
	Output: [[-2,2]]
	Explanation: 
	The distance between (1, 3) and the origin is sqrt(10).
	The distance between (-2, 2) and the origin is sqrt(8).
	Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
	We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * 
 * @author salla
 *
 */
public class KClosestPoints {
	
	/**
	 * T.C : O(nlogn)
	 * @param points
	 * @param K
	 * @return
	 */
	 public int[][] kClosest1(int[][] points, int K) {
		 
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

		for (int[] p : points) {
			pq.add(p);
		}

		int[][] result = new int[K][2];

		int i = 0;
		while (i < K) {
			
			result[i] = pq.poll();
			i++;
		}
		
		return result;

	}
	 
	 /**
	  * T.C : O(nlogK)
	  * 
	  * @param points
	  * @param K
	  * @return
	  */
	 public int[][] kClosest2(int[][] points, int K) {
		 
		 PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->  (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

			for (int[] p : points) {
				pq.add(p);
				
				if(pq.size() > K)
				{
					pq.poll();
				}
			}

			int[][] result = new int[K][2];

			while (K > 0) {
				
				result[K-1] = pq.poll();
				K--;
			}
			
			return result;

		}
	 
	 public static void main(String[] args) {
		 
		 KClosestPoints kClosestPoints = new KClosestPoints();
		 
		int[][] res =  kClosestPoints.kClosest2(new int[][] {{1,3},{-2,2}}, 1);
		
		PrintArray.print2dArray(res);
		
	}

}
