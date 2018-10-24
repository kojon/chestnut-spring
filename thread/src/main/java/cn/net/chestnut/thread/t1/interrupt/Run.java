package cn.net.chestnut.thread.t1.interrupt;

public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.interrupt();
			//Thread.currentThread().interrupt();
			System.out.println("是否停止1？="+thread.interrupted());
			System.out.println("是否停止2？="+thread.interrupted());
		} catch (InterruptedException e) {
			System.out.println("main catch");
			e.printStackTrace();
		}
		System.out.println("end!");
	}
}