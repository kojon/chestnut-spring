package cn.net.chestnut.thread.t4.ReentrantLockTest;

public class MyThread extends Thread {

	private MyService service;

	public MyThread(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.testMethod();
	}
}