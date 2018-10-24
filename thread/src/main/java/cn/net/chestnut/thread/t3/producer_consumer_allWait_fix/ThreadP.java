package cn.net.chestnut.thread.t3.producer_consumer_allWait_fix;

public class ThreadP extends Thread {

	private P p;

	public ThreadP(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			p.setValue();
		}
	}

}