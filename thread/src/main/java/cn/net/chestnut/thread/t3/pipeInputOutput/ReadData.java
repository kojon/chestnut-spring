package cn.net.chestnut.thread.t3.pipeInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

	public void readMethod(PipedInputStream input) {
		try {
			System.out.println("read  :");
			byte[] byteArray = new byte[20];
			int readLength = input.read(byteArray);
			//线程开始时处于等待写入状态，当管道中有数据时才输出。
			while (readLength != -1) {
				String newData = new String(byteArray,0,readLength);
				System.out.print(newData+",");
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}