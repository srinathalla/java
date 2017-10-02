package com.sri.algo.graph.cp;

import java.util.ArrayList;
import java.util.Stack;

/**
 *  
 *      I/P :
 *      V = 6 E = 6 
		5 0 5 2 2 3 4 0 4 1 1 3
		
		O/P : 5 4 2 1 3 0
 *
 */
public class TopologicalSort {
	
	
	 public static int[] topoSort(ArrayList<Integer> graph[],int N)
     {
		 boolean[] visited = new  boolean[N];
		 Stack<Integer> topSorted = new Stack<>();
		 
		 for (int i = 0 ;i < graph.length ;i ++)
		 {
			 if (!visited[i])
			 {
				 topologicalSort(i,graph,visited,topSorted);
			 }
		 }
		 
		 int[] topSortedArr = new int[topSorted.size()];
		 
		 int index = 0;
		 while(!topSorted.isEmpty())
		 {
			 topSortedArr[index] = topSorted.pop();
			 index++;
		 }	 
		 return topSortedArr;
     }
	 
	 private static void topologicalSort(int v, ArrayList<Integer> graph[], boolean[] visited, Stack<Integer> topSorted)
     {
		 visited[v] = true;	 
		 ArrayList<Integer> adjList = graph[v];
		 
		 for (Integer adjV : adjList)
		 {
			 if (!visited[adjV])
			 {
				 topologicalSort(adjV,graph,visited,topSorted);
			 }
		 }
		 
		 topSorted.push(v);
     }
	 
	 
	 public static void main(String[] args) {
		 
		 DiGraph g = new DiGraph(6);
		 
	        g.addEdge(5, 0);
	        g.addEdge(5, 2);
	        g.addEdge(2, 3);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(1, 3);
	        
	        int[] topSort = topoSort(g.getAdjacencyListAsArrayOfArrayList(),6);
	        
	        for (int ele : topSort)
	        {
	        	System.out.print(ele + " ");
	        }
		
	}

}
