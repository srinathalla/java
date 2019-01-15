package com.sri.algo.graph.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberofDistinctIslands2 {
	
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> land2id = new HashMap<Integer, Integer>();
		int num_islands = 0;
		int island_id = 0;

		for (int[] pos : positions) {
			int r = pos[0], c = pos[1];
			Set<Integer> overlap = new HashSet<Integer>();

			if (r - 1 >= 0 && land2id.containsKey((r - 1) * n + c)) {
				overlap.add(land2id.get((r - 1) * n + c));
			}
			if (r + 1 < m && land2id.containsKey((r + 1) * n + c)) {
				overlap.add(land2id.get((r + 1) * n + c));
			}
			if (c - 1 >= 0 && land2id.containsKey(r * n + c - 1)) {
				overlap.add(land2id.get(r * n + c - 1));
			}
			if (c + 1 < n && land2id.containsKey(r * n + c + 1)) {
				overlap.add(land2id.get(r * n + c + 1));
			}

			if (overlap.isEmpty()) {
				++num_islands;
				land2id.put(r * n + c, island_id++);
			} else if (overlap.size() == 1) {
				land2id.put(r * n + c, overlap.iterator().next());
			} else {
				int root_id = overlap.iterator().next();
				for (Map.Entry<Integer, Integer> entry : land2id.entrySet()) {
					int k = entry.getKey();
					int id = entry.getValue();
					if (overlap.contains(id)) {
						land2id.put(k, root_id);
					}
				}
				land2id.put(r * n + c, root_id);
				num_islands -= (overlap.size() - 1);
			}
			ans.add(num_islands);
		}

		return ans;
	  }
	
	public static void main(String[] args) {
		
		
		NumberofDistinctIslands2 numberofDistinctIslands2 = new NumberofDistinctIslands2();
		
		// numberofDistinctIslands2.numIslands2(3, 3, new int[] {{}})
	}

}
