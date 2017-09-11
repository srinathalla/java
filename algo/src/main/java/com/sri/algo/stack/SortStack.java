package com.sri.algo.stack;

import java.util.Stack;

/**
 * Sorts the stack in descdending order i.e 
 * biggest at the bottom to the smallest at the top.
 * 
 * @author KH2024
 *
 */
public class SortStack {

	public static Stack<Integer> sortStack(Stack<Integer> oldStack) {
	
		Stack<Integer> sortedStack = new Stack<>();
		Stack<Integer> newStack = new Stack<>();

		while (!oldStack.isEmpty()) {
			copyStacks(oldStack, newStack);
			sortedStack.add(newStack.pop());

			Stack<Integer> temp = oldStack;
			oldStack = newStack;
			newStack = temp;
		}

		return sortedStack;
	}

	private static void copyStacks(Stack<Integer> oldStack, Stack<Integer> newStack) {
		while (!oldStack.isEmpty()) {
			Integer item = oldStack.pop();

			if (newStack.isEmpty()) {
				newStack.push(item);

			} else {
				if (newStack.peek() < item) {
					newStack.push(item);
				} else {
					Integer biggerRoti = newStack.pop();
					newStack.push(item);
					newStack.push(biggerRoti);
				}
			}
		}
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(4);
		stack = sortStack(stack);

		System.out.println(stack);

	}

}
