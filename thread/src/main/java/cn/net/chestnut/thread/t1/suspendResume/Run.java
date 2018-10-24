package cn.net.chestnut.thread.t1.suspendResume;

public class Run {

	public static void main(String[] args) {

		try {
			MyThread thread = new MyThread();
			thread.start();
			Thread.sleep(1000);
			// A
			thread.suspend();
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(1000);
			System.out.println("A= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			// B
			thread.resume();
			Thread.sleep(1000);

			// C
			thread.suspend();
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
			Thread.sleep(1000);
			System.out.println("B= " + System.currentTimeMillis() + " i="
					+ thread.getI());
            thread.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}