package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lambda.Person;

public class CollectionsStreams {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Brante", 45),
				new Person("Mathew", "Arnold", 39)
				);
	
		System.out.println("Print persons with Last name starts with C");
		personList.stream()
		.filter(p -> p.getLastName().startsWith("C")) // Reduziert the Menge. Elemente die true sind kommen zum naechsten Schritt
		.forEach(p -> System.out.println(p.getFirstName()));
		
		System.out.println("Count last name starts with C");
		long count = personList.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.count();
		System.out.println(count);	
	}

}
