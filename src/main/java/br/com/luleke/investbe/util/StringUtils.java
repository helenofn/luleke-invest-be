package br.com.luleke.investbe.util;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return null == str || "".equalsIgnoreCase(str) || str.length() == 0;
	}
}
