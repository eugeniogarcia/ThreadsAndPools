package thread;
/**
 * Created by rajeevkumarsingh on 08/05/17.
 */
public class ThreadSleepExample {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

		final String[] messages = {"If I can stop one heart from breaking,",
				"I shall not live in vain.",
				"If I can ease one life the aching,",
				"Or cool one pain,",
				"Or help one fainting robin",
				"Unto his nest again,",
		"I shall not live in vain"};

		final Runnable runnable = () -> {
			System.out.println("Inside : " + Thread.currentThread().getName());

			for(final String message: messages) {
				System.out.println(message);
				try {
					Thread.sleep(2000);
				} catch (final InterruptedException e) {
					throw new IllegalStateException(e);
				}
			}
		};

		final Thread thread = new Thread(runnable);

		thread.start();
	}
}
