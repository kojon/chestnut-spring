package cn.net.chestnut.thread.t1.priority;

public class Run {

    public static void main(String[] args) {
        System.out.println("main thread begin priority="
                           + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(1);
        System.out.println("main thread end   priority="
                           + Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        MyThread2 thread2 = new MyThread2();
        thread2.setPriority(10);
        thread2.start();
    }
}