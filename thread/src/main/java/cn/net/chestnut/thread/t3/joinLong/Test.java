package cn.net.chestnut.thread.t3.joinLong;

public class Test {

	public static void main(String[] args) {
		try {
			MyThread threadTest = new MyThread();
			threadTest.start();

			 threadTest.join(2000);// 只等2秒
//			Thread.sleep(2000);

			System.out.println("thread-main  end timer=" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
