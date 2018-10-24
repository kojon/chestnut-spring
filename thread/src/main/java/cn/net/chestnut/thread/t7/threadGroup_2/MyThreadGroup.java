package cn.net.chestnut.thread.t7.threadGroup_2;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread t,Throwable e) {
		super.uncaughtException(t,e);
		this.interrupt();
	}

}
