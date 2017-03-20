package fr.ece.bernoux.Lab6Lambda.Exercice2;

import java.util.Random;
import java.util.stream.Stream;

public class MyRandom {

	public static void main(String[] args) {
    System.out.println(Stream.of(new Random().ints(1000,0,100).average()));

	 

	}

}
