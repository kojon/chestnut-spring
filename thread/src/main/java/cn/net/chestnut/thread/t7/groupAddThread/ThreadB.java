package cn.net.chestnut.thread.t7.groupAddThread;

public class ThreadB extends Thread {

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				System.out
						.println("ThreadName=" + 
								Thread.currentThread().
								getName());
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}