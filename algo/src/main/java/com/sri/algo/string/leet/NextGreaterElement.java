package com.sri.algo.string.leet;

/**
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n 
 * and is greater in value than n. If no such positive 32-bit integer 
 * exists, you need to return -1.
 * @author salla
 *
 */
public class NextGreaterElement {
	
	
	 public int nextGreaterElement(int n) {
	        
		 char[] a = ("" + n).toCharArray();
		 
		 int i = a.length - 2;
		 
		 while (i >=0 && a[i] >= a[i+ 1])
		 {
			 i--;
		 }
		 
		 if (i == -1)
		 {
			 return -1;
		 }
		 
		 int j = a.length -1;
		 
		 while (j >= 0 && a[i] >= a[j])
		 {
			 j--;
		 }
		 
		 swap(a,i,j);
		 
		 reverse(a, i+1);
		 
		 try
		 {
			 return Integer.parseInt(new String(a));
		 }
		 catch(Exception e)
		 {
			 return -1;
		 }
		 
	 }
	    
	    private void reverse(char[] a, int start) {
	        
	    	int i= start, j = a.length -1;
	    	
	    	while(i < j)
	    	{
	    		swap(a,i,j);
	    		i++;
	    		j--;
	    	}
	    }
	    private void swap(char[] a, int i, int j) {
	       char tmp = a[i];
	       a[i] = a[j];
	       a[j] = tmp;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	NextGreaterElement nge = new NextGreaterElement();
	    	
	    	System.out.println(
    			nge.nextGreaterElement(12));
			
		}
}
