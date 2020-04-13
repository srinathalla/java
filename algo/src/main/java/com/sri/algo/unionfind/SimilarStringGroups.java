package com.sri.algo.unionfind;

public class SimilarStringGroups {

	static class UnionFind {
		int[] p, rank;
		int num;

		public UnionFind(int num) {
			p = new int[num];
			for (int i = 0; i < num; i++) {
				p[i] = i;
			}

			rank = new int[num];
			this.num = num;
		}

		public int find(int index) {

			if (p[index] == index) {
				return index;
			}
			int res = find(p[index]);
			p[index] = res;
			return res;
		}

		public void union(int i, int j) {
			int pi = find(i);
			int pj = find(j);
			if (pi == pj) {
				return;
			}

			if (rank[i] > rank[j]) {
				p[pj] = pi;
			} else {
				p[pi] = pj;
				if (rank[pi] == rank[pj]) {
					rank[pj]++;
				}
			}
			num--;
		}

		public int size() {
			return num;
		}
	}

	public int numSimilarGroups(String[] A) {

		UnionFind uf = new UnionFind(A.length);

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {

				if (isSimilar(A[i], A[j])) {
					uf.union(i, j);
				}
			}
		}
		return uf.size();

	}

	public boolean isSimilar(String a, String b) {

		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i) && ++res > 2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String[] arr = new String[] { "tars", "rats", "arts", "star" };
		SimilarStringGroups sg = new SimilarStringGroups();
		System.out.println(sg.numSimilarGroups(arr));

	}

}
