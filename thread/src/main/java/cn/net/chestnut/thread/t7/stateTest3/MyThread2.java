package cn.net.chestnut.thread.t7.stateTest3;

public class MyThread2 extends Thread {

	@Override
	public void run() {
		MyService.serviceMethod();
	}

}
