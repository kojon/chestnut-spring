package cn.net.chestnut.thread.t4.ReadWriteLockBegin2;

public class ThreadA extends Thread {

	private Service service;

	public ThreadA(Service service) {
		super();
		this.service = service;
	}

	@Override
	public void run() {
		service.write();
	}

}