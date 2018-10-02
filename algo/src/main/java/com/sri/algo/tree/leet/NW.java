package com.sri.algo.tree.leet;

public class NW {
	
	TreeNode node;
	int d; //  d is depth
	int p; //  p is position of node in the tree.

	public NW(TreeNode root, int d) {
		super();
		this.node = root;
		this.d = d;
	}
	
	public NW(TreeNode root, int d,int p) {
		super();
		this.node = root;
		this.d = d;
		this.p = p;
	}

}
