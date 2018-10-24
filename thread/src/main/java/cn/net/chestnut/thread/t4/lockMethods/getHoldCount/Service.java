package cn.net.chestnut.thread.t4.lockMethods.getHoldCount;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

	private ReentrantLock lock = new ReentrantLock();

	public void serviceMethod1() {
		try {
			lock.lock();
			System.out.println("serviceMethod1 getHoldCount="
					+ lock.getHoldCount());
			serviceMethod2();
		} finally {
			lock.unlock();
		}
	}

	public void serviceMethod2() {
		try {
			lock.lock();
			lock.lock();
			lock.lock();
			System.out.println("serviceMethod2 getHoldCount="
					+ lock.getHoldCount());
		} finally {
			lock.unlock();
		}
	}

}