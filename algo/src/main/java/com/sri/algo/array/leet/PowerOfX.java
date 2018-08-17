package com.sri.algo.array.leet;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * 
 * Example 1:
 * 
 * Input: 2.00000, 10 Output: 1024.00000 Example 2:
 * 
 * Input: 2.10000, 3 Output: 9.26100 Example 3:
 * 
 * Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 = 0.25 Note:
 * 
 * -100.0 < x < 100.0 n is a 32-bit signed integer, within the range [−231, 231
 * − 1]
 * 
 * @author salla
 *
 */
public class PowerOfX {

	/**
	 * T.C O(n)
	 * 
	 * Naive approach timeout limit exceeded..
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPowNaive(double x, int n) {

		long N = n;
		if (n < 0) {
			x = 1 / x;
			N = -N;
		}

		double res = 1;

		for (long i = 0; i < N; i++) {
			res = res * x;
		}

		return res;
	}

	/**
	 * T.C O(logn) space complexity is O(log(n)).
	 * 
	 * x^4 => (x^2 * x^2) we need not multiply x four time we can use this formula..
	 * 
	 * Time complexity : O(log(n)). Each time we apply the formula (x ^ n) ^ 2 = x ^
	 * {2 * n}​​ =x ​2∗n ​​ , n is reduced by half. Thus we need at most O(log(n))
	 * computations to get the result.
	 * 
	 * Space complexity : O(log(n)), for each computation, we need to store the
	 * result of x ^ {n / 2}​​ . We need to do the computation for O(log(n)) times,
	 * so the space complexity is O(log(n)).
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPowWithRecusrion(double x, int n) {

		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		return fPow(x, n);
	}

	/**
	 * T.C O(logn)
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double fPow(double x, int n) {

		if (n == 0) {
			return 1.0;
		}

		double res = fPow(x, n / 2);

		if (n % 2 == 0) {
			return res * res;
		} else {
			return res * res * x;
		}
	}

	/**
	 * T.C O(logn)
	 * S.C :O(1)
	 * 
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		int N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}

		double curr_product = x, ans = 1;

		for (int i = N; i > 0; i = i / 2) {

			if (i % 2 == 1) {
				ans = ans * curr_product;
			}

			curr_product = curr_product * curr_product;
		}

		return ans;
	}

	public static void main(String[] args) {

		PowerOfX powerOfX = new PowerOfX();

		System.out.println(powerOfX.myPow(2.00000, 10));

		System.out.println(powerOfX.myPow(2.10000, 3));
		System.out.println(powerOfX.myPow(2.00000, -2));

		System.out.println(powerOfX.myPow(0.00001, 2147483647));

	}

}
