package cn.net.chestnut.thread.t1.example1;

/**
 * @Description
 * @Author tarzan
 * @Date 2018/9/25 下午6:06
 **/
public class MyThread extends Thread{
    private int num=5;

    @Override
    public void run() {
        super.run();
        num--;
        System.out.println("线程："+this.getName()+",num="+num);
    }
}
