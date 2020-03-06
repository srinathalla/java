package com.sri.algo.dp;

public class EggDropping {
	
	/**
	 * 
	 * @param n - no of eggs
	 * @param k - no of floors.
	 * @return
	 * 
	 */
	public static int dropEgg(int n, int k)
	{
		// No of floors is less than or equal to 1.
		if (k <= 1)
		{
			return k;
		}
		
		// Only one egg present.
		if (n ==1)
		{
			return k;
		}
		
		int min = Integer.MAX_VALUE;	
		for (int i = 1; i<= k ; i++)
		{		
			int res = 1 + Integer.max( dropEgg(n-1, i-1) , dropEgg(n, k-i));	
			min = Integer.min(min, res);		
		}	
		return min;
	}
	
	/**
	 * 
	 * @param n - no of eggs
	 * @param k - no of floors.
	 * @return
	 */  
    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    static int dropEggWithDP(int n, int k)
    {
    	int[][] table = new int[n + 1][k + 1];
    	
    	// Floor 1 needs 1 attempt  floor 0 needs 0 attempts.
    	for (int i = 0; i<=n; i++)
    	{
    		table[i][0] = 0; 
    		table[i][1] = 1; 
    	}
    	
    	// When only 1 egg is present number of attempts required
    	// in worst case is number of floors present.
    	for (int j = 2;j <=k; j++)
    	{
    		table[1][j] = j;
    	}
    	
    	for (int i = 2 ;i <= n; i++)
    	{
    		for (int j = 2 ; j<= k ;j ++)
    		{
    			 int min = Integer.MAX_VALUE;
    	         for (int x = 1; x <= j ;x++)
    	         {	 
    	        	 int res = 1 + Integer.max(table[i-1][x-1] , table[i][j -x]);
    	        	 
    	        	 min = Integer.min(min, res);
    	         }
    	         table[i][j] = min;
    		}
    	}
               	
    	return table[n][k];
    }
    
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }
    
    public int superEggDropOptimized(int K, int N) {
        int dp[] = new int[K + 1], m = 0;
        for (m = 0; dp[K] < N; ++m)
            for (int k = K; k > 0; --k)
                dp[k] += dp[k - 1] + 1;
        return m;
    }
	
	public static void main(String[] args) {
		
	
		//System.out.println(dropEgg(2 , 30));	

		
		//System.out.println("Time Taken : " + (end - start)/1000);
		
		EggDropping eggDrop = new EggDropping();
		System.out.println(
			eggDrop.superEggDrop(1, 2));
		// System.out.println(dropEggWithDP(1 , 2));	
	
		 
	
	}

}
