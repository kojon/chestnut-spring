package cn.net.chestnut.thread.t7.threadExceptionMove;

public class MyThread extends Thread {

	private String num = "a";

	public MyThread() {
		super();
	}

	public MyThread(ThreadGroup group,String name) {
		super(group,name);
	}

	@Override
	public void run() {
		int numInt = Integer.parseInt(num);
		System.out.println("在线程中打印：" + (numInt + 1));
	}

}
