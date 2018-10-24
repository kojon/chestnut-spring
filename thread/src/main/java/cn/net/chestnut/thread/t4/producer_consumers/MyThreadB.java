package cn.net.chestnut.thread.t4.producer_consumers;

public class MyThreadB extends Thread {

    private MyService myService;

    public MyThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.get();
        }
    }

}