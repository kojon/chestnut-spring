package cn.net.chestnut.thread.t7.threadCreateException;

public class MyThread extends Thread {
	@Override
	public void run() {
		String username = null;
		System.out.println(username.hashCode());
	}

}
