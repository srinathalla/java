package com.sri.algo.dp;

import java.util.Arrays;

public class BoxStacking {
	
	private static class Box implements Comparable<Box>
	{
		int l,b,h;
		
		public Box(int h,int b,int l)
		{
			this.h = h;
			this.b = b;
			this.l = l;
		}
		
		public Box() 
		{
			
		}

		@Override
		public int compareTo(Box o) {
				
			return (o.l * o.b) -  (this.l * this.b);
		}		
		
	}
	/* Returns the height of the tallest stack that can be
	   formed with give type of boxes */
	public static int maxStackHeight(Box[] arr)
	{
		Box[] rotArr = new Box[arr.length * 3];
		
		// Fill rotated array with all given boxes and its rotated combinations.
		int index = 0;
		for (int i = 0 ;i < arr.length;i++)
		{
			Box box = arr[i];
			
			rotArr[index] = box;
			index++;
			
			// First rotation 
			// where length of current box is made as height of new box;
			Box box1 = new Box();
			box1.h = box.l;
			box1.l = Integer.max(box.b,box.h);
			box1.b = Integer.min(box.b,box.h);
			
			rotArr[index] = box1;
			index++;
			
			// Second rotation.
			// where breadth of current box is made as height of new box;
			Box box2 = new Box();
			box2.h = box.b;
			box2.l = Integer.max(box.l,box.h);
			box2.b = Integer.min(box.l,box.h);
			
			rotArr[index] = box2;
			index++;	
		}
		
		// Sort all the boxes in decreasing order of base area(i.e l,b)
		Arrays.sort(rotArr);
		
		// Create an array of max heights and assign with default box heights.
		int[] mhs = new int[rotArr.length];
		for (int i = 0;i < rotArr.length;i ++)
		{
			mhs[i] = rotArr[i].h;
		}
		
		for (int i = 1;i < mhs.length ;i ++)
		{
			
			for (int j=0 ;j <i;j++)
			{
				
				if (rotArr[j].l > rotArr[i].l && 
					rotArr[j].b > rotArr[i].b)
				{
					// Get maximum of mhs  till i.
					mhs[i] = Integer.max(
						mhs[i], 
						mhs[j] + rotArr[i].h);
				}
			}
		}
		
		int max= Integer.MIN_VALUE;
		for (int i =0 ;i <mhs.length ; i ++)
		{
			max = Integer.max(max, mhs[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		Box arr[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32) };
		
		System.out.println(maxStackHeight(arr));
	}

}
