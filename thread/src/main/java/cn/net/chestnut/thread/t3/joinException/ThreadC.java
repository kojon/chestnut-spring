package cn.net.chestnut.thread.t3.joinException;

public class ThreadC extends Thread {

	private ThreadB threadB;

	public ThreadC(ThreadB threadB) {
		super();
		this.threadB = threadB;
	}

	@Override
	public void run() {
		threadB.interrupt();
	}

}