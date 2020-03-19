package edu.nf.ViPoPhone.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public static long getExpDate(int exp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MINUTE, c.get(Calendar.MINUTE+exp));
		
		return c.getTime().getTime();
	}
}
