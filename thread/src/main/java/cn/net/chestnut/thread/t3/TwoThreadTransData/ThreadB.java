package cn.net.chestnut.thread.t3.TwoThreadTransData;

public class ThreadB extends Thread {

	private MyList list;

	public ThreadB(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("线程b监控到list长度："+list.size());
				if (list.size() == 5) {
					System.out.println("==5了，线程b要退出了！");
					throw new InterruptedException();
				}
                Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}