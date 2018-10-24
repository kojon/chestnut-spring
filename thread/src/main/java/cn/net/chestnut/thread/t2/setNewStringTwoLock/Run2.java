package cn.net.chestnut.thread.t2.setNewStringTwoLock;

public class Run2 {

	public static void main(String[] args) throws InterruptedException {

		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");

		ThreadB b = new ThreadB(service);
		b.setName("B");

		//两线程同时竞争同一个锁，同步执行
		a.start();
		b.start();
	}
}