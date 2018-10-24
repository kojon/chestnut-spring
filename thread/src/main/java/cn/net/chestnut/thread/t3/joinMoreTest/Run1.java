package cn.net.chestnut.thread.t3.joinMoreTest;

public class Run1 {

    public static void main(String[] args) {
    try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            //因为线程a调用b后，这里的start和join会同时竞争b的锁
            b.start();
            b.join(1000);//如果join竞争到了，发现时间已过 下面的代码就提前运行。需要测试多次才能发现
            System.out.println("                    main end "
                               + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}