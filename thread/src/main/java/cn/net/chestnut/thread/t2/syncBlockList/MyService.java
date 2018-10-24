package cn.net.chestnut.thread.t2.syncBlockList;

public class MyService {

	public MyOneList addServiceMethod(MyOneList list, String data) {
        try {
            //如果list不是synchronized同步的，那么add就会被AB两个线程同时调用，出现size等于2的情况
            synchronized (list) {
                if (list.getSize() < 1) {
                    Thread.sleep(2000);
                    list.add(data);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
	}

}