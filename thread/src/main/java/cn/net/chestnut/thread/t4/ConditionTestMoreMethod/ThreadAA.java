package cn.net.chestnut.thread.t4.ConditionTestMoreMethod;

public class ThreadAA extends Thread {

	private MyService service;

	public ThreadAA(MyService service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.methodA();
	}
}