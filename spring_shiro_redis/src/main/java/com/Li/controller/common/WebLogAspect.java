package com.Li.controller.common;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.Li.annotation.MyLog;
import com.Li.pojo.Log;
import com.Li.service.common.LogService;
import com.Li.util.IpUtil;
import com.alibaba.fastjson.JSON;

@Aspect
@Component
public class WebLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	@Autowired
	private LogService logService;
	
    @Pointcut("@annotation(com.Li.annotation.MyLog)")
    public void webLog(){
    	
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    	logger.info("开始进入切面方法");
        //保存日志
        Log	syslog = new Log();
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            syslog.setOperName(value);
        }
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        syslog.setOperMethod(className + "." + methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = "";
        if(args.length > 0) {
        	params = JSON.toJSONString(args);
        }else {
        	params = "";
        }
        syslog.setOperParams(params);

        syslog.setOperTime(new Date());
        //获取用户名	((UserInfo)SecurityUtils.getSubject().getPrincipal()).getId(),先不设置id，然后后面登录再说
        syslog.setOperUserid(1);
        //获取用户ip地址
      //获取RequestAttributes  
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
        //从获取RequestAttributes中获取HttpServletRequest的信息  
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST); 
        syslog.setOperIp(new IpUtil().ipToLong(IpUtil.getUserIP(request)));

        //调用service保存syslog实体类到数据库
        logService.insert(syslog);
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret);
    }
}
