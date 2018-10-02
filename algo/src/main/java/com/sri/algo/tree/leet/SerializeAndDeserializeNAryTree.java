package com.sri.algo.tree.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserializeNAryTree {

	private static class Node {

		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public String serialize(Node root) {

		List<Integer> list = new LinkedList<>();
		serialize(root, list);

		StringBuilder sb = new StringBuilder();

		if (list.size() > 0) {
			for (Integer no : list) {
				sb.append(no).append(',');
			}

			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	public void serialize(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}

		list.add(node.val);
		list.add(node.children != null ? node.children.size() : 0);

		if (node.children != null && node.children.size() > 0) {

			for (Node child : node.children) {
				serialize(child, list);
			}
		}
	}

	// Decodes your encoded data to tree.
	public Node deserialize(String data) {

		if (data.isEmpty()) {
			return null;
		}

		String[] values = data.split(",");

		return deserialize(values, new int[] { 0 });

	}

	private Node deserialize(String[] nos, int[] i) {

		int val = Integer.valueOf(nos[i[0]]);

		int cCount = Integer.valueOf(nos[++i[0]]);

		List<Node> children = new ArrayList<>();

		for (int j = 1; j <= cCount; j++) {

			i[0]++;
			children.add(deserialize(nos, i));

		}

		return new Node(val, children);

	}

	public static void main(String[] args) {

		SerializeAndDeserializeNAryTree se = new SerializeAndDeserializeNAryTree();

		List<Node> children = new ArrayList<>();
		children.add(new Node(2, null));
		children.add(new Node(3, null));
		children.add(new Node(4, null));

		Node root = new Node(1, children);

		System.out.println(se.serialize(root));

		Node dserNode = se.deserialize("1,3,2,0,3,0,4,0");

		System.out.println(se.serialize(dserNode));

	}

}
