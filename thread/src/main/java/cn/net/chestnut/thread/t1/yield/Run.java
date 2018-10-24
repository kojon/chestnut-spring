package cn.net.chestnut.thread.t1.yield;

public class Run {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
	}

}