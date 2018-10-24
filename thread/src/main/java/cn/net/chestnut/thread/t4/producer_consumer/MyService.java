package cn.net.chestnut.thread.t4.producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean hasValue = false;

	public void set() {
		try {
			lock.lock();
			while (hasValue == true) {
				condition.await();
			}
			System.out.println("打印★");
			hasValue = true;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		try {
			lock.lock();
			while (hasValue == false) {
				condition.await();
			}
			System.out.println("打印☆");
			hasValue = false;
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}