package com.sri.algo.array.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Given a blacklist B containing unique integers from [0, N), write a function
 * to return a uniform random integer from [0, N) which is NOT in B.
 * 
 * Optimize it such that it minimizes the call to system’s Math.random().
 * 
 * Note:
 * 
 * 1 <= N <= 1000000000 0 <= B.length < min(100000, N) [0, N) does NOT include
 * N. See interval notation.
 * 
 * @author salla
 *
 */
public class RandomPickWithBlackList {

	List<Integer> w;
	Random r;

	public RandomPickWithBlackList(int N, int[] blacklist) {

		Set<Integer> wl = new HashSet<>();
		for (int i = 0; i < N; i++) {
			wl.add(i);
		}

		for (int no : blacklist) {
			wl.remove(no);
		}

		r = new Random();
		w = new ArrayList<>(wl);
	}

	public int pick() {
		return w.get(r.nextInt(w.size()));
	}

	public static void main(String[] args) {

		/*
		 * RandomPickWithBlackList randomPickWithBlackList = new
		 * RandomPickWithBlackList(1,new int[] {});
		 * System.out.println(randomPickWithBlackList.pick());
		 * System.out.println(randomPickWithBlackList.pick());
		 * System.out.println(randomPickWithBlackList.pick());
		 * 
		 * RandomPickWithBlackList randomPickWithBlackList1 = new
		 * RandomPickWithBlackList(2,new int[] {});
		 * System.out.println(randomPickWithBlackList1.pick());
		 * System.out.println(randomPickWithBlackList1.pick());
		 * System.out.println(randomPickWithBlackList1.pick());
		 */

		RandomPickWithBlackList randomPickWithBlackList2 = new RandomPickWithBlackList(4, new int[] { 0, 1 });
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());
		System.out.println(randomPickWithBlackList2.pick());

	}

}
