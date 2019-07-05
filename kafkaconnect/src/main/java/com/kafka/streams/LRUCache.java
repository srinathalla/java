package com.kafka.streams;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache<K, V> {

	
	int capacity;
	Map<K, V> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new LinkedHashMap<K, V>(capacity, 1, true);
	}

	public V get(K key) {

		return map.get(key);
	}

	public void put(K key, V val) {

		map.put(key, val);

	}
	
	public void remove(K key) {

		map.remove(key);

	}

}
