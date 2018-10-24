package cn.net.chestnut.thread.t3.waitHasParamMethod;

public class MyRunnable {
	static private Object lock = new Object();
	static private Runnable runnable1 = new Runnable() {
		@Override
		public void run() {
			try {
				synchronized (lock) {
					System.out.println("wait begin timer="
							+ System.currentTimeMillis());
					lock.wait(5000);
					System.out.println("wait   end timer="
							+ System.currentTimeMillis());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	static private Runnable runnable2 = new Runnable() {
		@Override
		public void run() {
			synchronized (lock) {
				System.out.println("notify begin timer="
						+ System.currentTimeMillis());
				lock.notify();
				System.out.println("notify   end timer="
						+ System.currentTimeMillis());
			}
		}
	};

	public static void main(String[] args) throws InterruptedException{
//		test1();
		test2(Thread.currentThread());
	}

	private static void test1(){
		//t1等待5000ms后自动唤醒
		Thread t1 = new Thread(runnable1);
		t1.start();
	}

	private static void test2(Thread thread) throws InterruptedException{
		Thread t1 = new Thread(runnable1);
		t1.start();
		thread.sleep(1000);//这里主线程休眠1000ms后t2开始唤醒t1
		Thread t2 = new Thread(runnable2);
		t2.start();
	}

}