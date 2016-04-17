package com.fangdd.utils;

import java.lang.Character.UnicodeBlock;

public class StringUtil {

	/**
	 * 判断输入的字符串参数是否为空或者是"null"字符。
	 * 
	 * @param args
	 *            输入的字串
	 * 
	 * @return 输入的字符串为空或者是"null"字符则返回true,反之则返回false
	 */
	public static boolean validateNull(String args) {
		if (args == null || args.length() == 0 || args.equalsIgnoreCase("null")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 对输入为空或者是"null"字符的字符串参数进行处理。
	 * 
	 * @param source
	 *            源字符串
	 * @param target
	 *            目标字符串
	 * 
	 * @return 输入的字符串为空或者是"null"字符则返回目标字符串，反之则返回源字符串
	 */
	public static String chanageNull(String source, String target) {
		if (source == null || source.length() == 0
				|| source.equalsIgnoreCase("null")) {
			return target;
		} else {
			return source;
		}
	}

	/**
	 * 根据号段phonePrefix与num生成11位手机号
	 * 
	 * @param phonePrefix
	 *            号段
	 * @param num
	 *            号码
	 * @return
	 */
	public static final String bulidPhoneNum(String phonePrefix, int num) {
		String phoneNum = String.format("%1$s%2$04d", new Object[] {
				phonePrefix, num });
		return phoneNum;
	}

	/**
	 * 过滤<, >,\n等特殊字符的方法。
	 * 
	 * @param input
	 *            需要过滤的字符
	 * @return 完成过滤以后的字符串
	 */
	public static final String filterStr(String str) {
		str = str.replaceAll(";", "");
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("'", "");
		str = str.replaceAll("--", " ");
		str = str.replaceAll("/", "");
		str = str.replaceAll("%", "");
		str = str.replaceAll(" ", "&nbsp;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\n", "<br>");
		str = str.replaceAll("\r", "<br>");
		return str;
	}

	public static String utf8ToUnicode(String inStr) {
		char[] myBuffer = inStr.toCharArray();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inStr.length(); i++) {
			UnicodeBlock ub = UnicodeBlock.of(myBuffer[i]);
			if (ub == UnicodeBlock.BASIC_LATIN) {
				// 英文及数字等
				sb.append(myBuffer[i]);
			} else if (ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				// 全角半角字符
				int j = (int) myBuffer[i] - 65248;
				sb.append((char) j);
			} else {
				// 汉字
				short s = (short) myBuffer[i];
				String hexS = Integer.toHexString(s);
				String unicode = "\\u" + hexS;
				sb.append(unicode.toLowerCase());
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(bulidPhoneNum("1681234", 789));
	}
}
