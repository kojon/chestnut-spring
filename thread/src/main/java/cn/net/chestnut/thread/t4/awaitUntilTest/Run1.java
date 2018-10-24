package cn.net.chestnut.thread.t4.awaitUntilTest;

public class Run1 {

	public static void main(String[] args) throws InterruptedException {
		Service service = new Service();
		MyThreadA myThreadA = new MyThreadA(service);
		myThreadA.start();
	}

}
