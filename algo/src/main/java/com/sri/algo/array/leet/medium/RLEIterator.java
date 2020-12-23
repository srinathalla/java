package com.sri.algo.array.leet.medium;

public class RLEIterator {
	
	private int i=0;
    private int[] A;
    public RLEIterator(int[] A) {
        this.A = A;   
    }
    
    public int next(int n) {
        
        while(n > 0 && i < A.length)
        {
            if(n > A[i])
            {
                n -= A[i];
                i +=2;
            }
            else
            {
                A[i] -= n;
                n = 0;
                
                if(A[i] == 0)
                {
                    i += 2;
                    return A[i-1];
                }
                
                return A[i+1];
                
            }
        }
        
        return i < A.length ? A[i+1] : -1;    
    }

    
    public static void main(String[] args) {
    	int[] A = new int[] {3,8,0,9,2,5};
    	
     	RLEIterator rle = new RLEIterator(A);
     	System.out.println(
 			rle.next(2));
     	System.out.println(
     			rle.next(1));
     	System.out.println(
     			rle.next(1));
     	System.out.println(
     			rle.next(2));
    }
    	
    	

}
