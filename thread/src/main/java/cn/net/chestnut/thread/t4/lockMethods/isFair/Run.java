package cn.net.chestnut.thread.t4.lockMethods.isFair;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		final Service service1 = new Service(true);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				service1.serviceMethod();
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();

		final Service service2 = new Service(false);
		runnable = new Runnable() {
			@Override
			public void run() {
				service2.serviceMethod();
			}
		};
		thread = new Thread(runnable);
		thread.start();

	}
}