package com.sri.algo.graph.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	static class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};

	Map<Integer, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {

		return clone(node);

	}

	public Node clone(Node node) {

		if (node == null) {
			return null;
		}

		if (map.containsKey(node.val)) {
			return map.get(node.val);
		}

		Node cloned = new Node(node.val, new ArrayList<>());
		map.put(node.val, cloned);

		for (Node neighbour : node.neighbors) {

			cloned.neighbors.add(cloneGraph(neighbour));
		}

		return cloned;

	}

}
