package com.Li.common;

/**
 *
 * @ClassName:  Constant
 * @Description: 公共的常量类
 * @author: l-zp
 * @date:   2018年8月17日 下午5:23:05
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
public class Constant {
	/**
	 * 定义返回状态码
	 */
	// 失败
	public static final int CODE_FAIL = 0;

	// 成功
	public static final int CODE_SUCCESS = 1;

	// 无数据
	public static final int CODE_NODATA = 100;

	// 参数错误
	public static final int CODE_PARETERROR = 102;

	// 服务器错误
	public static final int CODE_ERROR = 103;

	// 参数为空
	public static final int CODE_NULL = 300;

	// session过期
	public static final int CODE_SESSIONTIMEOUT = 301;

	// 权限不足
	public static final int CODE_PERMISSIONNO = 302;

	/**
	 * 定义返回信息
	 */
	// 请求失败
	public static final String MSG_FAIL = "请求失败";

	// 请求成功
	public static final String MSG_SUCCESS = "请求成功";

	// 无数据
	public static final String MSG_NODATA = "暂无对应数据";

	// 参数错误
	public static final String MSG_PARETERROR = "请提供正确的信息";

	// 服务器错误
	public static final String MSG_ERROR = "系统错误，请联系管理员处理";

	// 参数为空
	public static final String MSG_NULL = "不能为空，请重新提供对应信息";

	// session过期
	public static final String MSG_SESSIONTIMEOUT = "身份信息已过期，重新登录";

	// 权限不足
	public static final String MSG_PERMISSIONNO = "权限不足，如果需要查看使用对应功能，请联系管理员";
}
