package com.sri.algo.array.leet.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 	In a row of trees, the i-th tree produces fruit with type tree[i].

	You start at any tree of your choice, then repeatedly perform the following steps:
	
	Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
	Move to the next tree to the right of the current tree.  If there is no tree to the 
	right, stop.
	Note that you do not have any choice after the initial choice of starting tree: you
	ust perform step 1, 
	then step 2, then back to step 1, then step 2, and so on until you stop.
	
	You have two baskets, and each basket can carry any quantity of fruit, but you want 
	each basket to only carry one type of fruit each.
	
	What is the total amount of fruit you can collect with this procedure?
 * @author salla
 *
 */
public class FruitsIntoBaskets {

	public int totalFruit1(int[] tree) {

		int max = 0;

		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		for (int j = 0; j < tree.length; j++) {

			map.put(tree[j], map.getOrDefault(tree[j], 0) + 1);

			while (map.size() >= 3) {
				map.put(tree[i], map.get(tree[i]) - 1);

				if (map.get(tree[i]) == 0) {
					map.remove(tree[i]);
				}
				i++;
			}

			max = Math.max(max, j - i + 1);
		}

		return max;
	}
	
	/**
	 * T.C : O(n)
	 * 
	 * 
	 *  Explanation:
		Loop all fruit c in tree,
		Note that a and b are the last two different types of fruit that we met,
		c is the current fruit type,
		so it's something like "....aaabbbc..."
		
		Case 1 c == b:
		fruit c already in the basket,
		and it's same as the last type of fruit
		cur += 1
		count_b += 1
		
		Case 2 c == a:
		fruit c already in the basket,
		but it's not same as the last type of fruit
		cur += 1
		count_b = 1
		a = b, b = c
		
		Case 3 c != b && c!= a:
		fruit c not in the basket,
		cur = count_b + 1
		count_b = 1
		a = b, b = c
		
	 * @param tree
	 * @return
	 */
	public int totalFruit(int[] tree) {

		int res = 0, curr = 0, a = 0, b = 0, count_b = 0;

		for (int c : tree) {
			curr = a == c || b == c ? curr + 1 : count_b + 1;
			count_b = b == c ? count_b + 1 : 1;

			if (b != c) {
				a = b;
				b = c;
			}

			res = Math.max(res, curr);
		}

		return res;
    }
	
	public static void main(String[] args) {
		
		FruitsIntoBaskets fruitsIntoBaskets = new FruitsIntoBaskets();
		
		System.out.println(
			fruitsIntoBaskets.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
		
	}

}
