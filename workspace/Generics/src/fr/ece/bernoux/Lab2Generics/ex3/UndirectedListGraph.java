package fr.ece.bernoux.Lab2Generics.ex3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * @author etienne and nicolas
 *
 * @param <V>
 */
public class UndirectedListGraph<V> extends AbstractListGraph<V> {

	public UndirectedListGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addEdgeUndirected(V fromVertex, V toVertex) {
		return this.addEdge(toVertex, fromVertex);// If the graph is undirected,
													// the direction need to be
													// set both side
	}

	@Override
	public String getDOTClass() {
		return "graph";
	}

	@Override
	public String getEdgeType() {
		return "--";
	}

	@Override

	public Map<V, Set<V>> getUniqueAdjacencies() {
		// We create a new HashMap generate the unique adjacencies map distinct
		// from our original graph
		Map<V, Set<V>> uniqueAdjacencies = new HashMap<>();
		// We iterate for each entry of the map
		for (Entry<V, Set<V>> entry : this.getList().entrySet()) {
			// We create a new set of children and we add it to this entry Set
			HashSet<V> children = new HashSet<>();
			uniqueAdjacencies.put(entry.getKey(), children);
			// We iterate for each value of this entry
			for (V value : entry.getValue()) {
				// If the value/key link already exist, we do not add the
				// key/value link
				if (!uniqueAdjacencies.containsKey(value) && !uniqueAdjacencies.containsValue(entry.getKey())) {
					children.add(value);
				}
			}
		}
		return uniqueAdjacencies;
	}

}
