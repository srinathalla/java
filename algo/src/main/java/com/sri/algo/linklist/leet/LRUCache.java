package com.sri.algo.linklist.leet;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	class Entry
	{
		
		int key;
		int value;
		Entry next;
		Entry prev;
		
		public Entry(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}	
		
	}
	
	private int capacity;
	private Entry head, tail;
	private Map<Integer, Entry> map = new HashMap<>();
	
	public LRUCache(int capacity) {

		head = new Entry(-1, -1);

		tail = new Entry(-1, -1);

		head.next = tail;
		tail.prev = head;

		this.capacity = capacity;

	}

	public int get(int key) {
		
		if (!map.containsKey(key))
		{
			return -1;
		}
		
		Entry entry = map.get(key);
		
		deleteNode(entry);
		addToHead(entry);
		
		return entry.value;
	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {
			Entry entry = map.get(key);
			entry.value = value;

			deleteNode(entry);
			addToHead(entry);
		} else if (capacity > 0) {
			if (map.size() == capacity) {		
				map.remove(tail.prev.key);
				deleteNode(tail.prev);
			}

			Entry entry = new Entry(key, value);
			map.put(key, entry);
			addToHead(entry);
		}

	}

	private void deleteNode(Entry entry) {
		entry.prev.next = entry.next;
		entry.next.prev = entry.prev;
	}

	private void addToHead(Entry entry) {
	
		entry.prev = head;
		entry.next = head.next;
		entry.next.prev = entry;
		entry.prev.next = entry;	
	}

	
	public static void main(String[] args) {
		
		// [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		
	}
}
