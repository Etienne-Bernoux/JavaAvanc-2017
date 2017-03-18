package fr.ece.bernoux.Lab6Lambda.Exercice1;

import java.util.Comparator;

public abstract class Apply<A extends String,B extends String> implements Comparator<A>{
	
	public void apply(A a, B b) {
		 a.compareTo(b);
	}
}
