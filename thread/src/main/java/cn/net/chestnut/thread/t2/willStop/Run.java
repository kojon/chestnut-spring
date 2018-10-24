package cn.net.chestnut.thread.t2.willStop;

public class Run {

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();

		System.out.println("我要停止它！stopThread="
				+ Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}

}