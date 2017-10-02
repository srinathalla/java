package com.sri.algo.graph.cp;

public class Edge {
	
	
	int from;
	int to;
	int wt;
	
	public Edge(int from, int to, int wt) {
		super();
		this.from = from;
		this.to = to;
		this.wt = wt;
	}
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWt() {
		return wt;
	}
	public void setWt(int wt) {
		this.wt = wt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + from;
		result = prime * result + to;
		result = prime * result + wt;
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
		Edge other = (Edge) obj;
		if (from != other.from)
			return false;
		if (to != other.to)
			return false;
		if (wt != other.wt)
			return false;
		return true;
	}

}
