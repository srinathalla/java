package com.sri.algo.unionfind;

import java.util.Arrays;

public class GraphTraverasble {

	public int maxNumEdgesToRemove(int n, int[][] edges) {

		Arrays.sort(edges, (a, b) -> b[0] - a[0]);

		int edgeAdd = 0;

		UF alice = new UF(n);
		UF bob = new UF(n);

		for (int[] edge : edges) {
			int type = edge[0];
			int a = edge[1];
			int b = edge[2];

			switch (type) {

			case 3:
				if (bob.union(a, b) | alice.union(a, b)) {
					edgeAdd++;
				}
				break;
			case 2:
				if (bob.union(a, b)) {
					edgeAdd++;
				}
				break;
			case 1:
				if (alice.union(a, b)) {
					edgeAdd++;
				}
				break;
			}
		}

		return (alice.unionComplete() && bob.unionComplete()) ? edges.length - edgeAdd : -1;

	}

	private static class UF {
		int[] component;
		int distinctComponents;

		public UF(int n) {
			component = new int[n + 1];

			for (int i = 0; i <= n; i++) {
				component[i] = i;
			}
			distinctComponents = n;
		}

		private boolean union(int a, int b) {
			int ca = find(a);
			int cb = find(b);
			if (ca != cb) {
				component[ca] = b;
				distinctComponents--;
				return true;
			}

			return false;
		}

		private int find(int a) {
			if (component[a] != a) {
				component[a] = find(component[a]);
			}

			return component[a];
		}

		private boolean unionComplete() {
			return distinctComponents == 1;
		}

	}
	
	public static void main(String[] args) {
		 int n = 4;
		 int[][] edges = new int[][] {{3,1,2},{3,2,3},{1,1,3},{1,2,4},
			 {1,1,2},{2,3,4}};
			 
			 GraphTraverasble gt = new GraphTraverasble();
			 System.out.println(
				 gt.maxNumEdgesToRemove(n, edges));
		 }
	

}
