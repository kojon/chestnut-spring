package cn.net.chestnut.thread.t3.wait_notify_insert_test;

public class BackupB extends Thread {

	private DBTools dbtools;

	public BackupB(DBTools dbtools) {
		super();
		this.dbtools = dbtools;
	}

	@Override
	public void run() {
		dbtools.backupB();
	}

}
