package com.sri.algo.graph;

import org.junit.Test;

import java.util.Arrays;

import org.fest.assertions.api.Assertions;

public class DiGraphTest {
	
	
	@Test
	public void topologicalSortShouldWork()
	{
		// Create a graph given in the above diagram
	    DiGraph tog = new DiGraph(6);
	    tog.addEdge(5, 2);
	    tog.addEdge(5, 0);
	    tog.addEdge(4, 0);
	    tog.addEdge(4, 1);
	    tog.addEdge(2, 3);
	    tog.addEdge(3, 1);

	    Assertions.assertThat(tog.topologicalSort()).isNotEmpty();
	    Assertions.assertThat(tog.topologicalSort()).
	    	isEqualTo(
    			Arrays.asList(
					new Vertex(5),
					new Vertex(4),
					new Vertex(2),
					new Vertex(3),
					new Vertex(1),
					new Vertex(0)));
	}
		
	
	@Test
	public void hasCycleShouldWork()
	{
		DiGraph diGraph = new DiGraph(3);
		
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		diGraph.addEdge(2, 0);
		Assertions.assertThat(diGraph.hasCycle()).isTrue();
	
		diGraph.addEdge(0, 2);
		diGraph.addEdge(2, 3);
		Assertions.assertThat(diGraph.hasCycle()).isTrue();
		
		diGraph.removeAllEdges();
		
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		Assertions.assertThat(diGraph.hasCycle()).isFalse();
	}
	
	@Test
	public void hasRouteShouldWork()
	{
		DiGraph diGraph = new DiGraph(4);
		
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		
		Assertions.assertThat(diGraph.hasRoute(0, 2)).isTrue();
		
		Assertions.assertThat(diGraph.hasRoute(0, 3)).isFalse();
		
	}

}
