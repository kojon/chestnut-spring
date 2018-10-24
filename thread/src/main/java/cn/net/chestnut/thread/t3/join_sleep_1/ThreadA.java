package cn.net.chestnut.thread.t3.join_sleep_1;

public class ThreadA extends Thread {

    private ThreadB b;

    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                Thread.sleep(6000);//sleep()不释放锁！
//				b.join(6000);//释放锁
                System.out.println("a over!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}