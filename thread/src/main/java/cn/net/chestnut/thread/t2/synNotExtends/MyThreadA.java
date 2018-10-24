package cn.net.chestnut.thread.t2.synNotExtends;

public class MyThreadA extends Thread {

	private Sub sub;

	public MyThreadA(Sub sub) {
		super();
		this.sub = sub;
	}

	@Override
	public void run() {
		sub.serviceMethod();
	}

}