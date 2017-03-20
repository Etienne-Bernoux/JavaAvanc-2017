package fr.ece.bernoux.Lab2Generics.exBonus;

import fr.ece.bernoux.Lab2Generics.ex2.DepthFirstSearch;
import fr.ece.bernoux.Lab2Generics.ex5.DirectedWeightedListGraph;

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
		System.out.println(DijkstraAlgorithm.execute(myDirectedWeightedGraph, "D"));

	}

}
