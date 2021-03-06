package com.fangdd.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	public static String getContent(String dir, String fileName) {

		return changeInputStream(FileUtil.class.getClassLoader()
				.getResourceAsStream(dir + "/" + fileName));
	}

	public static String getContent(String dir, String fileName, String charset) {

		return changeInputStream(FileUtil.class.getClassLoader()
				.getResourceAsStream(dir + "/" + fileName), charset);
	}

	public static String toString(InputStream is, String charset) {
		try {
			if (is == null)
				logger.error("InputStream may not be null");

			if (charset == null)
				charset = "ISO-8859-1";

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, charset));
			StringBuffer tmp = new StringBuffer();
			String content = "";

			while ((content = reader.readLine()) != null) {
				tmp.append(content.trim());
				tmp.append("\r\n");
			}
			reader.close();
			return tmp.toString();
		} catch (Exception e) {
			logger.error(e);
		}
		return null;
	}

	public static String toString(InputStream is) {
		return toString(is, null);
	}

	/**
	 * 将一个输入流转换成指定编码的字符串
	 * 
	 * @param inputStream
	 * @return
	 */
	private static String changeInputStream(InputStream inputStream,
			String charset) {
		String jsonString = "";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int len = 0;
		byte[] data = new byte[1024];
		try {
			while ((len = inputStream.read(data)) != -1) {
				outputStream.write(data, 0, len);
			}
			jsonString = new String(outputStream.toByteArray(), charset);
		} catch (Exception e) {
			logger.error(e);
		}
		return jsonString;
	}

	/**
	 * 将一个输入流转换成指定编码的字符串
	 * 
	 * @param inputStream
	 * @return
	 */
	private static String changeInputStream(InputStream inputStream) {
		String jsonString = "";
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int len = 0;
		byte[] data = new byte[1024];
		try {
			while ((len = inputStream.read(data)) != -1) {
				outputStream.write(data, 0, len);
			}
			jsonString = new String(outputStream.toByteArray());
		} catch (Exception e) {
			logger.error(e);
		}
		return jsonString;
	}
}
