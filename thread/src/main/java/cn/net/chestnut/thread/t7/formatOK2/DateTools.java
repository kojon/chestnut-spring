package cn.net.chestnut.thread.t7.formatOK2;

import java.text.SimpleDateFormat;

public class DateTools {

	private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

	public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
		SimpleDateFormat sdf = null;
		sdf = tl.get();
		if (sdf == null) {
			sdf = new SimpleDateFormat(datePattern);
			tl.set(sdf);
		}
		return sdf;
	}

}