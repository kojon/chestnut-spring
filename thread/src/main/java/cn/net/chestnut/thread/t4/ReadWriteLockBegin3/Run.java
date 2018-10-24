package cn.net.chestnut.thread.t4.ReadWriteLockBegin3;

public class Run {

	public static void main(String[] args) throws InterruptedException {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		Thread.sleep(1000);

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

	}

}