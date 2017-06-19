package com.sri.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DiGraph extends Graph{

	public DiGraph(int V) {
		super(V);
	}
	
	
	public void removeAllEdges()
	{
		// Reset visited flag for all vertices.
		for (Vertex vertex : getVertices().values())
		{
			vertex.getAdjacentVertices().clear();
		}
	}
	
	public boolean hasRoute(int from, int to)
	{
		Vertex fromVertex = getVertices().get(from);
		Vertex toVertex = getVertices().get(to);
		
		return hasRoute(fromVertex,toVertex);
	}
	
	// DFS traversal helps us to give the route.
	private boolean hasRoute(Vertex from, Vertex to)
	{
		
		if (from.equals(to))
		{
			return true;
		}
		
		from.setVisited(true);
		for(Vertex adjVertex : from.getAdjacentVertices())
		{
			// Recurse on adjacent vertices not visited.
			if(!adjVertex.isVisited())
			{	
				if (hasRoute(adjVertex,to))
				{
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	public Graph addEdge(int from, int to)
	{	
		incrementE();
		 
	    Vertex fromVertex = super.getVertices().get(from);
	    Vertex toVertex = super.getVertices().get(to);
	    
	    fromVertex.getAdjacentVertices().add(toVertex);
	   
	    return this;	
	}
	
	public Graph removeEdge(int from, int to)
	{	
		 decrementE();
		 
	    Vertex fromVertex = super.getVertices().get(from);
	    
	    fromVertex.getAdjacentVertices().remove(new Vertex(to));
	   
	    return this;	
	}
	
	public Vertex addVertex(int id)
	{
		if (!getVertices().containsKey(id))
		{
			getVertices().put(id, new Vertex(id));
		}
		
		return getVertices().get(id);
	}
	
	
	public boolean hasCycle()
	{	
		resetVisitedStatus();
		
		for (Vertex vertex : getVertices().values())
		{
			if (!vertex.isVisited())
			{
				if (hasCycle(vertex, new HashSet<Vertex>()))
				{
					return true;
				}
			}	
		}
		
		return false;
	}
	
	private boolean hasCycle(Vertex vertex,Set<Vertex> pathStack)
	{
		vertex.setVisited(true);
		pathStack.add(vertex);
		
		for (Vertex  adjVertex : vertex.getAdjacentVertices())
		{
			
			if (!adjVertex.isVisited())
			{
				if (hasCycle(adjVertex, pathStack))
				{
					return true;
				}
			}
			else if(pathStack.contains(adjVertex))
			{
			    return true;	
			}
		}
		
		pathStack.remove(vertex);
		
		return false;
		
	}
	
	public List<Vertex> topologicalSort()
	{
		List<Vertex> topoligicalSortedList = new ArrayList<>();
		Stack<Vertex> topologicalOrderStack = new Stack<>();
		
		resetVisitedStatus();
		
		for (Vertex vertex : getVertices().values())
		{
			if (!vertex.isVisited())
			{
				topologicalSort(vertex,topologicalOrderStack);
			}	
		}
		
		while (!topologicalOrderStack.isEmpty())
		{
			topoligicalSortedList.add(topologicalOrderStack.pop());
		}
		
		return topoligicalSortedList;
	}
	
	private void topologicalSort(Vertex vertex, Stack<Vertex> stack)
	{
		for (Vertex  adjVertex : vertex.getAdjacentVertices())
		{	
			if (!adjVertex.isVisited())
			{
				topologicalSort(adjVertex,stack);
			}
		}
		
		// Push the element to stack after all its children are visited.
		vertex.setVisited(true);
		stack.push(vertex);
		
	}
	

}
