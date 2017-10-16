package com.sri.algo.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {

	public static void printBinaryinRange(int n) {

		Queue<String> binaryQueue = new LinkedList<>();

		binaryQueue.add("1");

		int count = 0;

		while (!binaryQueue.isEmpty()) {
			String s = binaryQueue.poll();
			System.out.print(s + " ");
			count++;

			if (count == n) {
				break;
			}

			binaryQueue.add(s + "0");
			binaryQueue.add(s + "1");
		}
	}
	
	public static void main(String[] args) {
		
		printBinaryinRange(15);
	}

}
