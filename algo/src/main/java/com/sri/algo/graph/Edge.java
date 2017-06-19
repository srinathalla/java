package com.sri.algo.graph;

public class Edge 
{
	private Vertex from;
	private Vertex to;
	
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
