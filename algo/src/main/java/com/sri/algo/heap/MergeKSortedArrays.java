package com.sri.algo.heap;

public class MergeKSortedArrays {

	public static int[] merge(int[][] table, int k) {

		int[] merged = new int[k * k];

		BinaryMinHeap heap = new BinaryMinHeap();
		for (int i = 0; i < k; i++) {
			HeapNode node = new HeapNode(table[i][0]);
			node.i = i;
			node.j = 0;

			heap.insert(node);
		}

		int idx = 0;
		while (!heap.isEmpty()) {

			HeapNode node = heap.extractMin();
			merged[idx] = node.val;
			idx++;

			if (node.j + 1 < k) {

				HeapNode nextNode = new HeapNode(table[node.i][node.j + 1]);
				nextNode.i = node.i;
				nextNode.j = node.j + 1;

				heap.insert(nextNode);
			}
		}

		return merged;

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[] sorted = merge(arr, 3);

		for (int no : sorted) {
			System.out.print(no + " ");
		}

	}

}
