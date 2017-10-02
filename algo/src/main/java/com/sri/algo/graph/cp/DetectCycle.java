package com.sri.algo.graph.cp;

import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycle {

	public static boolean hasCycle(int v, LinkedList<Integer>[] adj, boolean[] visited, boolean[] explored) {
		visited[v] = true;
		explored[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				if (hasCycle(n, adj, visited, explored)) {
					return true;
				}
			} else if (visited[n] && explored[n]) {
				return true;
			}
		}
		explored[v] = false;

		return false;
	}
	
	
	public static void main(String args[])
    {
    	DiGraph g = new DiGraph(2);
 
        g.addEdge(0, 1);
        g.addEdge(0, 0);
        
        
        boolean[] visited = new boolean[2];
        boolean[] explored = new boolean[2];
        
        System.out.println(hasCycle(0, g.getAdjacencyListAsArray(),visited, explored));
        
    	DiGraph g1 = new DiGraph(4);
    	 
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        
        visited = new boolean[4];
        explored = new boolean[4];
        
        System.out.println(hasCycle(0, g1.getAdjacencyListAsArray(), visited, explored));
 
    }

}
