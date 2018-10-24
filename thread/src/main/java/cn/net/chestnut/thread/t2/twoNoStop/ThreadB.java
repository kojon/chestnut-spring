package cn.net.chestnut.thread.t2.twoNoStop;

public class ThreadB extends Thread {

	private Service service;

	public ThreadB(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}

}