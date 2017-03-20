package fr.ece.bernoux.Lab6Lambda.Exercice2;

import java.util.Random;
import java.util.stream.Stream;

/**
 * class to get the average of 1000 ints between 0 and 100
 * 
 * @author Etienne & Nicolas
 *
 */
public class MyRandom {

	public static void main(String[] args) {
		Stream.of(new Random().ints(10000, 1, 100).average().getAsDouble())
				.forEach(System.out::println);
	}

}
