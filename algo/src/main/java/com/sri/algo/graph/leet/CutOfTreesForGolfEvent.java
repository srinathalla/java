package com.sri.algo.graph.leet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * you are asked to cut off trees in a forest for a golf event. The forest is
 * represented as a non-negative 2D map, in this map:
 * 
 * 0 represents the obstacle can't be reached. 1 represents the ground can be
 * walked through. The place with number bigger than 1 represents a tree can be
 * walked through, and this positive number represents the tree's height. You
 * are asked to cut off all the trees in this forest in the order of tree's
 * height - always cut off the tree with lowest height first. And after cutting,
 * the original place has the tree will become a grass (value 1).
 * 
 * You will start from the point (0, 0) and you should output the minimum steps
 * you need to walk to cut off all the trees. If you can't cut off all the
 * trees, output -1 in that situation.
 * 
 * You are guaranteed that no two trees have the same height and there is at
 * least one tree needs to be cut off.
 * 
 * Example 1: Input: [ [1,2,3], [0,0,4], [7,6,5] ] Output: 6
 * 
 * Example 2: Input: [ [1,2,3], [0,0,0], [7,6,5] ] Output: -1
 * 
 * Example 3: Input: [ [2,3,4], [0,0,5], [8,7,6] ] Output: 6
 * 
 * Explanation: You started from the point (0,0) and you can cut off the tree in
 * (0,0) directly without walking. Hint: size of the given matrix will not
 * exceed 50x50.
 * 
 * @author salla
 *
 */
public class CutOfTreesForGolfEvent {

	private int[] dr = { 0, 0, -1, 1 };

	private int[] dc = { 1, -1, 0, 0 };

	/**
	 * T.C O(R*C) to collect all tress + O(R*C) tress and for each tree search
	 * O(R*C) => O((R*C)^2)
	 * 
	 * 
	 * 
	 * @param forest
	 * @return
	 */
	public int cutOffTree(List<List<Integer>> forest) {

		List<int[]> trees = new ArrayList<>();
		int R = forest.size();
		int C = forest.get(0).size();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int v = forest.get(i).get(j);
				if (v > 1) {
					trees.add(new int[] { v, i, j });
				}
			}
		}

		Collections.sort(trees, (int[] a, int[] b) -> a[0] - b[0]);

		int sr = 0, sc = 0, ans = 0;
		for (int[] tree : trees) {
			int dist = shortestDistance(forest, sr, sc, tree[1], tree[2]);

			if (dist < 0) {
				return -1;
			}

			ans += dist;
			sr = tree[1];
			sc = tree[2];
		}

		return ans;

	}

	private int shortestDistance(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {

		Queue<int[]> q = new LinkedList<>();

		int R = forest.size();
		int C = forest.get(0).size();
		boolean[][] seen = new boolean[R][C];
		seen[sr][sc] = true;
		q.add(new int[] { 0, sr, sc });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[1] == tr && curr[2] == tc) {
				return curr[0];
			}

			for (int i = 0; i < 4; i++) {
				int adjR = curr[1] + dr[i];
				int adjC = curr[2] + dc[i];

				if (0 <= adjR && adjR < R && 0 <= adjC && adjC < C && !seen[adjR][adjC]
						&& forest.get(adjR).get(adjC) > 0) {
					q.add(new int[] { curr[0] + 1, adjR, adjC });
					seen[adjR][adjC] = true;
				}
			}
		}

		return -1;
	}
	
	public int cutOffTreeWithAStarSearch(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
	    int R = forest.size(), C = forest.get(0).size();
	    PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
	        (a, b) -> Integer.compare(a[0], b[0]));
	    heap.offer(new int[]{0, 0, sr, sc});

	    HashMap<Integer, Integer> cost = new HashMap<>();
	    cost.put(sr * C + sc, 0);

	    while (!heap.isEmpty()) {
	        int[] cur = heap.poll();
	        int g = cur[1], r = cur[2], c = cur[3];
	        if (r == tr && c == tc) return g;
	        for (int di = 0; di < 4; ++di) {
	            int nr = r + dr[di], nc = c + dc[di];
	            if (0 <= nr && nr < R && 0 <= nc && nc < C && forest.get(nr).get(nc) > 0) {
	                int ncost = g + 1 + Math.abs(nr-tr) + Math.abs(nc-tr);
	                if (ncost < cost.getOrDefault(nr * C + nc, 9999)) {
	                    cost.put(nr * C + nc, ncost);
	                    heap.offer(new int[]{ncost, g+1, nr, nc});
	                }
	            }
	        }
	    }
	    return -1;
	}
	
	public int hadlocks(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
	    int R = forest.size(), C = forest.get(0).size();
	    Set<Integer> processed = new HashSet<>();
	    Deque<int[]> deque = new ArrayDeque<>();
	    deque.offerFirst(new int[]{0, sr, sc});
	    while (!deque.isEmpty()) {
	        int[] cur = deque.pollFirst();
	        int detours = cur[0], r = cur[1], c = cur[2];
	        if (!processed.contains(r*C + c)) {
	            processed.add(r*C + c);
	            if (r == tr && c == tc) {
	                return Math.abs(sr-tr) + Math.abs(sc-tc) + 2 * detours;
	            }
	            for (int di = 0; di < 4; ++di) {
	                int nr = r + dr[di];
	                int nc = c + dc[di];
	                boolean closer;
	                if (di <= 1) closer = di == 0 ? r > tr : r < tr;
	                else closer = di == 2 ? c > tc : c < tc;
	                if (0 <= nr && nr < R && 0 <= nc && nc < C && forest.get(nr).get(nc) > 0) {
	                    if (closer) deque.offerFirst(new int[]{detours, nr, nc});
	                    else deque.offerLast(new int[]{detours+1, nr, nc});
	                }
	            }
	        }
	    }
	    return -1;
	}

	public static void main(String[] args) {

		Integer[][] forest = new Integer[][] { { 1, 2, 3 }, { 0, 0, 4 }, { 7, 6, 5 } };

		List<List<Integer>> forestList = new ArrayList<>();

		for (Integer[] arr : forest) {
			forestList.add(Arrays.asList(arr));
		}

		CutOfTreesForGolfEvent cut = new CutOfTreesForGolfEvent();
		System.out.println(cut.cutOffTree(forestList));

	}

}
