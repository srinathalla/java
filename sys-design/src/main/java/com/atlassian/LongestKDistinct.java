package com.atlassian;

import java.util.HashMap;
import java.util.Map;

public class LongestKDistinct {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(k ==0 || s == null || s.isEmpty())
        {
            return 0;
        }
        int l =0;
        int ans = 0;
        Map<Character,Integer> freq = new HashMap<>();
        for(int r=0; r < s.length();r++)
        {
            char c = s.charAt(r);
            freq.put(c,freq.getOrDefault(c,0) + 1);

            if(freq.size() > k)
            {
                char lc = s.charAt(l);
                freq.put(lc,freq.get(lc) - 1);

                if(freq.get(lc) == 0)
                {
                    freq.remove(lc);
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aabbcc",2));
        System.out.println(lengthOfLongestSubstringKDistinct("aabbcc",3));
    }
}
