package pkg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsInJava8 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Mathew", "Arnold", 39)
				);

		// Step 1: Sort list by last name
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// Step 2: Create a method that prints all elements in the list
		printAll(personList);
		System.out.println();
		
		// Step 3: Create a method that prints all persons that habe last name beginning with C
		printLastNameConditionally(personList, (p) -> p.getLastName().startsWith("C"));
		
	}

	private static void printAll(List<Person> personList) {
		for(Person p: personList) {
			System.out.println(p);
		}	
	}
	
	private static void printLastNameConditionally(List<Person> personList, Condition condition) {
		for(Person p: personList) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	interface Condition {
		boolean test(Person p);
	}

}
