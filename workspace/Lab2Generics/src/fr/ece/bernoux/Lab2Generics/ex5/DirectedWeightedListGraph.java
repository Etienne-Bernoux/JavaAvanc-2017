package fr.ece.bernoux.Lab2Generics.ex5;

public class DirectedWeightedListGraph<V, E> extends AbstractWeightedListGraph<V, E> {

	public DirectedWeightedListGraph() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDOTClass() {
		return "diweigraph";
	}

	@Override
	public String getEdgeType() {
		return "->";
	}

}
