package com.sri.algo.dp.leet.medium;

public class FurthestBuildingYouCanReach {

	int ans = 0;

	public int furthestBuilding(int[] heights, int bricks, int ladders) {

		r(heights, 0, bricks, ladders);

		return ans;
	}

	private boolean r(int[] heights, int i, int bricks, int ladders) {

		this.ans = Math.max(this.ans, i);
		if (i == heights.length - 1) {
			return true;
		}

		

		if (heights[i] >= heights[i + 1]) {
			return r(heights, i + 1, bricks, ladders);
		} else {

			if (bricks >= heights[i + 1] - heights[i]) {
				if(r(heights, i + 1, bricks - (heights[i + 1] - heights[i]), ladders))
					return true;
			}
			if (ladders > 0) {
				return r(heights, i + 1, bricks, ladders - 1);
			}
		}
		
		return false;

	}

	public static void main(String[] args) {

		FurthestBuildingYouCanReach fbucr = new FurthestBuildingYouCanReach();

		int[] h = new int[] { 1, 5, 1, 2, 3, 4, 10000 };
		System.out.println(fbucr.furthestBuilding(h, 4, 1));

	}

}
