package com.gensoft.order.util;

import java.util.Random;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:05 2019/6/11
 */
public class KeyUtil {
	/**
	 * 生成唯一主键
	 * 时间戳+随机数
	 */
	public static synchronized String genUniqueKey(){
		Random random = new Random();
		Integer number = random.nextInt(900000)+100000;
		return System.currentTimeMillis()+String.valueOf(number);
	}
}
