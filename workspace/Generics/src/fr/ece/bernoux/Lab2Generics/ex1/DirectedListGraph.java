package fr.ece.bernoux.Lab2Generics.ex1;

import fr.ece.bernoux.Lab2Generics.ex3.AbstractListGraph;

/**
 * 
 * @author etienne and nicolas
 *
 * @param <V>
 */
public class DirectedListGraph<V> extends AbstractListGraph<V> {
	// HashMap is a good choice because he has the ability to save a key and
	// a Set of V.

	public DirectedListGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedListGraph<String> mygraph = new DirectedListGraph<>();
		mygraph.addVertex("A");
		mygraph.addVertex("B");
		mygraph.addVertex("C");
		mygraph.addVertex("D");
		mygraph.addEdge("B", "C");
		mygraph.addEdge("C", "E");

		// System.out.println(mygraph.getChildren(mygraph));
		System.out.println(mygraph.toString());

	}

	@Override
	public String getDOTClass() {
		return "digraph";
	}

	@Override
	public String getEdgeType() {
		return "->";
	}

}
