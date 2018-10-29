package com.Li.util;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName:  IpUtil   
 * @Description: 匹配ip地址
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:23:24     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class IpUtil {

	public final static String ERROR_IP = "127.0.0.1";

	public final static Pattern pattern = Pattern.compile(
			"(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})");

	/**
	 * 
	 * ipToLong   
	 * @Description: 获取数字ip-参数为真实的ip
	 * @param: @param ipAddress
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 下午9:30:08      
	 * @throws   
	 * @return: long
	 */
	public Integer ipToLong(String ipAddress) {
		String[] ipAddressInArray = ipAddress.split("\\.");
		int ipNumber = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {
			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);
			ipNumber += ip * Math.pow(256, power);
		}
		return ipNumber;
	}

	/**
	 * 
	 * longToIp   
	 * @Description: 数字转换程ip地址
	 * @param: @param i
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 下午9:40:05      
	 * @throws   
	 * @return: String
	 */
	public String longToIp(long ipNumber) {
		return ((ipNumber >> 24) & 0xFF) + "." + ((ipNumber >> 16) & 0xFF) + "." + ((ipNumber >> 8) & 0xFF) + "."
				+ (ipNumber & 0xFF);
	}

	/**
	 * 取外网IP
	 *
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("x-real-ip");
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		// 过滤反向代理的ip
		String[] stemps = ip.split(",");
		if (stemps != null && stemps.length >= 1) {
			// 得到第一个IP，即客户端真实IP
			ip = stemps[0];
		}
		ip = ip.trim();
		if (ip.length() > 23) {
			ip = ip.substring(0, 23);
		}
		return ip;
	}

	/**
	 * 
	 * getUserIP   
	 * @Description: 获取用户的真实ip
	 * @param: @param request
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 下午9:52:58      
	 * @throws   
	 * @return: String
	 */
	public static String getUserIP(HttpServletRequest request) {
		// 优先取X-Real-IP
		String ip = request.getHeader("X-Real-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if ("0:0:0:0:0:0:0:1".equals(ip)) {
				ip = ERROR_IP;
			}
		}
		if ("unknown".equalsIgnoreCase(ip)) {
			ip = ERROR_IP;
			return ip;
		}
		int pos = ip.indexOf(',');
		if (pos >= 0) {
			ip = ip.substring(0, pos);
		}
		return ip;
	}
}