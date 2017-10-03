package com.sri.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of integers that might contain duplicates, return all possible subsets.

Note Output:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        The subsets must be sorted lexicographically.

	Example :
	If S = [1,2,2], the solution is:

	[
	[],
	[1],
	[1,2],
	[1,2,2],
	[2],
	[2, 2]
	]
 *
 *Input:
	2
	3
	1 2 2
	4
	1 2 3 3

	Output:
	()(1)(1 2)(1 2 2)(2)(2 2)
	()(1)(1 2)(1 2 3)(1 2 3 3)(1 3)(1 3 3)(2)(2 3)(2 3 3)(3)(3 3)
 *
 */
public class AllSubSets {

	public static List<List<Integer>> generateSubSets(int[] arr) {
		List<List<Integer>> all = new ArrayList<>();

		List<Integer> emptySet = new ArrayList<>();
		all.add(emptySet);

		Arrays.sort(arr);

		for (int no : arr) {
			List<List<Integer>> clonedSets = new ArrayList<>();

			// Clone all existing sets and add the current number.
			for (List<Integer> origSet : all) {
				List<Integer> clonedSet = new ArrayList<>();
				clonedSet.addAll(origSet);
				clonedSet.add(no);

				clonedSets.add(clonedSet);
			}

			// Copy all clonedSets and add them back to all sets.
			for (List<Integer> clonedSet : clonedSets) {
				if (!all.contains(clonedSet)) {
					all.add(clonedSet);
				}
			}
		}

		Collections.sort(all, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {

				if (o1.isEmpty()) {
					return -1;
				}
				if (o2.isEmpty()) {
					return 1;
				}

				int i = 0, j = 0;

				while (i < o1.size() && j < o2.size()) {

					while (i < o1.size() && j < o2.size() && o1.get(i) == o2.get(j)) {
						i++;
						j++;
					}
					return (i < o1.size() ? o1.get(i) : -1)
							- (j < o2.size() ? o2.get(j) : -1);
				}

				return 0;
			}

		});
		return all;
	}

	public static void main(String[] args) {

		List<List<Integer>>  all = generateSubSets(new int[] { 1, 2, 2 });
		
		String fullStr = "";
		for (List<Integer> set : all)
		{
			String s = "(";
			
			for (int i = 0 ;i < set.size() ; i++)
			{
				s = s + set.get(i);
				
				if (i +1 != set.size())
				{
					s = s + " ";
				}
			}
			
			 s = s + ")";
			 fullStr = fullStr + s;
		}
		
		System.out.println(fullStr);	
		
	}

}
