package cn.net.chestnut.thread.t4.lockMethods.lockInterruptiblyTest2;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		final MyService service = new MyService();
		Runnable runnableRef = new Runnable() {
			@Override
			public void run() {
				service.waitMethod();
			}
		};

		Thread threadA = new Thread(runnableRef);
		threadA.setName("A");
		threadA.start();
		//试试打开下面的代码，就更快明白lockInterruptibly的特点了。
//		threadA.interrupt();
		Thread.sleep(500);
		Thread threadB = new Thread(runnableRef);
		threadB.setName("B");
		threadB.start();
		threadB.interrupt();
	}
}
