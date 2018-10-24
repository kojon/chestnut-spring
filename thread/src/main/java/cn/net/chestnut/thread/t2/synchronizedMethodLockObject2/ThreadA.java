package cn.net.chestnut.thread.t2.synchronizedMethodLockObject2;

public class ThreadA extends Thread {

	private MyObject object;

	public ThreadA(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}

}