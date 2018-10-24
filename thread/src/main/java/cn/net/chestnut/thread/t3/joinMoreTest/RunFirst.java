package cn.net.chestnut.thread.t3.joinMoreTest;

public class RunFirst {
	//这里main是异步的 所以先执行
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		ThreadA a = new ThreadA(b);
		a.start();
		b.start();
		System.out.println("   main end=" + System.currentTimeMillis());
	}

}