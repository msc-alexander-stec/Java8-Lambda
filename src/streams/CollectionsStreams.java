package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
		.forEach(p -> System.out.println(p.getFirstName())); // Lewis, Thomas
		
		System.out.println("Count last name starts with C");
		long count = personList.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.count(); // 2
		
		System.out.println("\nAge > 46");
		
		List<String> personOver46List = 
			personList.stream()
			.filter(p -> p.getAge() > 46)
			.map(Person::getFirstName)
			.map(String::toUpperCase)
			.collect(Collectors.toList());
		
		System.out.println(personOver46List);
		
		// http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
		
		//
		// Different kind of streams
		//
		
		Arrays.asList("a1", "a2", "a3")
	    .stream()
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		Stream.of("a1", "a2", "a3")
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		IntStream.range(1, 4)
	    .forEach(System.out::println);
		
		// 1
		// 2
		// 3
		
		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);  // 5.0
		
		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);  // 3
		
		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		// a1
		// a2
		// a3
		
		Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
		// a1
		// a2
		// a3
		
		//
		// Processing Order
		//
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
		// filter:  d2
		// forEach: d2
		// filter:  a2
		// forEach: a2
		// filter:  b1
		// forEach: b1
		// filter:  b3
		// forEach: b3
		// filter:  c
		// forEach: c
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .anyMatch(s -> {
	        System.out.println("anyMatch: " + s);
	        return s.startsWith("A");
	    });
		
		// map:      d2
		// anyMatch: D2
		// map:      a2
		// anyMatch: A2
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		// map:     d2
		// filter:  D2
		// map:     a2
		// filter:  A2
		// forEach: A2
		// map:     b1
		// filter:  B1
		// map:     b3
		// filter:  B3
		// map:     c
		// filter:  C
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		// filter:  d2
		// filter:  a2
		// map:     a2
		// forEach: A2
		// filter:  b1
		// filter:  b3
		// filter:  c
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		// filter:  d2
		// filter:  a2
		// filter:  b1
		// filter:  b3
		// filter:  c
		// map:     a2
		// forEach: A2
		
		//
		// Reusing Streams
		//
		
		// TODO
		
		//
		// Advanced Operations
		//
		
		List<Person> filtered =
			    personList
			        .stream()
			        .filter(p -> p.getFirstName().startsWith("M"))
			        .collect(Collectors.toList());

		System.out.println(filtered);    // [Peter, Pamela]
			
	}	

}
