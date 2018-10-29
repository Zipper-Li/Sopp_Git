package com.Li.util;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName:  Md5Util   
 * @Description: MD5加密工具类
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:23:35     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class Md5Util {

	private static final int TIME = 1;

	/**
	 * 加密
	 */
	private static Logger log = LoggerFactory.getLogger(Md5Util.class);

	public static void main(String[] args) {
		System.out.println(md5("123", "12", 1024));
	}

	/**
	 *
	 * md5
	 * @Description: md5加密,不存在盐值加密
	 * @param: @param str：加密的密码
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午2:21:10
	 * @throws
	 * @return: String
	 */
	public static String md5(String str, int times) {
		try {
			if (times == 0) {
				str = trueMd5(str, TIME);
			} else {
				for (int time = 0; time < times; time++) {
					str = trueMd5(str, time);
				}
			}
			log.info("一共加密" + times + "次，最后加密的密码为：" + str + "，密码长度为：32");
			return str;
		} catch (Exception e) {
			log.info("加密失败");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *
	 * md5_times
	 * @Description: md5，加密，存在盐值
	 * @param: @param str：需要加密的密码
	 * @param: @param salt：盐值
	 * @param: @param times：加密次数
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午2:27:31
	 * @throws
	 * @return: String
	 */
	public static String md5(String str, String salt, int times) {
		try {
			str = salt + str;
			if (times == 0) {
				str = trueMd5(str, TIME);
			} else {
				for (int time = 0; time < times; time++) {
					str = trueMd5(str, time);
				}
			}
			log.info("一共加密" + times + "次，最后加密的密码为：" + str + "，密码长度为：32");
			return str;
		} catch (Exception e) {
			log.info("加密失败");
			e.printStackTrace();
			return null;
		}
	}

	private static String trueMd5(String str, int times) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		byte[] byteDigest = md.digest();
		int i;
		if (times == 0) {
			times = TIME;
		}
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < byteDigest.length; offset++) {
			i = byteDigest[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		// 32位加密
		return buf.toString();
	}

}
