package cn.net.chestnut.thread.t3.InheritableThreadLocal1;

public class Run {

	public static void main(String[] args) {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("       在Main线程中取值=" + Tools.tl.get());
				Thread.sleep(100);
			}
			Thread.sleep(5000);
			ThreadA a = new ThreadA();
			a.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}