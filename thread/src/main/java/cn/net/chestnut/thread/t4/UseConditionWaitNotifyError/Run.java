package cn.net.chestnut.thread.t4.UseConditionWaitNotifyError;

public class Run {

    public static void main(String[] args) {

        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.start();

    }

}