package cn.net.chestnut.thread.t2.synNotExtends;

public class Sub extends Main {

	@Override
	//这里加上synchronized后，serviceMethod方法会同步执行
    //不加那么就是不同步的，说明子类不会继承synchronized属性
	public void serviceMethod() {
		try {
			System.out.println("int sub 下一步sleep begin threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println("int sub 下一步sleep   end threadName="
					+ Thread.currentThread().getName() + " time="
					+ System.currentTimeMillis());
			super.serviceMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}