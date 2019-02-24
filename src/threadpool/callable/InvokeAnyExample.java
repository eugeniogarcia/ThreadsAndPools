package threadpool.callable;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by rajeevkumarsingh on 10/05/17.
 */
public class InvokeAnyExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final ExecutorService executorService = Executors.newFixedThreadPool(5);

		final Callable<String> task1 = () -> {
			Thread.sleep(2000);
			return "Result of Task1";
		};

		final Callable<String> task2 = () -> {
			Thread.sleep(1000);
			return "Result of Task2";
		};

		final Callable<String> task3 = () -> {
			Thread.sleep(5000);
			return "Result of Task3";
		};

		// Returns the result of the fastest callable. (task2 in this case)
		final String result = executorService.invokeAny(Arrays.asList(task1, task2, task3));

		System.out.println(result);

		executorService.shutdown();
	}
}
