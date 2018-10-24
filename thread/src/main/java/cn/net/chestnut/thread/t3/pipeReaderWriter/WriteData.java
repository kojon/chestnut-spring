package cn.net.chestnut.thread.t3.pipeReaderWriter;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteData {

	public void writeMethod(PipedWriter out) {
		try {
			System.out.println("write :");
			for (int i = 0; i < 300; i++) {
				String outData = "" + (i + 1);
				out.write(outData);
//				System.out.print(outData);
			}
			System.out.println("write,over!");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}