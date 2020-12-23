package com.sri.algo.string.leet.medium;

public class BullsAndCows {


    public String getHint(String secret, String guess) {
        
        
        var map = new int[10];
        
        int a = 0, b = 0;


        for(char c :  secret.toCharArray())
        {
            map[c - '0']++;
        }


        for(int i=0; i < secret.length();i++)
        {
            int no = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(no == g)
            {
                a++;
                map[no]--;
            }
        }

        for(int i=0; i < secret.length();i++)
        {
            int no = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(no != g && map[g] > 0)
            {
                b++;
                map[no]--;
            }
        }
        
        
        return Integer.valueOf(a).toString() + 'A' + Integer.valueOf(b).toString()  + 'B';
        
    }
    
    public static void main(String[] args) {
    	
    
		
	}
}
