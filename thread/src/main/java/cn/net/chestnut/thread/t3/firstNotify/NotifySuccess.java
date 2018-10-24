package cn.net.chestnut.thread.t3.firstNotify;

public class NotifySuccess {

	private String lock = new String("");
	private boolean isFirstRunB = false;

	private Runnable runnableA = new Runnable() {
		@Override
		public void run() {
			try {
				synchronized (lock) {
					while (isFirstRunB == false) {
						System.out.println("begin wait");
						lock.wait();
						System.out.println("end wait");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	private Runnable runnableB = new Runnable() {
		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("begin notify");
				lock.notify();
				System.out.println("end notify");
				isFirstRunB = true;
			}
		}
	};

	public static void main(String[] args) throws InterruptedException {

		NotifySuccess run = new NotifySuccess();

		Thread a = new Thread(run.runnableA);
		a.start();

		Thread.sleep(100);

		Thread b = new Thread(run.runnableB);
		b.start();

	}

}