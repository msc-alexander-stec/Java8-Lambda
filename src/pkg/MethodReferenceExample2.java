package pkg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import pkg.CollectionsInJava8.Condition;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Mathew", "Arnold", 39)
				);

		System.out.println("Printing all Persons");
		performConditionally(personList, (p) -> true, (p) -> System.out.println(p));
		
		// Alternative
		performConditionally(personList, (p) -> true, System.out::println);
	}
	
	// With existing Java Function Interfaces
	private static void performConditionally(List<Person> personList, Predicate<Person> predicate,  Consumer<Person> consumer) {
		for(Person p: personList) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
	
}
