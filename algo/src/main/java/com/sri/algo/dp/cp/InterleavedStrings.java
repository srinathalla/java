package com.sri.algo.dp.cp;

/**
 * Given three strings A, B and C. Write a function that checks whether C is an
 * interleaving of A and B. C is said to be interleaving A and B,if it contains
 * all characters of A and B and order of all characters in individual strings
 * is preserved.
 *
 */
public class InterleavedStrings {

	/**
	 * Time Complexity is O(2^n)
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static boolean isInterLeave(String a, String b, String c) {

		return isInterLeave(a, b, c, a.length(), b.length(), c.length());
	}

	public static boolean isInterLeave(String a, String b, String c, int i, int j, int k) {

		if (i == 0 && j == 0 && k == 0) {
			return true;
		}

		if (k == 0) {
			return false;
		}

		return (i > 0 && a.charAt(i - 1) == c.charAt(k - 1) && isInterLeave(a, b, c, i - 1, j, k - 1))
				|| (j > 0 && b.charAt(j - 1) == c.charAt(k - 1) && isInterLeave(a, b, c, i, j - 1, k - 1));

	}

	public static boolean isInterLeaveWithDP(String s1, String s2, String s3) {

		  
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        
        if (l != n + m)
		{
			return false;
		}
        boolean[][] table = new boolean[n +1 ][m + 1];
        table[0][0] = true;
        for (int i=1 ;i <= n; i++)
        { 
             table[i][0] = table[i-1][0] && s1.charAt(i-1) == s3.charAt(i -1);
        }
        
        for (int j=1 ;j <= m; j++)
        { 
             table[0][j] = table[0][j-1] && s2.charAt(j-1) == s3.charAt(j -1);
        }
        
        for (int i=1 ;i <= n; i++)
        { 
             for (int j=1 ;j <= m; j++)
             {
                 table[i][j] = 
                     (table[i-1][j] && s1.charAt(i-1) == s3.charAt(i +j-1)) || 
                     (table[i][j-1] && s2.charAt(j-1) == s3.charAt(i +j-1));
             }
        }
        
        return table[n][m];

	}
	
	public static void main(String[] args) {

		/*System.out.println(isInterLeaveWithDP("YX", "X", "XXY"));
		System.out.println(isInterLeaveWithDP("XY", "X", "XXY"));
		System.out.println(isInterLeaveWithDP("YXXYXX", "YYYXX", "YXXYYXXXXYX"));

		System.out.println(isInterLeaveWithDP("aab", "axy", "aaxaby"));
		System.out.println(isInterLeaveWithDP("YXY", "XYXYX", "XXXXYYXY"));
		System.out.println(isInterLeaveWithDP("XXXXY", "YXXXY", "XYXXXXYXXY"));*/
		
		System.out.println(isInterLeaveWithDP("aab", "axy", "aaxaby"));
		
		String a = "baababbabbababbaaababbbbbbbbbbbaabaabaaaabaaabbaaabaaaababaabaaabaabbbbaabbaabaabbbbabbbababbaaaabab";
		String b = "aababaaabbbababababaabbbababaababbababbbbabbbbbababbbabaaaaabaaabbabbaaabbababbaaaababaababbbbabbbbb";
		String c = "babbabbabbababbaaababbbbaababbaabbbbabbbbbaaabbabaababaabaaabaabbbaaaabbabbaaaaabbabbaabaaaabbbbababbbababbabaaba";

		System.out.println(isInterLeaveWithDP(a, b, c));
	}
}
