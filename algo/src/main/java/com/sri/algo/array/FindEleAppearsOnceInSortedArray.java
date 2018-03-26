package com.sri.algo.array;

public class FindEleAppearsOnceInSortedArray {
	
	/**
	 * Using linear scan T.C : O(n/2)
	 * @param arr
	 * @return
	 */
	public static int findEleAppearsOnce(int[] arr)
	{
	
		for (int i =0 ;i < arr.length-2;i = i+ 2)
		{	
			if(arr[i] != arr[i+1]) 
			{
				return arr[i];
			}
		}
		
		return arr[arr.length -1];
		
	}
	
	/**
	 * Using linear scan T.C : O(n/2)
	 * @param arr
	 * @return
	 */
	public static int findEleAppearsOnce(int[] arr,int l,int h)
	{
		 if(l == h)
		 {
			 return arr[l];
		 }
		 
		 int mid = l + (h - l)/2;
		 
		 if (mid % 2 == 0)
		 {
			 if(arr[mid] == arr[mid +1])
			 {
				 return findEleAppearsOnce(arr,mid +1,h);
			 }
			 return findEleAppearsOnce(arr,l,mid -1);
		 }
		 else
		 {
			 if(arr[mid] == arr[mid - 1])
			 {
				 return arr[mid] != arr[mid + 1] ? arr[mid +1] : findEleAppearsOnce(arr,mid +1,h);
			 }
			 return findEleAppearsOnce(arr,l,mid -1);
		 }
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(findEleAppearsOnce(new int[] {1 ,1 ,2 ,2 ,3 ,3 ,4 ,50 ,50 ,65 ,65},0,10));
		
		System.out.println(findEleAppearsOnce(new int[] {1 ,1 ,2 ,2 ,3},0,4));
		
		System.out.println(findEleAppearsOnce(new int[] {1 ,2 ,2 ,3 ,3},0,4));
		
		 /*try(Scanner in = new Scanner(System.in))
		 {
	        int testCount = in.nextInt();
	        for (int i =0 ;i < testCount ; i++)
	        {
	        	int n = in.nextInt();	
	        	int[] arr = new int[n];
	        	
	        	for (int j =0 ;j < n ; j++)
		        { 
	        		arr[j] = in.nextInt();
		        }
	        	
	        	System.out.println(findEleAppearsOnce(arr));
	        	
	        	System.out.println(findEleAppearsOnce(arr,0,10));
	      } }*/
		
	}

}
