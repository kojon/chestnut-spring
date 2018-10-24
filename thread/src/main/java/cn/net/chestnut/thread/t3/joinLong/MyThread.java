package cn.net.chestnut.thread.t3.joinLong;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("thread-0 begin Timer=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("thread-0 end Timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}