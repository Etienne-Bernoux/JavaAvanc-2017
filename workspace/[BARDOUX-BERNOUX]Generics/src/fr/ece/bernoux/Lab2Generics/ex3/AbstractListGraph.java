package fr.ece.bernoux.Lab2Generics.ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ece.bernoux.Lab2Generics.ex1.Graph;

public abstract class AbstractListGraph<V> implements Graph<V> {
	private Map<V, Set<V>> list;

	public AbstractListGraph() {
		// HashMap is a good choice because he has the ability to save a key and
		// a Set of V.
		this.list = new HashMap<>();
	}

	@Override
	public boolean addEdge(V fromVertex, V toVertex) {
		// Get all the children of from vertex, null if not
		Set<V> children = this.getChildren(fromVertex);
		if (children == null) {
			// If not, we need to create a new hashset to save the list of
			// children
			children = new HashSet<>();
		}
		// If the children already contain toVertex, you have nothing to do and
		// you can leave the function
		else if (children.contains(toVertex)) {
			return false;
		}
		// to vertex is add in the set of children
		children.add(toVertex);
		// I hadVertex in my graph if not already exist
		this.addVertex(toVertex);
		// We replace fromVertex with the new list of children
		this.getList().put(fromVertex, children);

		addEdgeUndirected(fromVertex, toVertex);
		return true;
	}

	/**
	 * This method have effect for Undirected list only
	 * 
	 * @param fromVertex
	 * @param toVertex
	 * @return
	 */
	public boolean addEdgeUndirected(V fromVertex, V toVertex) {
		return true;

	}

	@Override
	public boolean addVertex(V vertex) {
		if (this.list.putIfAbsent(vertex, new HashSet<>()) == null) {
			return true;
		}
		return false;
	}

	@Override
	public Set<? extends V> addVertices(Set<? extends V> vertices) {
		// A set to keep the non add vertex
		HashSet<V> notAddSet = new HashSet<>();
		// We iterate the Set
		for (V vertex : vertices) {
			// If the vertex is not had, we add it to the notAddSet
			if (!addVertex(vertex)) {
				notAddSet.add(vertex);
			}
		}
		return notAddSet;

	}

	@Override
	public Set<V> getChildren(V vertex) {
		return this.list.get(vertex);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getList() == null) ? 0 : this.getList().hashCode());
		return result;
	}

	public Map<V, Set<V>> getList() {
		return list;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		StringBuilder node = new StringBuilder();
		StringBuilder edge = new StringBuilder();
		if (this.getList().isEmpty()) {
			return result.toString();
		}
		result.append(this.getDOTClass() + " G{\n");

		Map<V, Set<V>> uniqueAdjacencies = getUniqueAdjacencies();
		for (Map.Entry<V, Set<V>> entry : uniqueAdjacencies.entrySet()) {
			node.append("\tnode [label = " + entry.getKey() + "]" + entry.hashCode() + ";\n");
			for (V value : entry.getValue()) {
				edge.append(this.edgeString(entry.getKey(), value));
			}
		}
		result.append(node.toString());
		result.append(edge.toString());
		result.append("}\n");

		return result.toString();
	}

	protected String edgeString(V fromVertex, V toVertex) {
		return ("\t" + fromVertex + " " + this.getEdgeType() + " " + toVertex + ";\n");

	}

	public Map<V, Set<V>> getUniqueAdjacencies() {
		return this.getList();
	}

}
