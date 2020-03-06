package com.sri.algo.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * You have an infinite number of stacks arranged in a row and numbered (left to
 * right) from 0, each of the stacks has the same maximum capacity.
 * 
 * Implement the DinnerPlates class:
 * 
 * DinnerPlates(int capacity) Initializes the object with the maximum capacity
 * of the stacks. void push(int val) pushes the given positive integer val into
 * the leftmost stack with size less than capacity. int pop() returns the value
 * at the top of the rightmost non-empty stack and removes it from that stack,
 * and returns -1 if all stacks are empty. int popAtStack(int index) returns the
 * value at the top of the stack with the given index and removes it from that
 * stack, and returns -1 if the stack with that given index is empty. Example:
 * 
 * Input:
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]] Output:
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * 
 * @author srialla
 *
 */
public class DinnerPlates {

	List<Stack<Integer>> stacks;
	int capacity;
	int curStack = 0;
	TreeSet<Integer> leftMostStacks = new TreeSet<>();

	public DinnerPlates(int capacity) {
		this.stacks = new ArrayList<>();
		this.capacity = capacity;
		this.stacks.add(new Stack<>());

	}

	public void push(int val) {

		if (this.leftMostStacks.isEmpty()) {
			this.stacks.get(curStack).push(val);

			if (this.stacks.get(curStack).size() == capacity) {
				curStack++;
				this.stacks.add(new Stack<>());
			}
		} else {
			int index = this.leftMostStacks.first();
			this.stacks.get(index).push(val);
			if (this.stacks.get(index).size() == capacity) {
				this.leftMostStacks.remove(index);
			}
		}

	}

	public int pop() {

		while (this.stacks.get(curStack).size() == 0) {
			if (curStack > 0) {
				if (this.leftMostStacks.contains(curStack)) {
					this.leftMostStacks.remove(curStack);
				}
				this.stacks.remove(curStack);
				curStack--;
			} else {
				return -1;
			}
		}

		return this.stacks.get(curStack).pop();
	}

	public int popAtStack(int index) {

		if (curStack >= index) {
			if (index < curStack) {
				this.leftMostStacks.add(index);
			}
			return this.stacks.get(index).pop();
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {

		DinnerPlates d1 = new DinnerPlates(1);
		d1.push(1);
		d1.push(2);
		System.out.println(d1.popAtStack(1));
		System.out.println(d1.pop());
		d1.push(1);
		d1.push(2);
		System.out.println(d1.pop());

//		DinnerPlates D = new DinnerPlates(2); // Initialize with capacity = 2
//		D.push(1);
//		D.push(2);
//		D.push(3);
//		D.push(4);
//		D.push(5); // The stacks are now: 2 4
//					// 1 3 5
//					// ﹈ ﹈ ﹈
//		System.out.println(D.popAtStack(0)); // Returns 2. The stacks are now: 4
//												// 1 3 5
//												// ﹈ ﹈ ﹈
//		D.push(20); // The stacks are now: 20 4
//					// 1 3 5
//					// ﹈ ﹈ ﹈
//		D.push(21); // The stacks are now: 20 4 21
//					// 1 3 5
//					// ﹈ ﹈ ﹈
//		System.out.println(D.popAtStack(0)); // Returns 20. The stacks are now: 4 21
//							// 1 3 5
//							// ﹈ ﹈ ﹈
//		System.out.println(D.popAtStack(2)); // Returns 21. The stacks are now: 4
//							// 1 3 5
//							// ﹈ ﹈ ﹈
//		System.out.println(D.pop()); // Returns 5. The stacks are now: 4
//					// 1 3
//					// ﹈ ﹈
//		System.out.println(D.pop()); // Returns 4. The stacks are now: 1 3
//					// ﹈ ﹈
//		System.out.println(D.pop()); // Returns 3. The stacks are now: 1
//					// ﹈
//		System.out.println(D.pop()); // Returns 1. There are no stacks.
//		System.out.println(D.pop());
	}

}
