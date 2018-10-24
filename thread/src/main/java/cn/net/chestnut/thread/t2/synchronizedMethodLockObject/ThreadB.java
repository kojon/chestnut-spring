package cn.net.chestnut.thread.t2.synchronizedMethodLockObject;

public class ThreadB extends Thread {

	private MyObject object;

	public ThreadB(MyObject object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		object.methodA();
	}
}