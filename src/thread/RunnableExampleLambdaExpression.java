package thread;
/**
 * Created by rajeevkumarsingh on 08/05/17.
 */
public class RunnableExampleLambdaExpression {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

		System.out.println("Creating Runnable...");
		final Runnable runnable = () -> {
			System.out.println("Inside : " + Thread.currentThread().getName());
		};

		System.out.println("Creating Thread...");
		final Thread thread = new Thread(runnable);

		System.out.println("Starting Thread...");
		thread.start();

	}
}
