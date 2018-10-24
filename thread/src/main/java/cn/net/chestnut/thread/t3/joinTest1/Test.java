package cn.net.chestnut.thread.t3.joinTest1;

public class Test {

	public static void main(String[] args) throws InterruptedException{

		MyThread threadTest = new MyThread();
		threadTest.start();
		while (Thread.State.TERMINATED == threadTest.getState()){
			System.out.println("我想当threadTest对象执行完毕后我再执行");
			System.out.println("但上面代码中的sleep()中的值应该写多少呢？");
			System.out.println("答案是：根据不能确定:)");
		}
	}

}