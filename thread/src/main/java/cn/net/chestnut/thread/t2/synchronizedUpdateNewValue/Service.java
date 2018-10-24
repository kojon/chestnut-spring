package cn.net.chestnut.thread.t2.synchronizedUpdateNewValue;

public class Service {

	private boolean isContinueRun = true;

	public void runMethod() {
		String anyString = new String();
		while (isContinueRun == true) {
			//synchronized使isContinueRun变成了线程共享的变量
			synchronized (anyString) {
			}
		}
		System.out.println("停下来了！");
	}

	public void stopMethod() {
		isContinueRun = false;
	}
}