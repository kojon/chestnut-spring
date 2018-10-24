package cn.net.chestnut.thread.t1.daemonThread;

public class Run {
	public static void main(String[] args) {
		try {
			MyThread thread = new MyThread();
			thread.setDaemon(true);
			thread.start();
			Thread.sleep(5000);
			System.out.println("main方法结束，thread守护线程也就停止了！");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}