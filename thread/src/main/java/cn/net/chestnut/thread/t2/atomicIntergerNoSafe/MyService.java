package cn.net.chestnut.thread.t2.atomicIntergerNoSafe;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

	public static AtomicLong aiRef = new AtomicLong();
	//addNum是非线程同步的，虽然aiRef是原子性的但是并不表示执行过程是同步的。
	//加上synchronized后 线程就是同步的 顺序就是累加的。
	public void addNum() {
		System.out.println(Thread.currentThread().getName() + "加了100之后的值是:"
				+ aiRef.addAndGet(100));
		aiRef.addAndGet(1);
	}

}