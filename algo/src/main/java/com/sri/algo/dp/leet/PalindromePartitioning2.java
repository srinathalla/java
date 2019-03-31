package com.sri.algo.dp.leet;


/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.

	Return the minimum cuts needed for a palindrome partitioning of s.
	
	Example:
	
	Input: "aab"
	Output: 1
	Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
	
	
 * @author salla
 *
 */
public class PalindromePartitioning2 {
	
	/**
	 * T.C : O(n^2)
	 * 
	 * @param s
	 * @return
	 */
	public int minCut1(String s) {
		int len = s.length();

		int[] cuts = new int[len];

		if (len < 2) {
			return 0;
		}

		for (int i = 0; i < len; i++) {
			cuts[i] = i;
		}

		for (int i = 0; i < len; i++) {
			extend1(s, i, i, cuts);
			extend1(s, i, i + 1, cuts);
		}

		return cuts[len - 1];
	}

	private void extend1(String s, int left, int right, int[] cuts) {

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

			if (left == 0) {
				// sub string 0 ..right is a palinndrome, no cuts are required ..
				cuts[right] = 0;
			} else {
				cuts[right] = Integer.min(cuts[right], cuts[left - 1] + 1);
			}
			left--;
			right++;
		}

	}
	
    public int minCut(String s) {
    	
    	int n = s.length();
    	int[] cuts = new int[n];
    	
    	for (int i=0; i< n; i++)
    	{
    		cuts[i] = i;
    	}
    	
    	for (int i=0; i< n; i++)
    	{
    		extend(s,i,i,cuts);
    		extend(s,i,i + 1,cuts);
    	}
    	
    	
    	return cuts[n-1];
        
    }
    
    
    private void extend(String s, int l, int r,int[]  cuts)
    {
    	while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r))
    	{	
    		if (l ==0)
    		{
    			cuts[r] = 0;
    		}
    		else
    		{
    			cuts[r] = Integer.min(cuts[r], cuts[l-1] + 1);
    		}
    		
    		l--;
        	r++;
    	}
    
    }
	
	public static void main(String[] args) {
		
		
		PalindromePartitioning2 pp = new PalindromePartitioning2();
		
		System.out.println(
			pp.minCut("aab"));
		System.out.println(
				pp.minCut("abcd"));
		
	}

}
