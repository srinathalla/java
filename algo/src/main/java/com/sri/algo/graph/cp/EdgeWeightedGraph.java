package com.sri.algo.graph.cp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph  {
	
	private int V;   // No. of vertices
	private int E;   // No. of edges.
	 
    // Array  of lists for Adjacency List Representation
    private List<LinkedList<Edge>> adj;
 
    // Constructor
    public EdgeWeightedGraph(int v,int E)
    {
        V = v;
        adj = new ArrayList<LinkedList<Edge>>();
        for (int i=0; i<v; ++i)
        {
        	adj.add(new LinkedList<Edge>());
        }
        
    }
    
    public EdgeWeightedGraph(int v)
    {
    	this(v,0);
    }
 
    public List<LinkedList<Edge>> getAdj() {
		return adj;
	}
    
    public LinkedList<Edge>[] getAdjacencyListAsArray() {
    	LinkedList<Edge>[] adjArr = new LinkedList[adj.size()];
    	
    	for (int index = 0 ; index < adj.size() ; index ++)
    	{
    		adjArr[index] = adj.get(index);
    	}
    	
    	return adjArr;
	}
    
    public ArrayList<Edge>[] getAdjacencyListAsArrayOfArrayList() {
    	ArrayList<Edge>[] adjArr = new ArrayList[adj.size()];
    	
    	for (int index = 0 ; index < adj.size() ; index ++)
    	{
    		ArrayList<Edge> adjListAsArrayList  = new ArrayList<>();
    		LinkedList<Edge> ll = adj.get(index);
    		
    		Iterator<Edge> iter = ll.iterator();
    		
    		while(iter.hasNext())
    		{
    			adjListAsArrayList.add(iter.next());
    		}
    		 
    		 adjArr[index] = adjListAsArrayList;
    	}
    	
    	return adjArr;
	}

	//Function to add an edge into the graph
    public void addEdge(int from, int to,int wt)
    {
   
    	E++;
        adj.get(from).add(new Edge(from ,to, wt)); 
        
        adj.get(to).add(new Edge(to ,from, wt));     
        
    }
    
    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append(V + " vertices, " + E + " edges \n");
        for (int id =0; id < V ; id++) {
        	
            s.append(id + ": ");
            Iterator<Edge> ll = adj.get(id).iterator();
            
            while(ll.hasNext())
            {
            	 Edge edge = ll.next();
            	 s.append(edge.to +"(" + edge.wt + ")");
            	 if(ll.hasNext())
            	 {
            		 s.append(",");
            	 }
            	
            }
            s.append("\n");
        }
        return s.toString();
    }
 
 
    public static void main(String args[])
    {
    	EdgeWeightedGraph g = new EdgeWeightedGraph(5);
 
        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 4, 5);
        g.addEdge(3, 4, 9);
 
        System.out.println("Grapgh : " + g.toString());
    }

	public int getV() {
		return V;
	}

}
