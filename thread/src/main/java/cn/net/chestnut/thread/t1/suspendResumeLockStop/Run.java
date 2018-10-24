package cn.net.chestnut.thread.t1.suspendResumeLockStop;

import java.util.logging.Logger;

public class Run {

	public static void main(String[] args) {

		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			thread.suspend();
			Logger.getLogger("Run").info("线程依旧执行，但是下面的println方法就不能运行");
			Logger.getLogger("Run").info("因为线程不同步了");
			System.out.println("main end!");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}