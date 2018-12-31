package com.sri.algo.dp.cp;


/**
 *   Given strings S and T, find the minimum (contiguous) substring W of S, 
 *   so that T is a subsequence of W.

	If there is no such window in S that covers all characters in T, 
	return the empty string "". If there are multiple such minimum-length windows, 
	return the one with the left-most starting index.

	Example 1:
	Input: 
	S = "abcdebdde", T = "bde"
	Output: "bcde"
	Explanation: 
	"bcde" is the answer because it occurs before "bdde" which has the same length.
	"deb" is not a smaller window because the elements of T in the window must occur in order.
	Note:

	All the strings in the input will only contain lowercase letters.
	The length of S will be in the range [1, 20000].
	The length of T will be in the range [1, 100].

 * @author salla
 *
 */
public class MinimumWindowSubsequence {

	
	
	/**
	 * T.C : O(n*m).
	 * 
	 * Idea is to store the starting index of all matched characters from T.
	 * 
	 * @param S
	 * @param T
	 * @return
	 */
	public String minWindow(String S, String T) 
	{
		int n = T.length();
		int m = S.length();
		
		if(n == 0 || m == 0)
		{
			return "";
		}
		
		int[][] dp = new int[n +1][m +1];
		for (int i=0; i<=m;i++)
		{
			dp[0][i] = i + 1;
			System.out.print(dp[0][i] + " ");
		}
		
		System.out.println();
		
		for (int i = 1; i<= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				
				// If char's match dp(matrix) stores the starting index of matched substring till i. 
				if (T.charAt(i -1) == S.charAt(j -1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					// If they dont match store 
					dp[i][j] = dp[i][j-1];
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
			
		}
		
		int len = m + 1;
		int start = 0;
		for (int i =1;i <= m ;i++)
		{
			
			if (dp[n][i] != 0 && i - dp[n][i] + 1 < len)
			{
				len = i - dp[n][i] + 1;
				start = dp[n][i] -1;
			}
		}
		
		
		return len == m  + 1 ? "" : S.substring(start, start + len);
        
	}
	
	public String minWindowWithTableSizeN(String S, String T) 
	{
		int n = T.length();
		int m = S.length();
		
		if(n == 0 || m == 0)
		{
			return "";
		}
		
		int[][] dp = new int[n][m];
		for (int i=0; i<=m;i++)
		{
			dp[0][i] = i + 1;
		}
		
		for (int i = 1; i<= n; i++)
		{
			for (int j = 1; j <= m; j++)
			{
				
				// If char's match dp(matrix) stores the starting index of matched substring till i. 
				if (T.charAt(i -1) == S.charAt(j -1))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					// If they dont match store 
					dp[i][j] = dp[i][j-1];
				}
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
			
		}
		
		int len = m + 1;
		int start = 0;
		for (int i =1;i <= m ;i++)
		{
			
			if (dp[n][i] != 0 && i - dp[n][i] + 1 < len)
			{
				len = i - dp[n][i] + 1;
				start = dp[n][i] -1;
			}
		}
		
		
		return len == m  + 1 ? "" : S.substring(start, start + len);
        
	}
	
	public static void main(String[] args) 
	{
		
		MinimumWindowSubsequence mwss = new MinimumWindowSubsequence();
		
		 System.out.println(mwss.minWindow("abcdebdde", "bde"));
		
		/*System.out.println(mwss.minWindow(
				"ffynmlzesdshlvugsigobutgaetsnjlizvqjdpccdylclqcbghhixpjihximvhapymfkjxyyxfwvsfyctmhwmfjyjidnfryiyajmtakisaxwglwpqaxaicuprrvxybzdxunypzofhpclqiybgniqzsdeqwrdsfjyfkgmejxfqjkmukvgygafwokeoegla" +
				"nevavyrpduigitmrimtaslzboauwbluvlfqquocxrzrbvvplsivujojscytmeyjolvvyzwizpuhejsdzkfwgqdbwinkxqypaphktonqwwanapouqyjdbptqfowhemsnsl", "ntimcimzah"));
		
		System.out.println(mwss.minWindow(
				"jmeqksfrsdcmsiwvaovztaqenprpvnbstl",
				"u"));
		
		System.out.println(mwss.minWindow(
				"fgrqsqsnodwmxzkzxwqegkndaa",
				"fnok"));*/
		
	}

}
