package com.sri.algo.graph.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * 
 * 	Strings A and B are K-similar (for some non-negative integer K) if we can swap 
 *  the positions of two letters in A exactly K times so that the resulting string 
 *  equals B.

	Given two anagrams A and B, return the smallest K for which A and B are 
	K-similar.
	
	Example 1:
	
	Input: A = "ab", B = "ba"
	Output: 1
 * @author salla
 *
 */
public class KSimilarStrings {

	public int kSimilarity(String A, String B) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap<>();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) return dist.get(S);
            for (String T: neighbors(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
    }

    public List<String> neighbors(String S, String target) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        for (; i < S.length(); ++i) {
            if (S.charAt(i) != target.charAt(i)) break;
        }

        char[] T = S.toCharArray();
        for (int j = i+1; j < S.length(); ++j)
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }

        return ans;
    }

    public void swap(char[] T, int i, int j) {
        char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }
    
    
    public static void main(String[] args) {
    	
    	
    	KSimilarStrings kSimilarStrings = new KSimilarStrings();
    	
    	System.out.println(
			kSimilarStrings.kSimilarity("ab", "ba"));
		
	}

}
