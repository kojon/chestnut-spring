package cn.net.chestnut.thread.t2.twoStop;

public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}

}