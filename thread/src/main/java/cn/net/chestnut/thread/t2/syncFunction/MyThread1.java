package cn.net.chestnut.thread.t2.syncFunction;

public class MyThread1 extends Thread {

	private Task task;

	public MyThread1(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		super.run();
		CommonUtils.beginTime1 = System.currentTimeMillis();
		task.doLongTimeTask();
		CommonUtils.endTime1 = System.currentTimeMillis();
	}

}