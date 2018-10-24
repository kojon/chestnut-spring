package cn.net.chestnut.thread.t2.synBlockString;

public class ThreadA extends Thread {
	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.setUsernamePassword("a", "aa");

	}

}