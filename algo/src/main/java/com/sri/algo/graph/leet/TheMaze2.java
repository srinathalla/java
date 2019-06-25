package com.sri.algo.graph.leet;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 	here is a ball in a maze with empty spaces and walls. The ball can go through 
 *  empty spaces by rolling up, down, left or right, but it won't stop rolling 
 *  until hitting a wall. When the ball stops, it could choose the next direction.

	Given the ball's start position, the destination and the maze, find the shortest 
	distance for the ball to stop at the destination.The distance is defined by the 
	number of empty spaces traveled by the ball from the start position (excluded) 
	to the destination (included). If the ball cannot stop at the destination, 
	return -1.

	The maze is represented by a binary 2D array. 1 means the wall and 0 means the
	empty space. You may assume that the borders of the maze are all walls. 
	The start and destination coordinates are represented by row and column indexes.
	
 * @author salla
 *
 */
public class TheMaze2 {
	
	 public int shortestDistance1(int[][] maze, int[] start, int[] dest) {
	        int[][] distance = new int[maze.length][maze[0].length];
	        for (int[] row: distance)
	            Arrays.fill(row, Integer.MAX_VALUE);
	        distance[start[0]][start[1]] = 0;
	        dfs(maze, start, distance);
	        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	    }

	    public void dfs(int[][] maze, int[] start, int[][] distance) {
	        int[][] dirs={{0,1}, {0,-1}, {-1,0}, {1,0}};
	        for (int[] dir: dirs) {
	            int x = start[0] + dir[0];
	            int y = start[1] + dir[1];
	            int count = 0;
	            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                x += dir[0];
	                y += dir[1];
	                count++;
	            }
	            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
	                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
	                dfs(maze, new int[]{x - dir[0],y - dir[1]}, distance);
	            }
	        }
	    }
	    
	    public int shortestDistance2(int[][] maze, int[] start, int[] dest) 
	    {
	    	int n = maze.length;
	    	int m = maze[0].length;
	    	int[][] dist = new int[n][m];
	    	
	    	for(int[] row : dist)
	    	{
	    		Arrays.fill(row, Integer.MAX_VALUE);
	    	}
	    	Queue<int[]> q = new LinkedList<>();
	    	q.add(start);
	    	dist[start[0]][start[1]] = 0;
	    	
	    	int[] rows = new int[] {-1,1,0,0};
	    	int[] cols = new int[] {0,0,-1,1};
	    	
	    	while(!q.isEmpty())
	    	{
	    		int[] curr = q.remove();
		    	for (int i=0;i < 4; i++)
		    	{
		    		int adjR = curr[0] + rows[i];
		    		int adjC = curr[1] + cols[i];
		    		int count = 0;
		    		
		    		while (adjR >=0 && adjR < n && adjC >=0 && adjC < m && maze[adjR][adjC] == 0)
		    		{
		    			adjR +=  rows[i];
		    			adjC +=  cols[i];
		    			count++;
		    		}
		    		
		    		if (dist[curr[0]][curr[1]] + count < dist[adjR- rows[i]][adjC - cols[i]])
		    		{
		    			dist[adjR- rows[i]][adjC - cols[i]] = dist[curr[0]][curr[1]] + count;
		    			q.add(new int[] {adjR- rows[i], adjC - cols[i]});
		    		}
		    	}
	    	}
	    	
	    	return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
	    	
	    }
	    
	    public int shortestDistance(int[][] maze, int[] start, int[] dest) 
	    {
	    	int n = maze.length;
	    	int m = maze[0].length;
	    	int[][] dist = new int[n][m];
	    	
	    	for(int[] row : dist)
	    	{
	    		Arrays.fill(row, Integer.MAX_VALUE);
	    	}
	    	PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
	    	q.add(new int[] {start[0], start[1], 0});
	    	dist[start[0]][start[1]] = 0;
	    	
	    	int[] rows = new int[] {-1,1,0,0};
	    	int[] cols = new int[] {0,0,-1,1};
	    	
	    	while(!q.isEmpty())
	    	{
	    		int[] curr = q.remove();
	    		
	    		if (dist[curr[0]][curr[1]] < curr[2])
	    		{
	    			continue;
	    		}
		    	for (int i=0;i < 4; i++)
		    	{
		    		int adjR = curr[0] + rows[i];
		    		int adjC = curr[1] + cols[i];
		    		int count = 0;
		    		
		    		while (adjR >=0 && adjR < n && adjC >=0 && adjC < m && maze[adjR][adjC] == 0)
		    		{
		    			adjR +=  rows[i];
		    			adjC +=  cols[i];
		    			count++;
		    		}
		    		
		    		if (dist[curr[0]][curr[1]] + count < dist[adjR- rows[i]][adjC - cols[i]])
		    		{
		    			dist[adjR- rows[i]][adjC - cols[i]] = dist[curr[0]][curr[1]] + count;
		    			q.add(new int[] {adjR- rows[i], adjC - cols[i],dist[adjR- rows[i]][adjC - cols[i]]});
		    		}
		    	}
	    	}
	    	
	    	return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
	    	
	    }
	    
	    public static void main(String[] args) {
	    	
	    	TheMaze2 theMaze2 = new TheMaze2();
	    	
	    	System.out.println(
    			theMaze2.shortestDistance(new int[][] {{0, 0, 1 ,0, 0},
	    		{0, 0 ,0 ,0, 0},	
	    		{0 ,0, 0, 1, 0},
	    		{1 ,1, 0, 1, 1},
	    		{0 ,0 ,0 ,0 ,0}}, new int[] {0,4}, new int[] {4,4}));
			
		}

}
