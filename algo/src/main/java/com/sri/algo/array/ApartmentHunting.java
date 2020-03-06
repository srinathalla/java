package com.sri.algo.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author srialla
 *
 */
public class ApartmentHunting {

	/**
	 * T.C : O (B^2*R)
	 * 
	 * Can we do it in O(B*R) ?
	 * 
	 * @param blocks
	 * @param reqs
	 * @return
	 */
	public static int apartmentHuntingNaive(ArrayList<HashMap<String, Boolean>> blocks, String[] reqs) {

		int idx = -1;

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < blocks.size(); i++) {
			int max = Integer.MIN_VALUE;
			for (String req : reqs) {

				int minBlock = Integer.MAX_VALUE;
				for (int j = i; j < blocks.size(); j++) {
					if (blocks.get(j).get(req)) {
						minBlock = Math.min(minBlock, Math.abs(j - i));
						break;
					}
				}
				for (int j = i - 1; j >= 0; j--) {

					// Do not traverse left more distance than the nearest block available to the
					// right.
					if (blocks.get(j).get(req) || Math.abs(j - i) >= minBlock) {
						minBlock = Math.min(minBlock, Math.abs(j - i));
						break;
					}
				}

				max = Math.max(max, minBlock);
			}

			if (min > max) {
				min = max;
				idx = i;
			}
		}

		return idx;
	}

	
	/**
	 * T.C O(b*r) + O(b*r) => O(br)
	 * @param blocks
	 * @param reqs
	 * @return
	 */
	public static int apartmentHunting(ArrayList<HashMap<String, Boolean>> blocks, String[] reqs) {

		int[][] closestDistances = new int[reqs.length][blocks.size()];
        
		
		// T.C O(b*r)
 		for (int i = 0; i < reqs.length; i++) {

			int closestIdx = Integer.MAX_VALUE;
			for (int j = 0; j < blocks.size(); j++) {
				if (blocks.get(j).get(reqs[i])) {
					closestIdx = j;
				}
				closestDistances[i][j] = Math.abs(j - closestIdx);
			}

			for (int j = blocks.size() - 1; j >= 0; j--) {
				if (blocks.get(j).get(reqs[i])) {
					closestIdx = j;
				}
				closestDistances[i][j] = Math.min(closestDistances[i][j], Math.abs(j - closestIdx));
			}
		}
		
		int minIdx = -1;
		int minVal = Integer.MAX_VALUE;
		
		// T.C : O(b*r)
		for(int i=0; i< blocks.size();i++)
		{
			int maxDistance = Integer.MIN_VALUE;
			for(int j=0; j< reqs.length;j++)
			{
				maxDistance = Math.max(maxDistance, closestDistances[j][i]);
			}		
			if(maxDistance < minVal)
			{
				minVal =  maxDistance;
				minIdx = i;
			}
		}		
		return minIdx;

	}

	public static void main(String[] args) {

		ArrayList<HashMap<String, Boolean>> list = new ArrayList<>();
		String[] reqs = new String[] { "gym", "school", "store" };

		HashMap<String, Boolean> b1 = new HashMap<>();
		b1.put("gym", false);
		b1.put("school", true);
		b1.put("store", false);

		HashMap<String, Boolean> b2 = new HashMap<>();
		b2.put("gym", true);
		b2.put("school", false);
		b2.put("store", false);

		HashMap<String, Boolean> b3 = new HashMap<>();
		b3.put("gym", true);
		b3.put("school", true);
		b3.put("store", false);

		HashMap<String, Boolean> b4 = new HashMap<>();
		b4.put("gym", false);
		b4.put("school", true);
		b4.put("store", false);

		HashMap<String, Boolean> b5 = new HashMap<>();
		b5.put("gym", false);
		b5.put("school", true);
		b5.put("store", true);

		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);

		System.out.println(apartmentHunting(list, reqs));

	}

}
