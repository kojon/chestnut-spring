package cn.net.chestnut.thread.t4.awaitUninterruptiblyTest_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void testMethod() {
		try {
			lock.lock();
			System.out.println("wait begin");
			condition.awaitUninterruptibly();
			System.out.println("wait   end");
		} finally {
			lock.unlock();
		}

	}
}
