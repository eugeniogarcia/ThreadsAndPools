package threadpool.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by rajeevkumarsingh on 10/05/17.
 */
public class FutureCancelExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ExecutorService executorService = Executors.newSingleThreadExecutor();

		final Callable<String> callable = () -> {
			// Perform some computation
			Thread.sleep(2000);
			return "Hello from Callable";
		};

		final long startTime = System.nanoTime();
		final Future<String> future = executorService.submit(callable);

		while(!future.isDone()) {
			System.out.println("Task is still not done...");
			Thread.sleep(200);
			final double elapsedTimeInSec = (System.nanoTime() - startTime) / 1000000000.0;

			if (elapsedTimeInSec > 1) {
				// cancel future if the elapsed time is more than one second
				future.cancel(true);
			}
		}

		// Check if future is cancelled before retrieving the result
		if(!future.isCancelled()) {
			System.out.println("Task completed! Retrieving the result");
			// Future.get() blocks until the result is available
			final String result = future.get();
			System.out.println(result);
		} else {
			System.out.println("Task was cancelled");
		}

		executorService.shutdown();
	}

}
