package cn.net.chestnut.thread.t1.useReturnInterrupt;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();
		t.start();
		Thread.sleep(2000);
		t.interrupt();
	}

}