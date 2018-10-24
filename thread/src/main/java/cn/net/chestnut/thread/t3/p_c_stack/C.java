package cn.net.chestnut.thread.t3.p_c_stack;

public class C {

	private MyStack myStack;

	public C(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	public void popService() {
		System.out.println("pop=" + myStack.pop());
	}
}