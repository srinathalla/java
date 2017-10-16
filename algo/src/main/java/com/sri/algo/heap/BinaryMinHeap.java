package com.sri.algo.heap;

import java.util.Arrays;

/**
 * A Binary Heap is a Binary Tree with following properties. 1) It’s a complete
 * tree (All levels are completely filled except possibly the last level and the
 * last level has all keys as left as possible). This property of Binary Heap
 * makes them suitable to be stored in an array.
 * 
 * 2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the
 * key at root must be minimum among all keys present in Binary Heap. The same
 * property must be recursively true for all nodes in Binary Tree. Max Binary
 * Heap is similar to Min Heap.
 * 
 * 
 * Supports insert(), delete() and extractmin() in O(logn).
 *
 */
public class BinaryMinHeap {

	private int capacity = 10;
	private HeapNode[] heap = new HeapNode[capacity];
	int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		heap = Arrays.copyOf(heap, 2 * size);
		capacity = 2 * size;
	}

	public HeapNode getMin() {
		if (size == 0) {
			return null;
		}
		return heap[0];
	}

	public HeapNode extractMin() {
		if (size == 0) {
			return null;
		}

		HeapNode res = heap[0];

		heap[0] = heap[size - 1];
		size--;
		heapifyDown();

		return res;
	}

	public void insert(HeapNode node) {

		if (size == capacity) {
			ensureCapacity();
		}

		heap[size] = node;
		size++;

		heapifyUp(size - 1);
	}

	public void deleteKey(int i) {
		heap[i] = new HeapNode(Integer.MIN_VALUE);

		heapifyUp(i);
		extractMin();
	}

	private void heapifyUp(int curr) {

		while (hasParent(curr) && heap[curr].val < heap[getParentIndex(curr)].val) {
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
		int minIndex = -1;

		while (hasLeftChild(curr)) {

			int lIndex = getLeftChildIndex(curr);
			minIndex = lIndex;
			if (hasrightChild(curr)) {
				int rIndex = getRightChildIndex(curr);
				minIndex = getMinIndex(minIndex, rIndex);
			}

			if (heap[curr].val > heap[minIndex].val) {
				swap(curr, minIndex);
				curr = minIndex;
			} else {
				break;
			}
		}

	}

	private int getMinIndex(int i, int j) {

		return heap[i].val < heap[j].val ? i : j;
	}

	private void swap(int i, int j) {
		HeapNode temp = heap[i];
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

		BinaryMinHeap heap = new BinaryMinHeap();

		heap.insert(new HeapNode(30));
		heap.insert(new HeapNode(15));
		heap.insert(new HeapNode(10));
		heap.insert(new HeapNode(100));
		heap.insert(new HeapNode(40));
		heap.insert(new HeapNode(50));
		heap.insert(new HeapNode(40));

		while (!heap.isEmpty()) {
			System.out.print(heap.extractMin().val + " ");
		}

	}

}
