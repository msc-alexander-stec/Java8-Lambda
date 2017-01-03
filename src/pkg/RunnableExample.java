package pkg;

public class RunnableExample {

	public static void main(String[] args) {
		// Alter Weg
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Runnable");
			}
		});
			
		myThread.run();
		
		// Neuer Weg
		Thread myLambdaThread = new Thread(() -> System.out.println("Runnable Lambda"));
		myLambdaThread.run();
	}
}
