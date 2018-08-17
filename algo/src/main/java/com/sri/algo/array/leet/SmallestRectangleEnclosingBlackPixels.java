package com.sri.algo.array.leet;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a
 * black pixel. The black pixels are connected, i.e., there is only one black
 * region. Pixels are connected horizontally and vertically. Given the location
 * (x, y) of one of the black pixels, return the area of the smallest
 * (axis-aligned) rectangle that encloses all black pixels.
 * 
 * Example:
 * 
 * Input: [ "0010", "0110", "0100" ] and x = 0, y = 2
 * 
 * Output: 6
 * 
 * @author salla
 *
 */
public class SmallestRectangleEnclosingBlackPixels {

	int lx = Integer.MAX_VALUE, hx = Integer.MIN_VALUE, ly = Integer.MAX_VALUE, hy = Integer.MIN_VALUE;

	/**
	 * T.C O(n*m) where S.C O(n*m)
	 * 
	 * Idea is to use dfs from the given point and keep track of min and max values
	 * of x and y. we can compute area as (hx - lx + 1) * (hy - ly + 1)
	 * 
	 * 
	 * we can still do better by using binary search TC can be brought down to
	 * O(nlogm) + O(mlogn) ..
	 * 
	 * n is no of rows m is no of columns.
	 * 
	 * @param image
	 * @param x
	 * @param y
	 * @return
	 */
	public int minAreaWithdfs(char[][] image, int x, int y) {

		lx = x;
		hx = x;
		ly = y;
		hy = y;

		dfs(image, x, y);

		return (hx - lx + 1) * (hy - ly + 1);

	}

	private void dfs(char[][] image, int x, int y) {

		image[x][y] = 0;

		lx = Integer.min(lx, x);
		hx = Integer.max(hx, x);
		ly = Integer.min(ly, y);
		hy = Integer.max(hy, y);

		if (x < image.length - 1 && image[x + 1][y] == '1') {
			dfs(image, x + 1, y);
		}
		if (x > 0 && image[x - 1][y] == '1') {
			dfs(image, x - 1, y);
		}
		if (y < image[0].length - 1 && image[x][y + 1] == '1') {
			dfs(image, x, y + 1);
		}
		if (y > 0 && image[x][y - 1] == '1') {
			dfs(image, x, y - 1);
		}
	}

	public int minArea(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		int left = searchColumns(image, 0, y, 0, m, true);
		int right = searchColumns(image, y + 1, n, 0, m, false);
		int top = searchRows(image, 0, x, left, right, true);
		int bottom = searchRows(image, x + 1, m, left, right, false);
		return (right - left) * (bottom - top);
	}

	private int searchColumns(char[][] image, int i, int j, int top, int bottom, boolean whiteToBlack) {
		while (i != j) {
			int k = top, mid = (i + j) / 2;
			while (k < bottom && image[k][mid] == '0')
				++k;
			if (k < bottom == whiteToBlack) // k < bottom means the column mid has black pixel
				j = mid; // search the boundary in the smaller half
			else
				i = mid + 1; // search the boundary in the greater half
		}
		return i;
	}

	private int searchRows(char[][] image, int i, int j, int left, int right, boolean whiteToBlack) {
		while (i != j) {
			int k = left, mid = (i + j) / 2;
			while (k < right && image[mid][k] == '0')
				++k;
			if (k < right == whiteToBlack) // k < right means the row mid has black pixel
				j = mid;
			else
				i = mid + 1;
		}
		return i;
	}

	public static void main(String[] args) {

		SmallestRectangleEnclosingBlackPixels smallestRectangle = new SmallestRectangleEnclosingBlackPixels();

		char[][] image = new char[][] { { '0', '0', '1', '0' }, { '0', '1', '1', '0' }, { '0', '1', '0', '0' } };

		System.out.println(smallestRectangle.minArea(image, 0, 2));

	}

}
