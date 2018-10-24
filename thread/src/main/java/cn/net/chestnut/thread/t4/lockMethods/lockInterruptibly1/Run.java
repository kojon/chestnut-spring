package cn.net.chestnut.thread.t4.lockMethods.lockInterruptibly1;

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
		Thread.sleep(500);
		Thread threadB = new Thread(runnableRef);
		threadB.setName("B");
		threadB.start();
		threadB.interrupt();// 打标记
		System.out.println("main end!");
	}
}