package fr.ece.bernoux.Lab2Generics.exBonus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fr.ece.bernoux.Lab2Generics.ex1.Graph;
import fr.ece.bernoux.Lab2Generics.ex5.AbstractWeightedListGraph;

public class DijkstraAlgorithm<V, E> {

	public static <V,E> LinkedList<V> execute(Graph<V> graph, V target) {

		Set<V> settledNodes;
		Set<V> unSettledNodes;
		Map<V, V> predecessors;
		Map<V, Integer> distance;

		settledNodes = new HashSet<V>();
		unSettledNodes = new HashSet<V>();
		distance = new HashMap<V, Integer>();
		predecessors = new HashMap<V, V>();
		distance.put(target, 0);
		unSettledNodes.add(target);
		while (unSettledNodes.size() > 0) {
			V node = getMinimum(distance,unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances((AbstractWeightedListGraph<V,Integer>)graph,settledNodes,unSettledNodes,distance,predecessors,node);
		}
		return  getPath(predecessors,target);
	}


	private static <V> void findMinimalDistances(AbstractWeightedListGraph<V,Integer> graph,Set<V> settledNodes,Set<V> unSettledNodes,Map<V, Integer> distance,Map<V, V> predecessors,V node) {
		List<V> adjacentNodes = getNeighbors(graph,settledNodes,node);
		for (V target : adjacentNodes) {
			if (getShortestDistance(distance,target).doubleValue() > getShortestDistance(distance,node).doubleValue() + getDistance(graph,node, target).doubleValue()) {
				distance.put(target, (int) (getShortestDistance(distance,node).doubleValue() + getDistance(graph,node, target).doubleValue()));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private static <V> Integer getDistance(AbstractWeightedListGraph<V,Integer> graph,V node, V target) {
		for (Entry<AbstractWeightedListGraph<V, ? extends Number>.Tuple, Integer> entry : graph.getEdges().entrySet()) {
			if (entry.getKey().getSource().equals(node) && entry.getKey().getDestination().equals(target)) {
				return entry.getValue();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private static <V,E> List<V> getNeighbors(AbstractWeightedListGraph<V,E> graph,Set<V> settledNodes,V node) {
		List<V> neighbors = new ArrayList<V>();
		for (Entry<AbstractWeightedListGraph<V, E>.Tuple, E> entry : graph.getEdges().entrySet()) {
			if (entry.getKey().getSource().equals(node) && !isSettled(settledNodes,entry.getKey().getDestination())) {
				neighbors.add(entry.getKey().getDestination());
			}
		}
		return neighbors;
	}

	private static <V> V getMinimum(Map<V, Integer> distance,Set<V> unSettledNodes) {
		V minimum = null;
		for (V V : unSettledNodes) {
			if (minimum == null) {
				minimum = V;
			} else {
				if (getShortestDistance(distance,V) < getShortestDistance(distance,minimum)) {
					minimum = V;
				}
			}
		}
		return minimum;
	}

	private static <V> boolean isSettled(Set<V> settledNodes,V V) {
		return settledNodes.contains(V);
	}

	private static <V> Integer getShortestDistance(Map<V, Integer> distance,V destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}
	/*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public static <V> LinkedList<V> getPath(Map<V, V> predecessors,V target) {
            LinkedList<V> path = new LinkedList<V>();
            V step = target;
            // check if a path exists
            if (predecessors.get(step) == null) {
                    return null;
            }
            path.add(step);
            while (predecessors.get(step) != null) {
                    step = predecessors.get(step);
                    path.add(step);
            }
            // Put it into the correct order
            Collections.reverse(path);
            return path;
    }

}
