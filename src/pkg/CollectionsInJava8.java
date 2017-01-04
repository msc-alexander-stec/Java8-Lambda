package pkg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
		Comparator<Person> comparator = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
		Collections.sort(personList, comparator);
		
		// Step 2: Create a method that prints all elements in the list
		printAll(personList);
		System.out.println();
		
		// Step 3: Create a method that prints all persons that have last name beginning with C
		Condition condition = (p) -> p.getLastName().startsWith("C");
		printLastNameConditionally(personList, condition);
		
		System.out.println();
		
		// Alternative: Using existing Functional Interface from Java 8
		// See: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
		Predicate<Person> predicate = (p) -> p.getLastName().startsWith("C");
		printLastNameConditionally2(personList, predicate);
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
	
	// With existing Java Function Interfaces
	private static void printLastNameConditionally2(List<Person> personList, Predicate<Person> predicate) {
		for(Person p: personList) {
			if (predicate.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	@FunctionalInterface
	interface Condition {
		boolean test(Person p);
	}

}
