package cn.net.chestnut.thread.t2.syncBlockList;

public class MyThread1 extends Thread {

	private MyOneList list;

	public MyThread1(MyOneList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		MyService msRef = new MyService();
		msRef.addServiceMethod(list, "A");
	}

}