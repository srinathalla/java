package com.sri.algo.graph.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule2 {
	
	
	   boolean hasCycle = false;
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        

			Map<Integer, Set<Integer>> graph = new HashMap<>();

			for (int i = 0; i < numCourses; i++) {
				graph.put(i, new HashSet<>());
			}

			for (int[] edge : prerequisites) {
				graph.get(edge[1]).add(edge[0]);
			}

			int[] order = new int[numCourses];
			boolean[] visited = new boolean[numCourses];
			int[] idx = new int[1];
			boolean[] visiting = new boolean[numCourses];
			for (int i = 0; i < numCourses; i++) {
				if (!visited[i]) {
					dfs(graph, visited, i, order, idx, visiting);
				}
			}

			return hasCycle ? false : true;

		}

		private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int v, int[] order, int[] idx,
				boolean[]  visiting) {
			visited[v] = true;
			visiting[v] = true;

			for (Integer adjV : graph.get(v)) {
				if (hasCycle)
				{
					return;
				}
				
				if (!visited[adjV]) {
					dfs(graph, visited, adjV, order, idx, visiting);
				} else if (visiting[adjV]) {
					hasCycle = true;
				}
			}

			visiting[v] = false;
			order[idx[0]++] = v;
		}

}
