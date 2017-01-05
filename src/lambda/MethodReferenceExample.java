package lambda;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		Runnable runnable = () -> printMessage();
		Thread thread = new Thread(runnable);
		thread.start();
		
		// Method Reference (Only if there are nor Arguments!)
		Thread thread2 = new Thread(MethodReferenceExample::printMessage);
		thread2.start();
	}
	
	public static void printMessage() {
		System.out.println("HelloWorld");
	}

}
