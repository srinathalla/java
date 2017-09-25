package com.sri.algo.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class MaxElementInStack {
	
	    private Stack<Long> delegatedStack = new Stack<>();
		private Stack<Long> maxElementStack = new Stack<>();

		public void push(Long entry) {
			delegatedStack.push(entry);
			Long maxElement = maxElementStack.isEmpty() ? null : maxElementStack.peek();
			if (maxElement == null || maxElement.compareTo(entry) < 0) {
				maxElementStack.push(entry);
			}
		}
		
		public String toString() {
			return "Actual Stack : " + delegatedStack.toString() + "\n" + "MaxElementStack : " + maxElementStack.toString();
		}
		
		public void pop() {
			Long poppedElement = delegatedStack.pop();
			if (poppedElement.compareTo(maxElementStack.peek()) == 0) {
				maxElementStack.pop();
			}
		}

		public Long printMax() {
			return maxElementStack.peek();
		}
		
		public static void main(String[] args) throws IOException {
			
			Scanner in = new Scanner(System.in);
		        int n1 = in.nextInt();
		        int n2 = in.nextInt();
		        int n3 = in.nextInt();
		        int h1[] = new int[n1];
		        for(int h1_i=0; h1_i < n1; h1_i++){
		            h1[h1_i] = in.nextInt();
		        }
		        int h2[] = new int[n2];
		        for(int h2_i=0; h2_i < n2; h2_i++){
		            h2[h2_i] = in.nextInt();
		        }
		        int h3[] = new int[n3];
		        for(int h3_i=0; h3_i < n3; h3_i++){
		            h3[h3_i] = in.nextInt();
		        }
		        
		        Stack<Integer> s1 = new Stack<>();
		        int sum = 0;
		        for(int index = h1.length -1 ;index >=0 ;index--)
		        {
		        	sum = sum + h1[index];
		        	s1.push(sum);
		        }
		        
		        Stack<Integer> s2 = new Stack<>();
		        sum = 0;
		        for(int index = h2.length -1 ;index >=0 ;index--)
		        {
		        	sum = sum + h2[index];
		        	s2.push(sum);
		        }
		        
		        Stack<Integer> s3 = new Stack<>();
		        sum = 0;
		        for(int index = h3.length -1 ;index >=0 ;index--)
		        {
		        	sum = sum + h3[index];
		        	s3.push(sum);
		        }
		        
		        int hieght = 0;
		        while(true)
		        {
		        	if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty())
					{
						break;
					}
		        	
		        	int sum1 = s1.peek();
					int sum2 = s2.peek();
					int sum3 = s3.peek();
		
					if (sum1 == sum2 && sum2 == sum3) {
						hieght = sum1;
						break;
					}
		
					if (sum1 >= sum2 && sum1 >= sum3) {
						s1.pop();
					}
		
					if (sum2 >= sum1 && sum2 >= sum3)
					{
						s2.pop();
					}
		
					if (sum3 >= sum1 && sum3 >= sum2)
					{
						s3.pop();       
					}
					
					
		        }
		        
		        System.out.println(hieght);
		        
		
		}

}
