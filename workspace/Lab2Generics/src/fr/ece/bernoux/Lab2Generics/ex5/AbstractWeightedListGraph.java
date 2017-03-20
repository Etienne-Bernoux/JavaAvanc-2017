package fr.ece.bernoux.Lab2Generics.ex5;

import java.util.HashMap;
import java.util.Map;

import fr.ece.bernoux.Lab2Generics.ex3.AbstractListGraph;

public abstract class AbstractWeightedListGraph<V, E> extends AbstractListGraph<V> implements WeightedGraph<V, E> {
	private final Map<Tuple, E> edges;

	public AbstractWeightedListGraph() {
		super();
		this.edges = new HashMap<>();
	}

	public boolean addEdge(V fromVertex, V toVertex, E edge) {
		if (!this.addEdge(fromVertex, toVertex)) {
			return false;
		}
		this.addEdgeUndirected(fromVertex, toVertex, edge);

		return (this.edges.putIfAbsent(new Tuple(fromVertex, toVertex), edge) == null);

	}

	public boolean addEdgeUndirected(V fromVertex, V toVertex, E edge) {
		return true;
	}

	public Map<Tuple, E> getEdges() {
		return edges;
	}

	@Override
	protected String edgeString(V fromVertex, V toVertex) {
		StringBuilder edge = new StringBuilder();
		Tuple tuple = new Tuple(fromVertex, toVertex);
		edge.append("\t" + fromVertex + " " + this.getEdgeType() + " " + toVertex);
		for (Map.Entry<Tuple, E> entry : this.edges.entrySet()) {
			// The equals method need to be override
			if (entry.getKey().equals(tuple)) {
				edge.append(" [label=" + entry.getValue() + "]");
			}
		}
		edge.append(";\n");

		return edge.toString();

	}

	public class Tuple {
		private final V source;
		private final V destination;

		public Tuple(V source, V destination) {
			super();
			this.source = source;
			this.destination = destination;
		}

		public V getSource() {
			return source;
		}

		public V getDestination() {
			return destination;
		}

		@Override
		public String toString() {
			return "Tuple [source=" + source + ", destination=" + destination + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			// If they does not have the same class, it will return false
			if (getClass() != obj.getClass())
				return false;
			@SuppressWarnings("unchecked")
			Tuple other = (Tuple) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (destination == null) {
				if (other.destination != null)
					return false;
			} else if (!destination.equals(other.destination))
				return false;
			if (source == null) {
				if (other.source != null)
					return false;
			} else if (!source.equals(other.source))
				return false;
			return true;
		}

		private AbstractWeightedListGraph<V, E> getOuterType() {
			return AbstractWeightedListGraph.this;
		}

	}

}
