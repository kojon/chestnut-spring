package cn.net.chestnut.thread.t4.awaitUntilTest;

public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.start();

        Thread.sleep(2000);
        //通过线程B提前唤醒线程A
        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.start();
    }

}