package com.sri.algo.graph.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sri.algo.array.PrintArray;

/**
 *  There are a total of n courses you have to take, labeled from 0 to n-1.

	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
	
	There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
	
	Example 1:
	
	Input: 2, [[1,0]] 
	Output: [0,1]
	Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
	             course 0. So the correct course order is [0,1] .
 * @author salla
 *
 */
public class CourseSchedule {

	boolean hasCycle = false;

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		Map<Integer, Set<Integer>> graph = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			graph.put(i, new HashSet<>());
		}

		for (int[] edge : prerequisites) {
			graph.get(edge[0]).add(edge[1]);
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

		return hasCycle ? new int[0] : order;

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

	public static void main(String[] args) {

		CourseSchedule cs = new CourseSchedule();

		// int[] order = cs.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
		int[] order = cs.findOrder(2, new int[][] { { 0, 1 } });
		PrintArray.print(order);
	}

}
