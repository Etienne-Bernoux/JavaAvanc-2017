package fr.ece.bernoux.Lab2Generics.ex2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import fr.ece.bernoux.Lab2Generics.ex1.Graph;

public class DepthFirstSearch {
	// We don't parameterize the class but we can parameterize the method with
	// genetics
	// We use static method to be able to call them without instantiate the
	// class
	public static <V> List<V> execute(Graph<V> graph, V vertex) {
		// The list of our result
		ArrayList<V> result = new ArrayList<>();
		// The set of marked node
		HashSet<V> marked = new HashSet<>();
		// We execute the recursive method to fill the list with child of vertex
		executeRec(result, marked, graph, vertex);
		return result;

	}

	private static <V> void executeRec(ArrayList<V> list, HashSet<V> marked, Graph<V> graph, V vertex) {
		if (!marked.contains(vertex)) {
			// We add in marked and had vertex
			marked.add(vertex);
			list.add(vertex);
			// For each child we execute the recursive method to fill the list
			// with child of vertex
			for (V child : graph.getChildren(vertex)) {
				executeRec(list, marked, graph, child);
			}
		}
		return;
	}

}
