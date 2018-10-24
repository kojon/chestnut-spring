package cn.net.chestnut.thread.t4.ConditionTestMoreMethod;

public class ThreadB extends Thread {

	private MyService service;

	public ThreadB(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodB();
	}
}