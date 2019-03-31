package com.sri.algo.string.leet;

import java.util.Arrays;

/**
 * T.C : O(n)  + O(m)
 *       where n is length of s, m is length of t.
 * 
 * @author salla
 *
 */
public class MinimumWindowSubstring {
	
	 int start = 0;
	 int len = 0;
	 public String minWindow(String s, String t) 
	 {
		 if(s.length() == 0 || t.length() == 0)
		 {
			 return "";
		 }
		 
		 len =  s.length() + 1;
		 int[] tdict = new int[256];
		 int required = 0;
		 
		 for (char ch : t.toCharArray())
		 {
			 if (tdict[ch] == 0)
			 {
				 required ++;
			 }	 
			 tdict[ch]++;
		 }
		 
		 int formed = 0;
		 int[] sdict = new int[256];
		 int j = 0;
		 for (int i=0; i < s.length(); i++)
		 {
			 char ch = s.charAt(i);
			 sdict[ch]++;
			 
			 // select only those chars present in sdict.
			 if (tdict[ch] > 0 && sdict[ch] == tdict[ch])
			 {
				 formed++;
			 }
			 		 
			 // once required chars are formed, try to reduce the window size.
			 while (j <= i && required == formed)
			 {		 
				 // if a smaller window is encountered update the len.
				 if(required == formed && i-j + 1 < len)
				 {
					 len = i - j + 1;
					 start = j;
				 }
				 			 
				 char dChar = s.charAt(j++); 
				 sdict[dChar]--;
				
				 // 
				 if (tdict[dChar] > 0 && sdict[dChar] < tdict[dChar])
				 {
					 formed--;
				 }
			 } 
		 }
		 
		 return len == s.length() + 1 ? "" : s.substring(start, start + len);
	
		 
	 }
	
	 public String minWindow1(String s, String t) {
	        
         if (s.length() == 0 || t.length() == 0)
			 {
				 return "";
			 }
		 
			int[] tdict = new int[256];
			int required = 0;
			for (char ch : t.toCharArray()) {
				if(tdict[ch] == 0)
				{
					required++;
				}	
				tdict[ch]++;
			}
			
			int[] wordCounts = new int[256];
			int formed = 0;
			
			int j=0;
			int[] arr = new int[3];
			Arrays.fill(arr, s.length() + 1);
			
			for (int i=0;i < s.length();i++)
			{
				char ch = s.charAt(i);
				
				wordCounts[ch]++;
				
				if (tdict[ch] > 0 && tdict[ch] == wordCounts[ch])
				{
					formed++;
				}
				
				while(j <= i && formed == required)
				{
					if (i- j + 1 < arr[0])
					{
						arr[0] = i- j + 1;
						arr[1] = j;
						arr[2] = i;
					}
					
					char delChar = s.charAt(j++);
					wordCounts[delChar]--;
					
					if (tdict[delChar] > 0 && wordCounts[delChar] < tdict[delChar])
					{
						formed--;
					}
				}	
			}
			
			return arr[0] == s.length() + 1 ? "" : s.substring(arr[1], arr[2] + 1);
	        
    }
	 
	 public static void main(String[] args) {
		
		 MinimumWindowSubstring minimumWindowSubstring = 
				 new MinimumWindowSubstring();
		 
		 System.out.println(
			 minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
	}

}
