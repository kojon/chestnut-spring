package cn.net.chestnut.thread.t2.syncBlockList;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyOneList list = new MyOneList();

		MyThread1 thread1 = new MyThread1(list);
		thread1.setName("A");
		thread1.start();

		MyThread2 thread2 = new MyThread2(list);
		thread2.setName("B");
		thread2.start();
		
		Thread.sleep(6000);
		
		System.out.println("listSize=" + list.getSize());

	}

}