package com.sri.algo.dp.cp;

import java.util.Scanner;

/**
 * Given a 2D array, find the maximum sum subarray in it. For example, 
 * in the following 2D array, the maximum sum subarray is highlighted with blue rectangle 
 * and sum of this subarray is 29.
 * 
 *
 */
public class MaxSumRectangle {
	
	public static int[] kadane(int[] a) {
        //result[0] == maxSum, result[1] == start, result[2] == end;
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0;
        int localStart = 0;
     
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                  currentSum = 0;
                localStart = i + 1;
              } else if (currentSum > result[0]) {
                result[0] = currentSum;
                result[1] = localStart;
                result[2] = i;
              }
        }
         
        //all numbers in a are negative
        if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] > result[0]) {
                    result[0] = a[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }
         
        return result;
      }
 
    /**
     * To find and print maxSum, (left, top),(right, bottom)
     */
    public static void findMaxSubMatrix(int[][] a) {
        int cols = a[0].length;
        int rows = a.length;
        int[] currentResult;
        int maxSum = Integer.MIN_VALUE;
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;
         
        for (int leftCol = 0; leftCol < cols; leftCol++) {
            int[] tmp = new int[rows];
     
              for (int rightCol = leftCol; rightCol < cols; rightCol++) {
         
                for (int i = 0; i < rows; i++) {
                      tmp[i] += a[i][rightCol];
                }
                currentResult = kadane(tmp);
                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    left = leftCol;
                    top = currentResult[1];
                    right = rightCol;
                    bottom = currentResult[2];
                }
            }
        }
              System.out.println("MaxSum: " + maxSum + 
                                ", range: [(" + left + ", " + top + 
                                  ")(" + right + ", " + bottom + ")]");
    }


	public static int maxSum(int[][] table, int n, int m) {

		int[] temp;
		int max = table[0][0];

		int cStart = 0, cEnd = 0, rEnd = 0, rStart = 0;
		for (int j = 0; j < m; j++) {
			temp = new int[n];
			for (int k = j; k < m; k++) {
				for (int i = 0; i < n; i++) {
					temp[i] = temp[i] + table[i][k];
				}

				int[] res = new int[3];
				applyKadane(temp, res);

				if (max < res[2]) {
					max = res[2];
					cStart = j;
					cEnd = k;
					rStart = res[0];
					rEnd = res[1];
				}

			}
		}
		
		System.out.println("top left (" + rStart + "," + cStart+ ")");
		System.out.println("bottom right (" + rEnd + "," + cEnd+ ")");

		return max;
	}

	private static void applyKadane(int[] temp, int[] arr) {
		int max_so_far = temp[0], max_till_here = temp[0];
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = temp[0];
		
		int l = 0, r = 0;
		for (int i = 1; i < temp.length; i++) {

			if (temp[i] > temp[i] + max_till_here) {
				max_till_here = temp[i];
				l = i;
				r = i;
			} else {
				max_till_here = temp[i] + max_till_here;
				r = i;
			}

			if (max_till_here > max_so_far) {
				max_so_far = max_till_here;
				arr[0] = l;
				arr[1] = r;
				arr[2] = max_so_far;
			}
		}
	}

	public static void main(String[] args) {

		/*System.out.println(
			maxSum(new int[][] { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } }, 4,
				5));*/
		
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int k = 0; k < testCount; k++) {
				int n = in.nextInt();
				int m = in.nextInt();
				int[][] matrix = new int[n][m];

				for (int i = 0; i < n; i++) {
				    	for (int j = 0; j < m; j++) {

					       matrix[i][j] = in.nextInt();
				    	}
				}

				System.out.println(maxSum(matrix, n, m));
				
				findMaxSubMatrix(matrix);
			}
		}
	
	}

}
