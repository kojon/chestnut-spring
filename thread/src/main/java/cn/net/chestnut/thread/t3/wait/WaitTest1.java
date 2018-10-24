package cn.net.chestnut.thread.t3.wait;

public class WaitTest1 {
	public static void main(String[] args) {
		try {
			String newString = new String("");
			newString.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}