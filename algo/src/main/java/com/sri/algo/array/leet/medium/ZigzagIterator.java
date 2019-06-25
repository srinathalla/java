package com.sri.algo.array.leet.medium;

import java.util.Arrays;
import java.util.List;

public class ZigzagIterator {
	
	List<Integer> v1;
	List<Integer> v2;
	int i = 0;
	int j = 0;
	boolean isFirst = true;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		 
		 this.v1 = v1;
		 this.v2 = v2;
		      
	    }

	public int next() {
		
		if (isFirst)
		{
			isFirst = false;
			
			if (i < v1.size())
			{
				return v1.get(i++);
			}
			if (j < v2.size())
			{
				return v2.get(j++);
			}
		}
		
		if (!isFirst)
		{
			isFirst = true;
			if (j < v2.size())
			{
				return v2.get(j++);
			}
			if (i < v1.size())
			{
				return v1.get(i++);
			}
		}
		
		return -1;

	}

	public boolean hasNext() {
		
		return i < v1.size() || j < v2.size();

	}
	
	public static void main(String[] args) {
		
		
		/*ZigzagIterator zigzagIterator = new ZigzagIterator(
				Arrays.asList(new Integer[] {1,2}),
			    Arrays.asList(new Integer[] {3,4,5,6}));*/
		
		ZigzagIterator zigzagIterator = new ZigzagIterator(
				Arrays.asList(new Integer[] {1,2}),
			    Arrays.asList(new Integer[] {}));
		
		System.out.println(zigzagIterator.next());
		System.out.println(zigzagIterator.next());
		System.out.println(zigzagIterator.next());
		System.out.println(zigzagIterator.next());
		System.out.println(zigzagIterator.next());
		System.out.println(zigzagIterator.next());
		
		
	}

}
