package com.sri.algo;

public class MyStackOperations<T extends Comparable<T>> {

	private MyStack<T> delegatedStack = new MyStack<>();
	private MyStack<T> maxElementStack = new MyStack<>();

	public void push(T entry) {
		delegatedStack.push(entry);
		T maxElement = maxElementStack.peek();
		if (maxElement == null || maxElement.compareTo(entry) < 0) {
			maxElementStack.push(entry);
		}
	}
	
	public String toString() {
		return "Actual Stack : " + delegatedStack.toString() + "\n" + "MaxElementStack : " + maxElementStack.toString();
	}
	

	@SuppressWarnings("unchecked")
	public void pushAll(T... elements) {
		for (T t : elements) {
			push(t);
		}
	}

	public void pop() {
		T poppedElement = delegatedStack.pop();
		if (poppedElement.compareTo(maxElementStack.peek()) == 0) {
			maxElementStack.pop();
		}
	}

	public T printMax() {
		return maxElementStack.peek();
	}
	
	public static void main(String[] args) {
		MyStackOperations<Integer> stack = new MyStackOperations<>();
		stack.pushAll(1, 20, 5, 4, 15,30,7);
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());

	}

}
