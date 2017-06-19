package com.sri.algo.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueWithTwoStacks {
	
	private Stack<Integer> newStack = new Stack<>();
	private Stack<Integer> oldStack = new Stack<>();

	public boolean add(Integer data) {
		newStack.push(data);
		return true;
	}

	public Integer remove() {
		shiftStacks();
	    Integer data = oldStack.pop();
		return data;
	}

	public void shiftStacks() {
		if (oldStack.isEmpty()) {
			while (!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}

	public Integer peek() {
		shiftStacks();
		return oldStack.peek();
	}

	public int size() {
		return newStack.size() + oldStack.size();
	}
	
	public String toString()
	{
		return newStack.toString() + oldStack.toString();
	}

	
	public static void main(String[] args) {
		
		QueueWithTwoStacks queue  =new QueueWithTwoStacks();
	
	
		try(Scanner in = new Scanner(System.in))
		{	
			int n = in.nextInt();
			
			for(int i=0 ; i < n;i ++)
			{
				String input = in.nextLine();
				input = !input.isEmpty() ? input : in.nextLine();
				Integer op = Integer.valueOf(input.split(" ")[0]);

               if(op == 1)
               {
            	   queue.add(Integer.valueOf(input.split(" ")[1]));
               }
               
               else if(op == 2)
               {
            	   queue.remove();
               }
               
               else
               {
            	   System.out.println(queue.peek());
               }
			}
		}	
	}

}
