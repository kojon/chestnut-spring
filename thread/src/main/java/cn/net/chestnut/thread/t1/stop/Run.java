package cn.net.chestnut.thread.t1.stop;

public class Run {

    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
            //线程调用stop()时，隐式抛出ThreadDeath异常
            Thread.currentThread().stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ThreadDeath e) {
            e.printStackTrace();
        }
    }

}