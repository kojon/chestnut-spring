package cn.net.chestnut.thread.t7.threadGroup_2;

public class MyThread extends Thread {

	private String num;

	public MyThread(ThreadGroup group,String name,String num) {
		super(group,name);
		this.num = num;
	}

	@Override
	public void run() {
		int numInt = Integer.parseInt(num);
		while (this.isInterrupted() == false) {
			System.out.println("死循环中：" + Thread.currentThread().getName());
		}
	}

}
