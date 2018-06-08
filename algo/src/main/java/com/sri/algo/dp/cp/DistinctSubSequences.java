package com.sri.algo.dp.cp;

public class DistinctSubSequences {

	private static int count = 0;
	
	
	/**
	 * T.C : O(n*m) ..
	 * 
	 * Auxillary Space : O(n*m)
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static int numDistinct(String s, String t) {

		int n = s.length();
		int m = t.length();
		
		if (n < m) {
			return 0;
		}
		
		
		int[][] table = new int[n +1][m +1];
		
		for (int i = 0; i <= n ; i++)
		{
			table[i][0] = 1;
		}
		
		for (int i = 1; i <= n ; i++)
		{
			for (int j = 1; j <= m ; j++)
			{	
				table[i][j] = table[i-1][j] + (s.charAt(i-1) == t.charAt(j-1) ? table[i-1][j-1] :0) ;	
			}
		}
	
		return table[n][m];
	}

	/**
	 * Backtracking based solution ..
	 * 
	 * This gets TLE for some inputs ..
	 * we need to go with dp based solution ..
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static int numDistinctwithRecursion(String s, String t) {

		int n = s.length();
		int m = t.length();

		if (n < m) {
			return 0;
		}

		numDistinct(s, t, n, m, 0, new StringBuilder());

		return count;
	}

	/**
	 * Backtracking based solution ..
	 * 
	 * This gets TLE for some inputs.
	 * 
	 * we need to go with dp based solution ..
	 * 
	 * @param s
	 * @param t
	 * @param n
	 * @param m
	 * @param i
	 * @param sb
	 */
	private static void numDistinct(String s, String t, int n, int m, int i, StringBuilder sb) {
		// System.out.println(sb.toString());

		if (i == n) {
			return;
		}

		int pos = sb.length();
		
		if (t.charAt(pos) == s.charAt(i))
		{
			sb.append(s.charAt(i));
	
			if (t.length() == sb.length() && t.equals(sb.toString())) 
			{
				count++;	
			}
			
			else
			{
				numDistinct(s, t, n, m, i + 1, sb);	
			}
			
			sb.deleteCharAt(sb.length() - 1);
		}

		numDistinct(s, t, n, m, i + 1, sb);

	}

	public static void main(String[] args) {

		// System.out.println(numDistinct("rabbbit", "rabbit"));

		count = 0;

		// System.out.println(numDistinct("babgbag", "bag"));

		/* System.out.println(numDistinct("dbaaadcddccdddcadacbadbadbabbbcad", "dadcccbaab"));

		System.out.println(numDistinct(
				"aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe",
				"bddabdcae")); */
		
		System.out.println(numDistinct(
			"daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac",
		     "ceadbaa"));

	}

}
