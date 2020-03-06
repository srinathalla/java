package com.sri.algo.array.leet.medium;

import java.util.HashSet;
import java.util.Set;

public class BitWiseOrs {

	public int subarrayBitwiseORs(int[] A) {

		Set<Integer> res = new HashSet<>(), curr = new HashSet<>(), curr1;
		for (int no : A) {
			curr1 = new HashSet<>();
			curr1.add(no);

			for (int j : curr) {
				curr1.add(j | no);
			}
			curr = curr1;
			res.addAll(curr);

		}
		return res.size();
	}

}
