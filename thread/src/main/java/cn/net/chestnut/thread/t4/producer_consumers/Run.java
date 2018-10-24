package cn.net.chestnut.thread.t4.producer_consumers;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		MyService service = new MyService();

		MyThreadA[] threadA = new MyThreadA[10];
		MyThreadB[] threadB = new MyThreadB[10];

		for (int i = 0; i < 10; i++) {
			threadA[i] = new MyThreadA(service);
			threadB[i] = new MyThreadB(service);
			threadA[i].start();
			threadB[i].start();
		}

	}
}