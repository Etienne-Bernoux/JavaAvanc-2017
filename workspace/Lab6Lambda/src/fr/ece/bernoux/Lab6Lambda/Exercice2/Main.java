package fr.ece.bernoux.Lab6Lambda.Exercice2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Etienne & Nicolas
 */
public class Main {

	public static void main(String[] args) {
		// the map we get from the stream with all the teachers, grouped by
		// their gender
		Map<Gender, List<Teacher>> myMap = Stream
				.of(new Teacher("Ravaut", Gender.MALE),
						new Teacher("Soukane", Gender.FEMALE),
						new Teacher("Palasi", Gender.FEMALE),
						new Teacher("Segado", Gender.MALE),
						new Teacher("Diedler", Gender.MALE))
				.collect(Collectors.groupingBy(Teacher::getGender));

		// we want to print each one of them
		Stream.of(myMap).forEach(t -> System.out.println(t.toString()));
	}
}
