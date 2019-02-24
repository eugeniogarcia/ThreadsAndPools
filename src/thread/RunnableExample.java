package thread;

public class RunnableExample implements Runnable {

	public static void main(String[] args) {
		System.out.println("Inside : " + Thread.currentThread().getName());

		System.out.println("Creating Runnable...");
		final Runnable runnable = new RunnableExample();

		System.out.println("Creating Thread...");
		final Thread thread = new Thread(runnable);

		System.out.println("Starting Thread...");
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("Inside : " + Thread.currentThread().getName());
	}
}
