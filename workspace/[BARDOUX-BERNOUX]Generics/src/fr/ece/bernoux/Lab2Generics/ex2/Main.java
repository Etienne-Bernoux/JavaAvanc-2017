package fr.ece.bernoux.Lab2Generics.ex2;

import fr.ece.bernoux.Lab2Generics.ex1.DirectedListGraph;
import fr.ece.bernoux.Lab2Generics.ex3.UndirectedListGraph;

public class Main {

	public static void main(String[] args) {
		DirectedListGraph<String> myDirectedGraph = new DirectedListGraph<>();
		myDirectedGraph.addVertex("A");
		myDirectedGraph.addVertex("B");
		myDirectedGraph.addVertex("C");
		myDirectedGraph.addVertex("D");
		myDirectedGraph.addEdge("B", "C");
		myDirectedGraph.addEdge("C", "E");
		myDirectedGraph.addEdge("E", "A");
		myDirectedGraph.addEdge("E", "D");
		myDirectedGraph.addEdge("A", "B");
		myDirectedGraph.addEdge("A", "F");

		// System.out.println(mygraph.getChildren(myGraph));
		System.out.println(myDirectedGraph.toString());
		System.out.println(DepthFirstSearch.execute(myDirectedGraph, "E").toString());

		UndirectedListGraph<String> myGraph = new UndirectedListGraph<>();
		myGraph.addVertex("A");
		myGraph.addVertex("B");
		myGraph.addVertex("C");
		myGraph.addVertex("D");
		myGraph.addEdge("B", "C");
		myGraph.addEdge("C", "E");
		myGraph.addEdge("E", "A");
		myGraph.addEdge("E", "D");
		myGraph.addEdge("A", "B");
		myGraph.addEdge("A", "F");

		// System.out.println(mygraph.getChildren(myGraph));
		System.out.println(myGraph.toString());
		System.out.println(DepthFirstSearch.execute(myGraph, "E").toString());

	}

}
