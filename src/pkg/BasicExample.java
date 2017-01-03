package pkg;

public class BasicExample {

	public static void main(String[] args) {
		
		// Alter Weg: Anonyme Innere Klasse
		MyPrintLambda innerClass = new MyPrintLambda() {
			
			@Override
			public void print() {
				System.out.println("HelloWorld");
			}
		};
		
		innerClass.print();
		
		// Neuer Weg: Lambda Funktion
		MyPrintLambda myLambdaFunction = () -> System.out.println("HelloWorld");
		myLambdaFunction.print();
		
		MyAddLambda myAddFunction = (int x, int y) -> x + y;
		System.out.println("2 + 5 = " + myAddFunction.add(2, 5));
	}
	
	@FunctionalInterface
	interface MyPrintLambda { // Interface Name spielt gar keine Rolle
		
		// Muss die gleiche Signatur haben wie die zu verwendete Lambda Funktion
		// Name der Funktion hier spielt auch keine Rolle
		// Es darf in diesem Interface nur eine Funktion geben
		void print();
	}
	
	@FunctionalInterface
	interface MyAddLambda {
		int add(int x, int y);
	}

}