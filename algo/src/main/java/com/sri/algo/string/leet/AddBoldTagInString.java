package com.sri.algo.string.leet;


/**
 *  Given a string s and a list of strings dict, you need to add a 
 *  closed pair of bold tag <b> and </b> to wrap the substrings in s 
 *  that exist in dict. If two such substrings overlap, you need to 
 *  wrap them together by only one pair of closed bold tag. 
 *  
 *  Also, if two substrings wrapped by bold tags are consecutive, 
 *  you need to combine them.
 *  
	Example 1:
	Input: 
	s = "abcxyz123"
	dict = ["abc","123"]
	Output:
	"<b>abc</b>xyz<b>123</b>"
 * @author salla
 *
 */
public class AddBoldTagInString {
	
	public String addBoldTag1(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return result.toString();
    }
	
	public String addBoldTag(String s, String[] dict) 
	{
		boolean[] bold = new boolean[s.length()];
		
		for (int i=0,end=0; i< s.length(); i++)
		{
			for (String word : dict)
			{
				if(s.startsWith(word, i))
				{
					end = Math.max(end, i + word.length());
				}
			}
			
			bold[i] = end > i;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i < s.length(); i++)
		{
			if (!bold[i])
			{
				sb.append(s.charAt(i));
				continue;
			}
			
			int j=i;
			
			while(j < s.length() && bold[j])
			{
				j++;
			}
			
			sb.append("<b>").append(s.substring(i, j)).append("</b>");
			
			i = j -1;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		AddBoldTagInString addBoldTagInString = new
				AddBoldTagInString();
		
		 System.out.println(
				addBoldTagInString.addBoldTag("abcxyz123", new String[] {"abc","123"}));
		
		System.out.println(
				addBoldTagInString.addBoldTag("aaabbcc", new String[] {"aaa","aab","bc"}));
		
	}

}
