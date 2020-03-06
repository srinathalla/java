package com.sri.algo.queue;

import java.util.Scanner;

import com.sri.algo.MyStack;

public class QueueUsingTwoStacks<T> {

	private MyStack<T> newStack = new MyStack<>();
	private MyStack<T> oldStack = new MyStack<>();

	public boolean add(T data) {
		newStack.push(data);
		return true;
	}

	public T remove() {
		shiftStacks();
		T data = oldStack.pop();
		return data;
	}

	public void shiftStacks() {
		if (oldStack.isEmpty()) {
			while (!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return oldStack.peek();
	}

	public int size() {
		return newStack.size() + oldStack.size();
	}
	

	@SuppressWarnings("unchecked")
	public void addAll(T... elements) {
		for (T t : elements) {
			add(t);
		}
	}
	
	public String toString()
	{
		return newStack.toString() + oldStack.toString();
	}

	
	public static void main(String[] args) {
		
		QueueUsingTwoStacks<Integer> queue  =new QueueUsingTwoStacks<>();
		
		queue.addAll(10,20,30,40);
		
		System.out.println(queue);
		
		System.out.println("Start Element in Queue : " + queue.peek());
		System.out.println("Element Removed : " + queue.remove());
		System.out.println("Start Element in Queue : " + queue.peek());
		System.out.println(queue);
		System.out.println("Element Removed : " + queue.remove());
		System.out.println("Start Element in Queue : " + queue.peek());
		
		try(Scanner in = new Scanner(System.in))
		{
			
			int n = in.nextInt();
			
			for(int i=0 ; i < n;i ++)
			{
				String input = in.nextLine();
				int op = Integer.valueOf(input.split(" ")[0]);
			}
		}
		
		
		
		
	}

}
