package com.sri.algo.unionfind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OptimizeWaterDistributionInaVillage {
	
	 int[] uf;


	  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
	  	uf = new int[n + 1];

	  	var edges = new ArrayList<int[]>();


	  	for(int i=0; i < n; i++)
	  	{
	  		uf[i+1] = i + 1;
	  		edges.add(new int[]{0, i + 1, wells[i]});
	  	}

	  	for(int[] p : pipes)
	  	{
	  		edges.add(p);
	  	}

	  	Collections.sort(edges, Comparator.comparing(a -> a[2]));

	  	int res = 0;

	  	for(int[] e : edges)
	  	{
	  		int x = find(e[0]), y = find(e[1]);
	  		if(x  != y)
	  		{
	  			res += e[2];
	  			uf[x] = y;
	  			--n;
	  		}
	  	}

	  	return res;
	  }


	  private int find(int x)
	  {
	  		if(x != uf[x])
	  		{
	  			uf[x] = find(uf[x]);
	  		}

	  		return uf[x];
	  }
	  
	  public static void main(String[] args) {
		  int n = 3;
		  int[] wells = new int[] {1,2,2};
		  int[][] pipes = new int[][] {{1,2,1},{2,3,1}};
		  OptimizeWaterDistributionInaVillage waterDistribution = new OptimizeWaterDistributionInaVillage();
		  
		  System.out.println(waterDistribution.minCostToSupplyWater(n, wells, pipes));
	}

}
