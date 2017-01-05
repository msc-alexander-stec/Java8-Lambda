package pkg;

import java.util.Arrays;
import java.util.List;

public class CollectionsLoop {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Mathew", "Arnold", 39)
				);
	
		System.out.println();
		System.out.println("Using for loop");
		for (int i = 0; i < personList.size(); i++) {
			System.out.println(personList.get(i));
		}
		
		System.out.println();
		System.out.println("Using for-in loop");
		for (Person p: personList) {
			System.out.println(p);
		}
		
		System.out.println();
		System.out.println("Using Lambda for-each loop from Java 8");
		personList.forEach(p -> System.out.println(p));
		personList.forEach(System.out::println); // Alternative
	}
}
