package com.sri.algo.array;


/**
 *  Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
 *  The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

	Now you want to find out who the celebrity is or verify that there is not one. 
	The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information 
	of whether A knows B. You need to find out the celebrity (or verify there is not one) by 
	asking as few questions as possible (in the asymptotic sense).

   You are given a helper function bool knows(a, b) which tells you whether A knows B. 
   Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
   
   T.C : O(2n) => O(n).
   
   2 pass solution.
   In first pass we get possible candidate.
   In second pass we check whether candidate is a valid celebrity or not.
   
 * @author salla
 *
 */
public class CelebrityProblem {
	
	 private boolean isCeleb = false; 
	 
	 
	 public int findCelebrity(int n) {
		 
		 int celeb = 0;
		 for (int i = 1; i< n;i++)
		 {
			 if(knows(celeb,i))
			 {
				 celeb = i;
			 }	
		 }
		 
		 for (int i = 0; i < n;i++)
		 {
			 if( i != celeb && !knows(i,celeb) || knows(celeb ,i))
			 {
				 return -1;
			 }	
		 }
		 
		 return celeb;
	        
	  }
	 
	 boolean knows(int a, int b)
	 {
		 this.isCeleb =  !this.isCeleb;
		 
		 return this.isCeleb;
	 }

}
