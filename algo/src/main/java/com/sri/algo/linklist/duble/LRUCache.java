package com.sri.algo.linklist.duble;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUCache {

	private Map<Integer, DLLNode<Integer>> mapToNodeLookUp = new HashMap<>();
	private DLL<Integer> dll = null;
	private int cacheSize = 0;
	private int size = 0;

	/* Inititalize an LRU cache with size N */
	public LRUCache(int N) {
		this.cacheSize = N;
		this.dll = new DLL<>();
	}

	/*
	 * Returns the value of the key x if present else returns -1
	 */
	public int get(int x) {

		if (mapToNodeLookUp.containsKey(x)) {
			DLLNode<Integer> valNode = mapToNodeLookUp.get(x);
			if (valNode != dll.head) {
				dll.remove(valNode);
				dll.addFirst(valNode);
			}
			return valNode.pageData;
		} else {
			return -1;
		}

	}

	/* Sets the key x with value y in the LRU cache */
	public void set(int x, int y) {

		if (!mapToNodeLookUp.containsKey(x)) {

			if (size == cacheSize) {
				DLLNode<Integer> removedNode = dll.removeLast();
				mapToNodeLookUp.remove(removedNode.pageId);
				size--;
			}

			 dll.addFirst(y, x);
			
			size++;
			mapToNodeLookUp.put(x, dll.head);
		} else {
			mapToNodeLookUp.get(x).pageData = y;

			dll.remove(mapToNodeLookUp.get(x));
			dll.addFirst(mapToNodeLookUp.get(x));
		}
	}

	public static void main(String[] args) {

		/*
		 * LRUCache cache = new LRUCache(2);
		 * 
		 * cache.set(1, 2); cache.set(2, 3); cache.set(1, 5); cache.set(4, 5);
		 * cache.set(6, 7);
		 * 
		 * System.out.print(cache.get(4) + " "); System.out.print(cache.get(1));
		 */
		try (Scanner in = new Scanner(System.in)) {
			int testCount = in.nextInt();

			for (int i = 0; i < testCount; i++) {
				int n = in.nextInt();
				LRUCache cache = new LRUCache(n);

				int op = in.nextInt();

				String input = in.nextLine();

				while (input.isEmpty()) {
					input = in.nextLine();
				}
				input.trim();

				String[] inputArr = input.split(" ");

				int idx = 0;
				for (int j = 0; j < op; j++) {

					if (inputArr[idx].equals("SET")) {

						cache.set(Integer.valueOf(inputArr[idx + 1]), Integer.valueOf(inputArr[idx + 2]));

						idx = idx + 3;
					} else if (inputArr[idx].equals("GET")) {
						System.out.print(cache.get(Integer.valueOf(inputArr[idx + 1])) + " ");
						idx = idx + 2;
					}
				}
				
				System.out.println();

			}
		}

	}

}
