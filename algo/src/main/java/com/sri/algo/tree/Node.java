package com.sri.algo.tree;

public class Node {

	public int data;
	public Node left;
	public Node right;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
