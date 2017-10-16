package com.sri.algo.heap;

import java.util.Arrays;

/**
 * 1) A Binary Heap is a Binary Tree with following properties. 1) It’s a
 * complete tree (All levels are completely filled except possibly the last
 * level and the last level has all keys as left as possible). This property of
 * Binary Heap makes them suitable to be stored in an array.
 * 
 * 2) In a Max Binary Heap, the key at root must be minimum among all keys
 * present in Binary Heap. The same property must be recursively true for all
 * nodes in Binary Tree.
 * 
 * Supports insert(), delete() and extractMax() in O(logn).
 *
 * @author KH2024
 *
 */
public class BinaryMaxHeap {

	private int capacity = 10;
	private int[] heap = new int[capacity];
	int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		heap = Arrays.copyOf(heap, 2 * size);
		capacity = 2 * size;
	}

	public int getMin() {
		if (size == 0) {
			return -1;
		}
		return heap[0];
	}

	public int extractMax() {
		if (size == 0) {
			return -1;
		}

		int res = heap[0];

		heap[0] = heap[size - 1];
		size--;
		heapifyDown();

		return res;
	}

	public void insert(int no) {

		if (size == capacity) {
			ensureCapacity();
		}

		heap[size] = no;
		size++;

		heapifyUp(size - 1);
	}

	public void deleteKey(int i) {
		heap[i] = Integer.MAX_VALUE;

		heapifyUp(i);
		extractMax();
	}

	private void heapifyUp(int curr) {

		while (hasParent(curr) && heap[curr] > heap[getParentIndex(curr)]) {
			swap(curr, getParentIndex(curr));
			curr = getParentIndex(curr);
		}
	}

	private boolean hasParent(int curr) {

		int p = curr % 2 == 0 ? (curr - 2) / 2 : (curr - 1) / 2;
		return p >= 0;
	}

	private int getParentIndex(int curr) {

		int p = curr % 2 == 0 ? (curr - 2) / 2 : (curr - 1) / 2;
		return p;
	}

	private void heapifyDown() {

		int curr = 0;
		int maxIndex = -1;

		while (hasLeftChild(curr)) {

			int lIndex = getLeftChildIndex(curr);
			maxIndex = lIndex;
			if (hasrightChild(curr)) {
				int rIndex = getRightChildIndex(curr);
				maxIndex = getMaxIndex(maxIndex, rIndex);
			}

			if (heap[curr] < heap[maxIndex]) {
				swap(curr, maxIndex);
				curr = maxIndex;
			} else {
				break;
			}
		}

	}

	private int getMaxIndex(int i, int j) {

		return heap[i] > heap[j] ? i : j;
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private boolean hasLeftChild(int i) {

		return 2 * i + 1 < size;
	}

	private int getLeftChildIndex(int i) {

		return hasLeftChild(i) ? 2 * i + 1 : -1;
	}

	private boolean hasrightChild(int i) {

		return 2 * i + 2 < size;
	}

	private int getRightChildIndex(int i) {

		return hasrightChild(i) ? 2 * i + 2 : -1;
	}

	public static void main(String[] args) {

		BinaryMaxHeap heap = new BinaryMaxHeap();

		heap.insert(30);
		heap.insert(15);
		heap.insert(10);
		heap.insert(100);
		heap.insert(40);
		heap.insert(50);
		heap.insert(40);

		while (!heap.isEmpty()) {
			System.out.print(heap.extractMax() + " ");
		}

	}

}
