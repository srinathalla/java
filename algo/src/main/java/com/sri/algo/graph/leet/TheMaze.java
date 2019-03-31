package com.sri.algo.graph.leet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 	There is a ball in a maze with empty spaces and walls. The ball can go through empty 
 * spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

    Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

    The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty 
    space. You may assume that the borders of the maze are all walls. The start and 
    destination coordinates are represented by row and column indexes.

 
 * @author salla
 *
 */
public class TheMaze {

	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
		int n = maze.length;
		int m = maze[0].length;
		
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start[0], start[1] });
		visited[start[0]][start[1]] = true;

		int[] r = new int[] { 0, 0, -1, 1 };
		int[] c = new int[] { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			int[] polled = q.poll();

			if (polled[0] == destination[0] && polled[1] == destination[1]) {
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int x = polled[0] + r[i];
				int y = polled[1] + c[i];

				while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {

					x += r[i];
					y += c[i];
				}

				x -= r[i];
				y -= c[i];

				if (!visited[x][y]) {
					q.add(new int[] { x, y });
					visited[x][y] = true;
				}
			}
		}

		return false;

	}
	
	public static void main(String[] args) {
		
		TheMaze theMaze = new TheMaze();
		
		// theMaze.hasPath(new int[] {}, start, destination)
		
	}

}
