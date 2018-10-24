package cn.net.chestnut.thread.t3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedReader;

public class ReadData {

	public void readMethod(PipedReader input) {
		try {
			System.out.println("read  :");
			char[] byteArray = new char[20];
			int readLength = input.read(byteArray);
			while (readLength != -1) {
				String newData = new String(byteArray,0,readLength);
				System.out.print(newData);
				readLength = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}