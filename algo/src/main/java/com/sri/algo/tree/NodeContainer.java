package com.sri.algo.tree;

public class NodeContainer {

	public NodeContainer(Node node, int hd) {
		super();
		this.node = node;
		this.hd = hd;
	}

	public NodeContainer(Node node) {
		super();
		this.node = node;
	}

	public Node node;
	public int hd;
	public int level;

	public NodeContainer withLevel(int level) {

		this.level = level;
		return this;
	}

}
