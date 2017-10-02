package com.sri.algo.graph;

public class Edge 
{
	private Vertex from;
	private Vertex to;
	private int wt;
	
	public int getWt() {
		return wt;
	}

	public void setWt(int wt) {
		this.wt = wt;
	}

	public void setFrom(Vertex from) {
		this.from = from;
	}

	public void setTo(Vertex to) {
		this.to = to;
	}

	public Vertex getFrom() {
		return from;
	}

	public Vertex getTo() {
		return to;
	}

	public Edge(Vertex from, Vertex to) {
		super();
		this.from = from;
		this.to = to;
	}

}
