package cn.net.chestnut.thread.t1.suspend_resume_nosameValue;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		final MyObject myobject = new MyObject();

		Thread thread1 = new Thread() {
			public void run() {
				myobject.setValue("a", "aa");
			};
		};
		thread1.setName("a");
		thread1.start();

		Thread.sleep(500);

		Thread thread2 = new Thread() {
			public void run() {
				myobject.printUsernamePassword();
			};
		};
		thread2.start();

	}

}