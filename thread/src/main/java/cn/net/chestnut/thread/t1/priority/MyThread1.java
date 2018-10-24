package cn.net.chestnut.thread.t1.priority;

import java.util.Random;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread1 run priority=" + this.getPriority());
        long addResult=0;
        long t1=System.currentTimeMillis();
        for (int i=0;i<2000;i++){
            Random random=new Random(addResult+1);
            random.nextInt();
            addResult=addResult+i;
        }
        long t2=System.currentTimeMillis();
        System.out.println("MyThread1执行:"+(t2-t1)+"毫秒");
    }
}