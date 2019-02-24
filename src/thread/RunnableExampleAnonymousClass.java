package thread;
/**
 * Created by rajeevkumarsingh on 08/05/17.
 */
public class RunnableExampleAnonymousClass {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

		System.out.println("Creating Runnable...");

		final Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside : " + Thread.currentThread().getName());
			}
		};

		System.out.println("Creating Thread...");
		final Thread thread = new Thread(runnable);

		System.out.println("Starting Thread...");
		thread.start();
	}
}