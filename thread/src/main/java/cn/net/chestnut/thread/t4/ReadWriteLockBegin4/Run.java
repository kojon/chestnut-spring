package cn.net.chestnut.thread.t4.ReadWriteLockBegin4;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		Service service = new Service();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		Thread.sleep(1000);

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

	}

}