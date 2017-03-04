package fr.ece.bernoux.Lab2Generics.ex4;

import java.util.HashSet;

import fr.ece.bernoux.Lab2Generics.ex2.DepthFirstSearch;
import fr.ece.bernoux.Lab2Generics.ex3.UndirectedListGraph;

public class Main {

	public static void main(String[] args) {
		ColoredWord A = new ColoredWord("A", ColoredWord.Color.BLUE);
		ColoredWord B = new ColoredWord("B", ColoredWord.Color.GREEN);
		ColoredWord C1 = new ColoredWord("C", ColoredWord.Color.GREEN);
		Word C = new Word("C");
		ColoredWord D1 = new ColoredWord("D", ColoredWord.Color.RED);
		Word D = new Word("D");
		ColoredWord E = new ColoredWord("E", ColoredWord.Color.TURQUOISE);
		ColoredWord F = new ColoredWord("F", ColoredWord.Color.YELLOW);

		HashSet<Word> mySet = new HashSet<>();
		mySet.add(C);
		mySet.add(D);

		HashSet<ColoredWord> myColoredSet = new HashSet<>();
		myColoredSet.add(A);
		myColoredSet.add(B);
		myColoredSet.add(C1);
		myColoredSet.add(D1);

		UndirectedListGraph<Word> myUnDirectedListGraph = new UndirectedListGraph<>();
		myUnDirectedListGraph.addVertex(A);
		System.out.println(myUnDirectedListGraph.addVertices(mySet).toString());
		System.out.println(myUnDirectedListGraph.addVertices(myColoredSet).toString());
		myUnDirectedListGraph.addEdge(B, C1);
		myUnDirectedListGraph.addEdge(C, E);
		myUnDirectedListGraph.addEdge(E, A);
		myUnDirectedListGraph.addEdge(E, D);
		myUnDirectedListGraph.addEdge(A, B);
		myUnDirectedListGraph.addEdge(A, F);

		// System.out.println(mygraph.getChildren(myGraph));
		System.out.println(myUnDirectedListGraph.toString());
		System.out.println(DepthFirstSearch.execute(myUnDirectedListGraph, E).toString());

	}

}
