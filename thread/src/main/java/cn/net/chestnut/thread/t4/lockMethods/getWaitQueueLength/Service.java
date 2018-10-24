package cn.net.chestnut.thread.t4.lockMethods.getWaitQueueLength;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

	private ReentrantLock lock = new ReentrantLock();
	private Condition newCondition = lock.newCondition();

	public void waitMethod() {
		try {
			lock.lock();
			newCondition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void notityMethod() {
		try {
			lock.lock();
			System.out.println("有" + lock.getWaitQueueLength(newCondition)
					+ "个线程正在等待newCondition");
			newCondition.signal();
		} finally {
			lock.unlock();
		}
	}

}