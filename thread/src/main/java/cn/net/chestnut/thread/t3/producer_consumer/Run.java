package cn.net.chestnut.thread.t3.producer_consumer;

public class Run {

    public static void main(String[] args) throws InterruptedException{

        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);

        ThreadP pThread = new ThreadP(p);
        ThreadC rThread = new ThreadC(r);

        pThread.start();
        rThread.start();

        Thread.sleep(5);
        pThread.stop();
        rThread.stop();

    }

}