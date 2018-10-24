package cn.net.chestnut.thread.t1.sleep;

public class Run2 {
	public static void main(String[] args) {
		MyThread2 mythread = new MyThread2();
		System.out.println("begin =" + System.currentTimeMillis());
		mythread.start();
		System.out.println("end   =" + System.currentTimeMillis());
	}
}