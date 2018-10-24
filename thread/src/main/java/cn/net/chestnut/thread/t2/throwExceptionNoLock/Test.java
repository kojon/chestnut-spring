package cn.net.chestnut.thread.t2.throwExceptionNoLock;

public class Test {

	public static void main(String[] args) {
		try {
			Service service = new Service();

			ThreadA a = new ThreadA(service);
			a.setName("a");
			a.start();

			Thread.sleep(500);

			ThreadB b = new ThreadB(service);
			b.setName("b");
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}