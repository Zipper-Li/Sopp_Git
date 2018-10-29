package com.Li.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.Li.common.message.Message;

/**
 *
 * @ClassName:  GlobalExceptionHandler
 * @Description: 全局异常处理
 * @author: l-zp
 * @date:   2018年8月15日 下午4:37:40
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@RestControllerAdvice
public class GlobalExceptionHandler implements HandlerExceptionResolver{

	/**
	 *
	 * unauthorizedHandler
	 * @Description: 暂无权限的错误
	 * @param: @param request
	 * @param: @param exception
	 * @param: @return
	 * @param: @throws Exception
	 * @author: l-zp
	 * @time: 下午5:19:23
	 * @throws
	 * @return: Message
	 */
	@ExceptionHandler(value = UnauthorizedException.class)
	public Message unauthorizedHandler(HttpServletRequest request, Exception exception) throws Exception {
		return Message.noPermiss();
	}

	/**
	 *
	 * sessionTimeOut
	 * @Description: session过期时间
	 * @param: @return
	 * @author: l-zp
	 * @time: 下午5:23:09
	 * @throws
	 * @return: Message
	 */
	@ExceptionHandler(value = ExpiredSessionException.class)
	public Message sessionTimeOut(HttpServletRequest request, Exception exception) throws Exception {
		return Message.sessionTimeOut();
	}

	/**
	 *
	 * allExceptionHandler
	 * @Description: 拦截所有的异常，然后提示用户系统错误，请联系管理员处理
	 * @param: @param request
	 * @param: @param exception
	 * @param: @return
	 * @param: @throws Exception
	 * @author: l-zp
	 * @time: 下午5:58:21
	 * @throws
	 * @return: Message
	 */
	@ExceptionHandler(value = { Exception.class })
	public Message allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
		exception.printStackTrace();
		return Message.warning();
	}

	@Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
        if (ex instanceof UnauthorizedException) {
            return new ModelAndView("error/shiro_403");
        }
        return null;
    }
	
	
}
