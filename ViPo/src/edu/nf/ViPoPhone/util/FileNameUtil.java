package edu.nf.ViPoPhone.util;

public class FileNameUtil {

	public static String newFileName(String filename) {
		StringBuilder builder=new StringBuilder();
		//先获取旧文件的后缀名
		String[] pattern=filename.split("\\.");
		String extName=pattern[pattern.length-1];
		builder.append(System.currentTimeMillis());
		builder.append(".");
		builder.append(extName);
		return builder.toString();
	}
}
