package cn.net.chestnut.thread.t5.timerTest5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;
import java.text.ParseException;
public class Run4 {

	private static Timer timer = new Timer();
	private static int runCount = 0;

	static public class MyTask1 extends TimerTask {
		@Override
		public void run() {
			try {
				System.out.println("1 begin 运行了！时间为：" + new Date());
				Thread.sleep(5000);
				System.out.println("1   end 运行了！时间为：" + new Date());
				runCount++;
				if (runCount == 5) {
					timer.cancel();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			MyTask1 task1 = new MyTask1();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString1 = "2014-10-12 15:33:00";
			Date dateRef1 = sdf1.parse(dateString1);
			System.out.println("字符串1时间：" + dateRef1.toLocaleString() + " 当前时间："
					+ new Date().toLocaleString());
			timer.scheduleAtFixedRate(task1,dateRef1,2000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}