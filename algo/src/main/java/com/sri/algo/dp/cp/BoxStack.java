package com.sri.algo.dp.cp;

import java.util.Arrays;
import java.util.Comparator;

public class BoxStack {

	private static class Box {
		int h;
		int w;
		int l;

		public Box() {
		}

		public Box(int h, int w, int l) {
			super();
			this.h = h;
			this.w = w;
			this.l = l;
		}
		
	}

	public static int computeMaxheigth(Box[] boxes, int n) {
		Box[] rotated = new Box[3 * n];

		int i = -1;
		for (Box box : boxes) {
			rotated[++i] = box;

			Box b1 = new Box();
			b1.h = box.l;
			b1.l = Integer.max(box.w, box.h);
			b1.w = Integer.min(box.w, box.h);

			rotated[++i] = b1;

			Box b2 = new Box();
			b2.h = box.w;
			b1.l = Integer.max(box.l, box.h);
			b1.w = Integer.min(box.l, box.h);

			rotated[++i] = b2;
		}

		// Sort boxes in decreasing order of base area.
		Arrays.sort(rotated, new Comparator<Box>() {

			@Override
			public int compare(Box o1, Box o2) {

				return o2.l * o2.w - o1.l * o1.w;
			}

		});

		int[] heights = new int[rotated.length];
		i = -1;
		for (Box box : rotated) {
			heights[++i] = box.h;
		}

		int max = heights[3 * n - 1];

		for (i = 3 * n - 2; i >= 0; i--) {
			for (int j = 3 * n - 1; j < i; j--) {
				if (rotated[i].w > rotated[j].w && rotated[i].l > rotated[j].l) {
					heights[i] = Integer.max(heights[i], heights[j] + rotated[i].h);
					max = Integer.max(max, heights[i]);
				}
			}
		}

		return max;
	}
	
	public static void main(String[] args) {
		
	}

}
