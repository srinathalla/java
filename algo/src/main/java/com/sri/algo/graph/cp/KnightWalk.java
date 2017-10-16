package com.sri.algo.graph.cp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Given a chess board of order NxM and source points (s1,s2) and destination points (d1,d2), 
 * Your task to find min number of moves required by the Knight to go to the destination cell. 

	Input:
	2
	4 7
	2 6 2 4
	7 13
	2 8 3 4
	
	Output:
	2
	3
 *
 */
public class KnightWalk {

	private static class Pair
	{
		int r;
		int c;
		
		public Pair(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		int dist = 0;
		
	}
	
	private static boolean isValid(int i,int j,int N,int M)
	{
		return i >= 0 && i < N && j >=0 && j < M; 
	}
	
	/**
	 * Idea is to use BFS and visit all adjacent cells.
	 * 
	 * @param n
	 * @param m
	 * @param s1
	 * @param s2
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int minMoves( int n,int m,int s1,int s2,int d1,int d2)
	{
		boolean[][] visited = new boolean[n][m];
		
		s1--;
		s2--;
		d1--;
		d2--;
		
		if(!isValid(s1, s2,n,m) || !isValid(d1, d2,n,m))
		{
		    return -1;
		}
		
		
		Pair src = new Pair(s1,s2,0);	
		Pair dest = new Pair(d1,d2,Integer.MAX_VALUE);
		
		Queue<Pair> queue = new LinkedList<>();
		
		queue.add(src);
		
		int[] row = new int[] {-1,-1,-2,-2,1,1,2,2};
		int[] col = new int[]{-2, 2,-1, 1,-2,2,-1,1};
		
		while(!queue.isEmpty())
		{			
			Pair curr = queue.poll();
			visited[curr.r][curr.c] = true;
			
			if (dest.r == curr.r && dest.c == curr.c)
			{
				return curr.dist;
			}		
		   
			for (int i =0 ; i < 8 ; i++)
			{
				int adjR = curr.r + row[i];
				int adjC = curr.c + col[i];
				if(isValid(adjR, adjC,n,m) && !visited[adjR][adjC])
				{
					queue.add(new Pair(adjR,adjC,curr.dist +1));
				}
			}	
		}
		
		return -1;
	}
	
	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				int m = in.nextInt();

				System.out.print(minMoves(n, m, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
				System.out.println();

			}
		}
	}

}
