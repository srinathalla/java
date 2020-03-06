package com.sri.algo.dp.leet;

import java.util.Arrays;

public class VideoStitching {
	
	
	public int videoStitching(int[][] clips, int T) {
        int res = 0;
        Arrays.sort(clips, (a,b) ->  a[0] - b[0]);
        for (int i = 0, st = 0, end = 0; st < T; st = end, ++res) {
            for (; i < clips.length && clips[i][0] <= st; ++i)
            {
            	 end = Math.max(end, clips[i][1]);
            	 System.out.println("st :" + st + " end: " + end + " res: " + res);
            }   
            if (st == end) return -1;
        }
        return res;
    }
	
	
	public static void main(String[] args) {
		
		
		int[][] input=  {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
		
		VideoStitching vs = new VideoStitching();
		System.out.println(
				vs.videoStitching(input, 10));
		
	}

}
