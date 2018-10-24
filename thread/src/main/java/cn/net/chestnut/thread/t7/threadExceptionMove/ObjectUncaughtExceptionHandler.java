package cn.net.chestnut.thread.t7.threadExceptionMove;

public class ObjectUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t,Throwable e) {
		System.out.println("对象的异常处理");
		e.printStackTrace();
	}

}
