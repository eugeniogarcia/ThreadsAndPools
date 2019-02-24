package threadpool.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rajeevkumarsingh on 11/05/17.
 */
public class FutureAndCallableExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ExecutorService executorService = Executors.newSingleThreadExecutor();

		final Callable<String> callable = () -> {
			// Perform some computation
			System.out.println("Entered Callable");
			Thread.sleep(2000);
			return "Hello from Callable";
		};

		System.out.println("Submitting Callable");	
		final Future<String> future = executorService.submit(callable);
		// This line executes immediately
		System.out.println("Do something else while callable is getting executed");

		System.out.println("Retrieve the result of the future");
		// Future.get() blocks until the result is available
		final String result = future.get();
		System.out.println(result);

		executorService.shutdown();
	}
}
