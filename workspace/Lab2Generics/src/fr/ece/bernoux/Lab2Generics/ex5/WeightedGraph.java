package fr.ece.bernoux.Lab2Generics.ex5;

import fr.ece.bernoux.Lab2Generics.ex1.Graph;

public interface WeightedGraph<V, E> extends Graph<V> {

	boolean addEdge(V fromVertex, V toVertex, E edge);

}
