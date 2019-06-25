package com.sri.algo.graph.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. 
 * However, the order among letters are unknown to you. You receive
   a list of non-empty words from the dictionary, where words are sorted 
   lexicographically by the rules of this new language. 
 * Derive the order of letters in this language.
 * @author salla
 *
 */
public class AlienDictionary {
	
	 Map<Character,Set<Character>> graph = new HashMap<>();
	 boolean hasCycle = false;
	 public String alienOrderUsingDFS(String[] words) {
		 
		 if (words == null || words.length == 0)
		 {
			 return "";
		 }
		 
		 for (String word : words)
		 {	 
			 for (int i=0 ;i < word.length() - 1;i++)
			 {
				 char ch = word.charAt(i);
				 char next = word.charAt(i + 1);
				 
				 if (!graph.containsKey(ch))
				 {
					 graph.put(ch, new HashSet<>());
				 }
				 
				 if (!graph.containsKey(next))
				 {
					 graph.put(next, new HashSet<>());
				 }
				 
				 graph.get(ch).add(next);
			 }
		 }
		 List<Character> alienOrder = new ArrayList<>();
		 Set<Character> visited = new HashSet<>();
		 Set<Character> dfsStack = new HashSet<>();
		 
		 
		 for (Character ch : graph.keySet())
		 {
			 if (!visited.contains(ch))
			 {
				 dfs(graph, ch, visited, alienOrder,dfsStack);
			
			 }
		 }
		 
		 if (hasCycle)
		 {
			 return "";
		 }
		 
		 StringBuilder sb = new StringBuilder();	 
		 for (int i = alienOrder.size() - 1; i>=0; i--)
		 {
			 sb.append(alienOrder.get(i));
		 }
		 
		 return sb.toString();
	        
	   }
	 
	 private void dfs(Map<Character,Set<Character>> graph,  char ch, Set<Character> visited, List<Character> alienOrder,  Set<Character> path)
	 { 
		 
		 if (hasCycle)
		 {
			 return;
		 }
		 
		 visited.add(ch);
		 path.add(ch);
		 
		 Set<Character>  adjVertices = graph.get(ch);
		 for (char adjV : adjVertices)
		 {		 
			 if (!visited.contains(adjV))
			 {
				 dfs(graph, adjV,visited, alienOrder, path);
			 }
			 else if (path.contains(adjV) && ch != adjV)
			 {
				 hasCycle = true;
			 }
		 }
		 
		 path.remove(ch);
		 alienOrder.add(ch);
		 
	 }
	 
	 public String alienOrder(String[] words) {
		    Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
		    Map<Character, Integer> degree=new HashMap<Character, Integer>();
		    String result="";
		    if(words==null || words.length==0) return result;
		    for(String s: words){
		        for(char c: s.toCharArray()){
		            degree.put(c,0);
		        }
		    }
		    for(int i=0; i<words.length-1; i++){
		        String cur=words[i];
		        String next=words[i+1];
		        int length=Math.min(cur.length(), next.length());
		        for(int j=0; j<length; j++){
		            char c1=cur.charAt(j);
		            char c2=next.charAt(j);
		            if(c1!=c2){
		                Set<Character> set=new HashSet<Character>();
		                if(map.containsKey(c1)) set=map.get(c1);
		                if(!set.contains(c2)){
		                    set.add(c2);
		                    map.put(c1, set);
		                    degree.put(c2, degree.get(c2)+1);
		                }
		                break;
		            }
		        }
		    }
		    Queue<Character> q=new LinkedList<Character>();
		    for(char c: degree.keySet()){
		        if(degree.get(c)==0) q.add(c);
		    }
		    while(!q.isEmpty()){
		        char c=q.remove();
		        result+=c;
		        if(map.containsKey(c)){
		            for(char c2: map.get(c)){
		                degree.put(c2,degree.get(c2)-1);
		                if(degree.get(c2)==0) q.add(c2);
		            }
		        }
		    }
		    if(result.length()!=degree.size()) return "";
		    return result;
		}
	 
	 public String alienOrder2(String[] words) {
		 
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> degree = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (String word : words) {
			for (char ch : word.toCharArray()) {
				degree.put(ch, 0);
			}
		}
		
		for (int i=0 ;i < words.length -1; i++)
		{
			String curr = words[i];
			String next = words[i + 1];
			
			int len = Math.min(curr.length(), next.length());
			
			for (int j= 0; j < len;j++)
			{
				char c1 = curr.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2)
				{
					if (!map.containsKey(c1))
					{
						map.put(c1, new HashSet<>());
					}
					
					Set<Character> set = map.get(c1);
					if (!set.contains(c2))
					{
						set.add(c2);
						degree.put(c2, degree.get(c2) + 1);
					}
					
					break;
				}
			}
		}
			
			Queue<Character> q = new LinkedList<>();
			
			for (char ch : degree.keySet())
			{
				if (degree.get(ch) == 0)
				{
					q.add(ch);
				}
			}
			
			while (!q.isEmpty())
			{		
				char ch = q.poll();
				sb.append(ch);
				
				if (map.containsKey(ch))
				{
					for (char adjCh : map.get(ch))
					{
						degree.put(adjCh, degree.get(adjCh) - 1);		
						if (degree.get(adjCh) == 0)
						{
							q.add(adjCh);
						}
					}
				}
			}
			
			return sb.length() == degree.size() ? sb.toString() : "";
		}
		
	
	 
	 public static void main(String[] args) {
		
		 
		 String[] words = new String[] {
		                                 "wrt",
		                                 "wrf",
		                                 "er",
		                                 "ett",
		                                 "rftt"
		                               };
		 
		// String[] words = new String[] { "z", "x", "z"};
		 
		 AlienDictionary ad = new AlienDictionary();
		 
		 System.out.println(
			 ad.alienOrder(words));
		 System.out.println(
				 ad.alienOrder2(words));
	}
}
