package cn.net.chestnut.c01;

import cn.net.chestnut.thread.t1.example1.MyRunnable;
import cn.net.chestnut.thread.t1.example1.MyThread;
import cn.net.chestnut.thread.t1.example1.SyncThread;
import org.junit.Test;

/**
 * @Description
 * @Author tarzan
 * @Date 2018/9/25 下午6:30
 **/
public class Mytest {
    @Test
    public void threadTest(){
        Thread thread=new MyThread();
        thread.start();
    }

    @Test
    public void runnableTest(){
        MyRunnable runnable=new MyRunnable();
        runnable.run();

        Thread thread=new Thread(runnable);
        thread.start();
    }

    @Test
    public void notSafe(){
        Thread myThread=new MyThread();
        Thread a=new Thread(myThread,"A");
        Thread b=new Thread(myThread,"B");
        Thread c=new Thread(myThread,"C");
        Thread d=new Thread(myThread,"D");
        Thread e=new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    @Test
    public void isSafe(){
        Thread myThread=new SyncThread();
        Thread a=new Thread(myThread,"A");
        Thread b=new Thread(myThread,"B");
        Thread c=new Thread(myThread,"C");
        Thread d=new Thread(myThread,"D");
        Thread e=new Thread(myThread,"E");
        System.out.println(a.getName());
        a.start();
        b.start();
        c.start();
        d.start();
        System.out.println("before:"+e.isAlive());
        e.start();
        System.out.println(myThread.currentThread().getName());
        System.out.println("after:"+e.isAlive());
    }

}
