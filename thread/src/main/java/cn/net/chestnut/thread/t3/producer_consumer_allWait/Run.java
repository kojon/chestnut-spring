package cn.net.chestnut.thread.t3.producer_consumer_allWait;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        String lock = new String("");
        P p = new P(lock);
        C r = new C(lock);

        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] rThread = new ThreadC[2];

        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadP(p);
            pThread[i].setName("生产者" + (i + 1));

            rThread[i] = new ThreadC(r);
            rThread[i].setName("消费者" + (i + 1));

            pThread[i].start();
            rThread[i].start();
        }

        Thread.sleep(5000);
        //初始化一个当前激活的线程数量的线程数组
        Thread[] threadArray = new Thread[Thread.currentThread()
                                                .getThreadGroup().activeCount()];
        //讲当前线程复制到线程组
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        //遍历当前线程状态
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " "
                               + threadArray[i].getState());
        }
    }

}