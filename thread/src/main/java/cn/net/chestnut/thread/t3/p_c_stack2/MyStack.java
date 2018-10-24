package cn.net.chestnut.thread.t3.p_c_stack2;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List list = new ArrayList();

	synchronized public void push() {
		try {
			if (list.size() == 1) {
				this.wait();
			}
			list.add("anyString=" + Math.random());
			this.notify();
			System.out.println("push=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized public String pop() {
		String returnValue = "";
		try {
			//此处使用if由于有多消费者消费，wait状态会被唤醒，执行remove就会抛出下标越界。
			//此处应该使用while。
			if (list.size() == 0) {
				System.out.println("pop操作中的："
						+ Thread.currentThread().getName() + " 线程呈wait状态");
				this.wait();
			}
			returnValue = "" + list.get(0);
			list.remove(0);
			this.notify();
			System.out.println("pop=" + list.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}