package fr.ece.bernoux.Lab6Lambda.Exercice1;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Lambda {

	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("Hello World");
		}).start();
		
		TreeSet<String> treeset = new TreeSet<>((s1,s2) -> s1.compareTo(s2));
		treeset.add("toto");
			
		//Apply<String, String>
		Comparator<String> choucroute = (s1,s2) -> s1.compareTo(s2);
		
		TreeSet<String> treeset2 = new TreeSet<>(choucroute);
		treeset2 = (TreeSet<String>) Stream.of("toto","titi").sorted(choucroute);
		
		
		
		for (String string : treeset) {
			System.out.println(string);
		}
		
	}
	

}