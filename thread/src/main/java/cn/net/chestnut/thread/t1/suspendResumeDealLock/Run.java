package cn.net.chestnut.thread.t1.suspendResumeDealLock;

public class Run {

	public static void main(String[] args) {
		try {
			final SynchronizedObject object = new SynchronizedObject();

			Thread thread1 = new Thread() {
				@Override
				public void run() {
					object.printString();
				}
			};

			thread1.setName("a");
			thread1.start();

			Thread.sleep(1000);

			Thread thread2 = new Thread() {
				@Override
				public void run() {
					System.out
							.println("thread2启动了，但进入不了printString()方法！");
					System.out
							.println("因为printString()方法被a线程锁定并且永远的suspend暂停了！");
					object.printString();
				}
			};
			thread2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}