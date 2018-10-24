package cn.net.chestnut.thread.t3.ThreadLocal;

public class Run {
	public static ThreadLocal tl = new ThreadLocal();

	public static void main(String[] args) {
		if (tl.get() == null) {
			System.out.println("从未放过值");
			tl.set("我的值");
		}
		System.out.println(tl.get());
		System.out.println(tl.get());
	}

}