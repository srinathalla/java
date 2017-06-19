package com.sri.algo.graph;

import java.util.LinkedHashSet;
import java.util.Set;

public class Vertex {
	private int id;
	private String name;
	private Set<Vertex> adjacentVertices;
	private boolean visited;

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Set<Vertex> getAdjacentVertices() {
		return adjacentVertices;
	}

	public Vertex(int id) {
		this.id = id;
		adjacentVertices = new LinkedHashSet<>();
	}

	
	public int getId() {
		return id;
	}

	public Vertex withName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
