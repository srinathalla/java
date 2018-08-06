package com.sri.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up (u), down (d), left (l) or right (r), but
 * it won't stop rolling until hitting a wall. When the ball stops, it could
 * choose the next direction. There is also a hole in this maze. The ball will
 * drop into the hole if it rolls on to the hole.
 * 
 * Given the ball position, the hole position and the maze, find out how the
 * ball could drop into the hole by moving the shortest distance. The distance
 * is defined by the number of empty spaces traveled by the ball from the start
 * position (excluded) to the hole (included). Output the moving directions by
 * using 'u', 'd', 'l' and 'r'. Since there could be several different shortest
 * ways, you should output the lexicographically smallest way. If the ball
 * cannot reach the hole, output "impossible".
 * 
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means
 * the empty space. You may assume that the borders of the maze are all walls.
 * The ball and the hole coordinates are represented by row and column indexes.
 * 
 * nput 1: a maze represented by a 2D array
 * 
 * 0 0 0 0 0 1 1 0 0 1 0 0 0 0 0 0 1 0 0 1 0 1 0 0 0
 * 
 * Input 2: ball coordinate (rowBall, colBall) = (4, 3) Input 3: hole coordinate
 * (rowHole, colHole) = (0, 1)
 * 
 * Output: "lul" Explanation: There are two shortest ways for the ball to drop
 * into the hole. The first way is left -> up -> left, represented by "lul". The
 * second way is up -> left, represented by 'ul'. Both ways have shortest
 * distance 6, but the first way is lexicographically smaller because 'l' < 'u'.
 * So the output is "lul".
 * 
 * 
 * @author salla
 *
 */
public class Maze3 {

	private static class Position {
		int row;
		int col;
		int hops;

		public Position(int cr, int cc, int hops) {
			super();
			this.row = cr;
			this.col = cc;
			this.hops = hops;
		}

		StringBuilder path = new StringBuilder();

	}

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {

		int rows = maze.length;
		int cols = maze[0].length;

		boolean[][] visited = new boolean[rows][cols];
		Queue<Position> q = new LinkedList<>();

		Position start = new Position(ball[0], ball[1], 0);
		q.add(start);
		visited[start.row][start.col] = true;

		while (!q.isEmpty()) {
			Position curr = q.poll();

			if (curr.row == hole[0] && curr.col == hole[1]) {
				return curr.path.toString();
			}

			if (curr.row + 1 < rows && maze[curr.row + 1][curr.col] != 1 && !visited[curr.row + 1][curr.col]) {
				Position down = new Position(curr.row + 1, curr.col, curr.hops + 1);
				down.path.append(curr.path.toString());

				if (down.path.length() == 0 || down.path.charAt(down.path.length() - 1) != 'd') {
					down.path.append('d');
				}

				q.add(down);
				visited[curr.row + 1][curr.col] = true;
			}

			if (curr.col > 0 && maze[curr.row][curr.col - 1] != 1 && !visited[curr.row][curr.col - 1]) {
				Position left = new Position(curr.row, curr.col - 1, curr.hops + 1);
				left.path.append(curr.path.toString());

				if (left.path.length() == 0 || left.path.charAt(left.path.length() - 1) != 'l') {
					left.path.append('l');
				}

				q.add(left);
				visited[curr.row][curr.col - 1] = true;
			}

			if (curr.col + 1 < cols && maze[curr.row][curr.col + 1] != 1 && !visited[curr.row][curr.col + 1]) {
				Position right = new Position(curr.row, curr.col + 1, curr.hops + 1);
				right.path.append(curr.path.toString());

				if (right.path.length() == 0 || right.path.charAt(right.path.length() - 1) != 'r') {
					right.path.append('r');
				}

				q.add(right);
				visited[curr.row][curr.col + 1] = true;

			}
			if (curr.row > 0 && maze[curr.row - 1][curr.col] != 1 && !visited[curr.row - 1][curr.col]) {
				Position up = new Position(curr.row - 1, curr.col, curr.hops + 1);
				up.path.append(curr.path.toString());

				if (up.path.length() == 0 || up.path.charAt(up.path.length() - 1) != 'u') {
					up.path.append('u');
				}

				q.add(up);
				visited[curr.row - 1][curr.col] = true;
			}
		}

		return "impossible";
	}

	public static void main(String[] args) {

		/*
		 * int[][] matrix = new int[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0,
		 * 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		 * 
		 * Maze3 maze = new Maze3();
		 * 
		 * System.out.println(maze.findShortestWay(matrix, new int[] { 4, 3 }, new int[]
		 * { 0, 1 }));
		 */

		int[][] matrix = new int[][] {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};

		Maze3 maze = new Maze3();

		System.out.println(maze.findShortestWay(matrix, new int[] { 4, 3 }, new int[] { 3, 0 }));

	}

}
