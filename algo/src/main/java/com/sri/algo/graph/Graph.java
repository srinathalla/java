package com.sri.algo.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sri.algo.linklist.LinkedList;

public class Graph 
{	
	public Map<Integer, Vertex> getVertices() {
		return vertices;
	}

	public int getE() {
		return E;
	}
	
	public int incrementE() {
		return ++E;
	}
	
	public int decrementE() {
		return --E;
	}

	private Map<Integer,Vertex> vertices;
	private int E;
		
	/**
	 * 
	 * Initializes an empty graph with {@code V} vertices and 0 edges.
	 * 
	 * @param V the number of vertices.
	 */
	public Graph(int V)
	{	
		vertices = new LinkedHashMap<>();
		
		for(int id =0 ;id < V; id++)
		{
			vertices.put(id,new Vertex(id));
		}
	}
	
	protected void resetVisitedStatus()
	{
		// Reset visited flag for all vertices.
		for (Vertex vertex : getVertices().values())
		{
			vertex.setVisited(false);
		}
	}
	
	public Graph addEdge(int from, int to)
	{	
		E++;
	    Vertex fromVertex = vertices.get(from);
	    Vertex toVertex = vertices.get(to);
	    
	    fromVertex.getAdjacentVertices().add(toVertex);
	    
	    toVertex.getAdjacentVertices().add(fromVertex);
	   
	    return this;	
	}
	
	
	 public boolean hasCycle()
	 {
		 
		 for (Vertex vertex : vertices.values())
		 {
			 if (!vertex.isVisited())
			 {
				 boolean cycleDetected = hasCycle(vertex,null);
				 
				 if (cycleDetected)
				 {
					 return true;
				 }
			 }
		 }
		 
		 return false;
	 }
	 
	 private boolean hasCycle(Vertex vertex ,Vertex parent)
	 {
			 vertex.setVisited(true);
			 
			 for (Vertex adjVertex : vertex.getAdjacentVertices())
			 {
				 if(!adjVertex.isVisited())
				 {
					  // Recurse on all unvisited adjacent vertices. 
					  if (hasCycle(adjVertex, vertex))
					  {
						  return true;
					  }
				 }
				 else
				 {
					 // If adjacent vertex already visited, it should not be a parent vertex.
					  if (parent != null && !adjVertex.equals(parent))
					  {
						  return true;
					  }
				 }	 
			 }	 
			 return false; 
	 }
	 
	 public  List<LinkedList<Integer>> createLinkedListDepthWise()
	 {
		 resetVisitedStatus();
		 List<LinkedList<Integer>> linkedLists = new ArrayList<>();
		 
		 linkedLists.add(new LinkedList<Integer>());
		 
		 createLinkedListByDepth(getVertices().get(0),linkedLists,0);
		 
		 return linkedLists;
		 
	 }
	 
	 private void createLinkedListByDepth(Vertex vertex,List<LinkedList<Integer>> linkedLists,int depth)
	 {
		
		 if (linkedLists.size() == depth)
		 {
			 linkedLists.add(depth, new LinkedList<Integer>());
		 }
		 
		 
		 linkedLists.get(depth).addEntryToTail(vertex.getId());
		 vertex.setVisited(true);
		 
		 for (Vertex adjVertex : vertex.getAdjacentVertices())
		 {
			 if (!adjVertex.isVisited())
			 {
				 createLinkedListByDepth(adjVertex,linkedLists,depth + 1);
			 }
		 }		 
	 }
	 
	 
	
	 /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int V = vertices.keySet().size();
        
        s.append(V + " vertices, " + E + " edges \n");
        for (int id : vertices.keySet()) {
        	
        	Vertex vertex = vertices.get(id);
        	
            s.append(vertex.getId() + ": ");
            for (Vertex adjacentVertex : vertex.getAdjacentVertices()) {
                s.append(adjacentVertex.getId() + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
	
}