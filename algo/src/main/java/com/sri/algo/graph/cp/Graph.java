package com.sri.algo.graph.cp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sri.algo.graph.Vertex;

public class Graph {
	
	private int V;   // No. of vertices
	private int E;   // No. of edges.
	 
    // Array  of lists for Adjacency List Representation
    private List<LinkedList<Integer>> adj;
 
    // Constructor
    public Graph(int v,int E)
    {
        V = v;
        adj = new ArrayList<LinkedList<Integer>>();
        for (int i=0; i<v; ++i)
        {
        	adj.add(new LinkedList<Integer>());
        }
        
    }
 
    public List<LinkedList<Integer>> getAdj() {
		return adj;
	}
    
    public LinkedList<Integer>[] getAdjacencyListAsArray() {
    	LinkedList<Integer>[] adjArr = new LinkedList[adj.size()];
    	
    	for (int index = 0 ; index < adj.size() ; index ++)
    	{
    		adjArr[index] = adj.get(index);
    	}
    	
    	return adjArr;
	}
    
    public ArrayList<Integer>[] getAdjacencyListAsArrayOfArrayList() {
    	ArrayList<Integer>[] adjArr = new ArrayList[adj.size()];
    	
    	for (int index = 0 ; index < adj.size() ; index ++)
    	{
    		ArrayList<Integer> adjListAsArrayList  = new ArrayList<>();
    		LinkedList<Integer> ll = adj.get(index);
    		
    		Iterator<Integer> iter = ll.iterator();
    		
    		while(iter.hasNext())
    		{
    			adjListAsArrayList.add(iter.next());
    		}
    		 
    		 adjArr[index] = adjListAsArrayList;
    	}
    	
    	return adjArr;
	}

	//Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj.get(v).add(w); 
        
        adj.get(w).add(v); // Add w to v's list.    
        
    }
    
   
 
 
    public static void main(String args[])
    {
    	DiGraph g = new DiGraph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
    }

	public int getV() {
		return V;
	}

}
