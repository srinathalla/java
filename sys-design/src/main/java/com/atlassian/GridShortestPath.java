package com.atlassian;

import java.util.LinkedList;
import java.util.Queue;

public class GridShortestPath {
    public static int shortestPath(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] ==1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        boolean[][] visited = new boolean[n][m];
        while(!q.isEmpty())
        {
            int[] polled = q.poll();
            int r = polled[0];
            int c = polled[1];
            int dist = polled[2];
            if(r== n-1 && c == m-1)
            {
                return dist;
            }
            int[] rows = new int[]{0,0,-1,1};
            int[] cols = new int[]{-1,1,0,0};

            for(int i=0; i < 4;i++)
            {
                int adjR = r + rows[i];
                int adjC = c + cols[i];
                if(adjC >= 0 && adjC < m && adjR >=0 && adjR < n && grid[adjR][adjC] == 0 && !visited[adjR][adjC])
                {
                    visited[adjR][adjC] = true;
                    q.add(new int[]{adjR, adjC, dist + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1},
                {1, 0, 1},
                {1, 0, 0}
        };

        System.out.println(shortestPath(grid));
    }
}
