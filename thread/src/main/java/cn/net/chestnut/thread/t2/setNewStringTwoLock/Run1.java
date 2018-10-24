package cn.net.chestnut.thread.t2.setNewStringTwoLock;

public class Run1 {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");

		ThreadB b = new ThreadB(service);
		b.setName("B");

		//锁对象被改变了，所以是异步的。
		a.start();
		Thread.sleep(50);// 存在50毫秒
		b.start();
	}
}