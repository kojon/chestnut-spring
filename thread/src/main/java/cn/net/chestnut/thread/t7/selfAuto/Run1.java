package cn.net.chestnut.thread.t7.selfAuto;

public class Run1 {

	public static void main(String[] args) {
		try {
			SelfRun autoRun = new SelfRun();
			Thread.sleep(5000);
			autoRun.stopRun();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
