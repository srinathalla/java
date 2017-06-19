package com.sri.algo.tree;

public class DiameterOfBinaryTree {
	static class  Hieght {
		int h = 0;
	}

	public int getDiameter(Node node, Hieght hieght) 
	{
		
		Hieght lh = new Hieght();
		Hieght rh = new Hieght();
		
		if (node == null) {
			hieght.h = 0;
			return 0;
		}

		lh.h++; rh.h++;
		int ld = getDiameter(node.left, lh);
		int rd = getDiameter(node.right, rh);
		
		hieght.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));

	}

	public int getHeight(Node node) {

		if (node == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.insertLeft(10, 20);
		binaryTree.insertRight(10, 30);

		binaryTree.insertLeft(20, 40);
		binaryTree.insertRight(20, 60);

		System.out.println(new DiameterOfBinaryTree().getDiameter(binaryTree.getRoot(),new Hieght()));
	}
}
