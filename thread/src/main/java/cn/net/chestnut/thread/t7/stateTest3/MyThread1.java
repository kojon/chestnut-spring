package cn.net.chestnut.thread.t7.stateTest3;

public class MyThread1 extends Thread {

	@Override
	public void run() {
		MyService.serviceMethod();
	}

}
