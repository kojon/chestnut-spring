package cn.net.chestnut.thread.t4.ConditionTestMoreMethod;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadAA aa = new ThreadAA(service);
		aa.setName("AA");
		aa.start();

		Thread.sleep(100);

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
		
		ThreadBB bb = new ThreadBB(service);
		bb.setName("BB");
		bb.start();

	}

}