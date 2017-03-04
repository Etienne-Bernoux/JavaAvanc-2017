package fr.ece.bernoux.Lab2Generics.ex1;

import java.util.Map;
import java.util.Set;

public interface Graph<V> {
	/**
	 * Add a edge is the graph
	 * 
	 * @param fromVertex
	 * @param toVertex
	 * @return
	 */
	boolean addEdge(V fromVertex, V toVertex);

	/**
	 * Add a node in the graph
	 * 
	 * @param vertex
	 * @return
	 */
	boolean addVertex(V vertex);

	/**
	 * Add a set of vertex to the graph. We need to use wildcard to add subclass
	 * of V because UndirectedListGraph<Word> does not extend
	 * UndirectedListGraph<ColoredWord>
	 * 
	 * @param vertices
	 * @return
	 */
	Set<? extends V> addVertices(Set<? extends V> vertices);

	/**
	 * Get the children of vertex
	 * 
	 * @param vertex
	 * @return
	 */
	Set<V> getChildren(V vertex);

	// To have the good tostring value
	String getDOTClass();

	String getEdgeType();

	/**
	 * Get all unique agencies for one Map
	 * 
	 * @return
	 */
	public Map<V, Set<V>> getUniqueAdjacencies();

}
