package cn.net.chestnut.thread.t7.threadExceptionMove;

public class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t,Throwable e) {
		System.out.println("静态的异常处理");
		e.printStackTrace();
	}

}
