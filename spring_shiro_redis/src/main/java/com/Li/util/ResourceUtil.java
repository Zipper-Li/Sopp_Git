package com.Li.util;

import java.util.ResourceBundle;

/**
 * 
 * @ClassName:  ResourceUtil   
 * @Description: 验证码的参数类
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:24:03     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class ResourceUtil {
	private static final ResourceBundle SOURCE = java.util.ResourceBundle.getBundle("sysConfig");

	/**
	 * 获取随机码的长度
	 *
	 * @return 随机码的长度
	 */
	public static String getRandCodeLength() {
		return SOURCE.getString("randCodeLength");
	}

	/**
	 * 获取随机码的类型
	 *
	 * @return 随机码的类型
	 */
	public static String getRandCodeType() {
		return SOURCE.getString("randCodeType");
	}
}
