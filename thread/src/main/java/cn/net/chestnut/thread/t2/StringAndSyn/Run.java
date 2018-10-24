package cn.net.chestnut.thread.t2.StringAndSyn;

public class Run {

	public static void main(String[] args) {

		Service service = new Service();

		ThreadA a = new ThreadA(service);
		a.setName("A");
		a.start();

		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();

		String s1 = "a";
		String s2 = "a";
		System.out.println(s1 == s2);
	}

}