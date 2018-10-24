package cn.net.chestnut.thread.t1.interrupted;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 500000; i++) {
			if (this.interrupted()) {
				System.out.println("已经是停止状态了!我要退出for循环了!");
				break;
			}
			System.out.println("i=" + (i + 1));
		}
		System.out.println("线程并未退出");
	}
}