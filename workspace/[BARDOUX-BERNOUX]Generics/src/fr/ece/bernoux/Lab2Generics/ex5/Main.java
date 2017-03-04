package fr.ece.bernoux.Lab2Generics.ex5;

import fr.ece.bernoux.Lab2Generics.ex2.DepthFirstSearch;

public class Main {

	public static void main(String[] args) {
		DirectedWeightedListGraph<String, Integer> myDirectedWeightedGraph = new DirectedWeightedListGraph<>();
		myDirectedWeightedGraph.addVertex("A");
		myDirectedWeightedGraph.addVertex("B");
		myDirectedWeightedGraph.addVertex("C");
		myDirectedWeightedGraph.addVertex("D");
		myDirectedWeightedGraph.addEdge("B", "C", 5);
		myDirectedWeightedGraph.addEdge("C", "E", 8);
		myDirectedWeightedGraph.addEdge("E", "A", 6);
		myDirectedWeightedGraph.addEdge("E", "D", 4);
		myDirectedWeightedGraph.addEdge("A", "B", 9);
		myDirectedWeightedGraph.addEdge("A", "F", 3);

		// System.out.println(mygraph.getChildren(myGraph));
		System.out.println(myDirectedWeightedGraph.toString());
		System.out.println(DepthFirstSearch.execute(myDirectedWeightedGraph, "E").toString());
		
		
		UndirectedWeightedListGraph<String, Integer> myUnDirectedWeightedListGraph = new UndirectedWeightedListGraph<>();
		myUnDirectedWeightedListGraph.addVertex("A");
		myUnDirectedWeightedListGraph.addVertex("B");
		myUnDirectedWeightedListGraph.addVertex("C");
		myUnDirectedWeightedListGraph.addVertex("D");
		myUnDirectedWeightedListGraph.addEdge("B", "C", 5);
		myUnDirectedWeightedListGraph.addEdge("C", "E", 8);
		myUnDirectedWeightedListGraph.addEdge("E", "A", 6);
		myUnDirectedWeightedListGraph.addEdge("E", "D", 4);
		myUnDirectedWeightedListGraph.addEdge("E", "G", 12);
		myUnDirectedWeightedListGraph.addEdge("A", "B", 9);
		myUnDirectedWeightedListGraph.addEdge("A", "F", 3);

		// System.out.println(mygraph.getChildren(myGraph));
		System.out.println(myUnDirectedWeightedListGraph.toString());
		System.out.println(DepthFirstSearch.execute(myUnDirectedWeightedListGraph, "E").toString());

	}

}
