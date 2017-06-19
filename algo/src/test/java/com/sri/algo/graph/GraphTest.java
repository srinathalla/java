package com.sri.algo.graph;

import java.io.FileNotFoundException;
import org.fest.assertions.api.Assertions;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import org.junit.Test;

import junit.framework.Assert;

public class GraphTest 
{
	
	// Base folder for all the test folders.
	private static final Path BASE_TEST_FOLDER = Paths.get(
			System.getProperty("user.dir"),
			"src/test/resources/graph");
	
	@Test
	public void constructGraph() throws FileNotFoundException
	{
		// Tiny graph.
		Path tiny = BASE_TEST_FOLDER.resolve("undirected").resolve("tiny.txt");
		
		Graph tinyGraph = createGraph(tiny);
		
		Assert.assertTrue(tinyGraph.getVertices().keySet().size() == 13);
		Assert.assertTrue(tinyGraph.getE() == 13);
		
		
		// Medium graph.
		Path medium =  BASE_TEST_FOLDER.resolve("undirected").resolve("medium.txt");
		
		Graph mediumGraph = createGraph(medium);
		
		Assert.assertTrue(mediumGraph.getVertices().keySet().size() == 250);
		Assert.assertTrue(mediumGraph.getE() == 1273);

	}
	
	@Test
	public void hasCycle() throws FileNotFoundException
	{
		// Tiny graph.
		Path tiny = BASE_TEST_FOLDER.resolve("undirected").resolve("tiny.txt");
		
		Graph tinyGraph = createGraph(tiny);
		
		// There is cycle.
		Assert.assertTrue(tinyGraph.hasCycle());	
		
	
		Path tiny1 =  BASE_TEST_FOLDER.resolve("undirected").resolve("cycle").resolve("withcycle.txt");	
		Graph tiny1Graph = createGraph(tiny1);
		
		// There is cycle.
		Assert.assertTrue(tiny1Graph.hasCycle());	
		
		Path tiny2 =  BASE_TEST_FOLDER.resolve("undirected").resolve("cycle").resolve("nocycle.txt");	
		Graph tiny2Graph = createGraph(tiny2);
		
		// There is no cycle.
		Assert.assertFalse(tiny2Graph.hasCycle());

	}
	
	@Test
	public void createLinkedListDepthWiseShouldWork()
	{
		
		Graph graph = new Graph(6);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		
		Assertions.assertThat(graph.createLinkedListDepthWise()).isNotEmpty();
		
		Assertions.assertThat(graph.createLinkedListDepthWise()).hasSize(3);
			
	}
	

	
	private Graph createGraph(Path path) throws FileNotFoundException
	{
		Graph graph = null;
		try (Scanner in = new Scanner(path.toFile())) 
		{
			int V = in.nextInt();
			
			graph = new Graph(V);
			int E = in.nextInt();
			
			for (int i = 0 ; i < E ; i++)
			{
				String edge = in.nextLine();
				while (edge.isEmpty())
				{
					edge = in.nextLine();
				}
				
				String[] fromTo = edge.split(" ");
				
				graph.addEdge(
					Integer.valueOf(fromTo[0]), 
					Integer.valueOf(fromTo[1]));
			}
			
			System.out.println(graph);
		}
		
		return graph;
	}

}
