package lambda;

public class TypeInterfaceExample {

	public static void main(String[] args) {
		StringLengthLambda stringLength = (s) -> s.length();
		System.out.println(stringLength.stringLength("Hello World"));
		
		// Alternativ: Lambda Funktion direkt übergeben
		printLambda(s -> s.length());
	}
	
	public static void printLambda(StringLengthLambda stringLength) {
		System.out.println(stringLength.stringLength("Hello World"));
	}
	
	@FunctionalInterface
	interface StringLengthLambda {
		int stringLength(String s);
	}

}
