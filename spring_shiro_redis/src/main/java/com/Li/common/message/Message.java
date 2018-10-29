package com.Li.common.message;

import java.io.Serializable;

import com.Li.common.Constant;

import lombok.Data;

/**
 *
 * @ClassName:  Message
 * @Description: 统一返回message信息：保证序列化json的时候,如果是null的对象,key也会消失
 * @author: l-zp
 * @date:   2018年8月15日 下午3:33:42
 * @param <T>
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@Data
public class Message implements Serializable {
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回状态吗
	 */
	private int code;
	/**
	 * 返回提示信息
	 */
	private String msg;
	/**
	 * 返回数据
	 */
	private Object data;

	/**
	 * 返回页数
	 */
	private int count;
	
	/**
	 *
	 * Message
	 * @Description:    返回状态码和返回消息
	 * @param:  @param code
	 * @param:  @param msg
	 * @throws
	 */
	private Message(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 *
	 * Message
	 * @Description:    返回状态码和返回消息，以及返回数据
	 * @param:  @param code
	 * @param:  @param msg
	 * @param:  @param data
	 * @throws
	 */
	private Message(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	private Message(int code, String msg, Object data,int count) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.count = count;
	}

	/**
	 *
	 * fail
	 * @Description: 定义失败返回的方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:41:52
	 * @throws
	 * @return: Message
	 */
	public static Message fail() {
		return new Message(Constant.CODE_FAIL, Constant.MSG_FAIL);
	}

	/**
	 *
	 * success
	 * @Description: 定义成功的返回的方法
	 * @param: @param data
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:44:38
	 * @throws
	 * @return: Message
	 */
	public static Message success(Object data) {
		return new Message(Constant.CODE_SUCCESS, Constant.MSG_SUCCESS, data);
	}
	
	/**
	 * 
	 * success   
	 * @Description: 分页的成功返回数据。
	 * @param: @param data
	 * @param: @param count
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 上午10:55:41      
	 * @throws   
	 * @return: Message
	 */
	public static Message success(Object data,int count) {
		return new Message(Constant.CODE_SUCCESS, Constant.MSG_SUCCESS, data, count);
	}

	/**
	 *
	 * noData
	 * @Description: 定义无返回数据的方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:45:20
	 * @throws
	 * @return: Message
	 */
	public static Message noData() {
		return new Message(Constant.CODE_NODATA, Constant.MSG_NODATA);
	}

	/**
	 *
	 * pareterror
	 * @Description: 定义参数错误的方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:45:50
	 * @throws
	 * @return: Message
	 */
	public static Message paretError() {
		return new Message(Constant.CODE_PARETERROR, Constant.MSG_PARETERROR);
	}

	/**
	 *
	 * warning
	 * @Description: 定义服务器故障方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:47:21
	 * @throws
	 * @return: Message
	 */
	public static Message warning() {
		return new Message(Constant.CODE_ERROR, Constant.MSG_ERROR);
	}

	/**
	 *
	 * nullParete
	 * @Description: 定义参数错误方法
	 * @param: @param msg : 不为空的参数说明------例如：用户名。即可
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:50:13
	 * @throws
	 * @return: Message
	 */
	public static Message nullParete(String msg) {
		return new Message(Constant.CODE_NULL, msg + Constant.MSG_NULL);
	}

	/**
	 *
	 * sessionTimeOut
	 * @Description: 定义session过期的方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:53:59
	 * @throws
	 * @return: Message
	 */
	public static Message sessionTimeOut() {
		return new Message(Constant.CODE_SESSIONTIMEOUT, Constant.MSG_SESSIONTIMEOUT);
	}

	/**
	 *
	 * noPermiss
	 * @Description: 定义权限不足的方法
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:55:14
	 * @throws
	 * @return: Message
	 */
	public static Message noPermiss() {
		return new Message(Constant.CODE_PERMISSIONNO, Constant.MSG_PERMISSIONNO);
	}

	/**
	 *
	 * error
	 * @Description:  服务器故障。
	 * @param: @param msg
	 * @param: @return
	 * @author: L-ZP
	 * @time: 下午9:57:01
	 * @throws
	 * @return: Message
	 */
	public static Message error(String msg) {
		return new Message(Constant.CODE_ERROR, msg);
	}

}
