package cn.net.chestnut.thread.t2.willNotStop;

public class Run {

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		printStringService.printStringMethod();
		System.out.println("我要停止它！stopThread="
				+ Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}

}