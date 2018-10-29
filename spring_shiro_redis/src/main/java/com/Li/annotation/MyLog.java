package com.Li.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName:  MyLog   
 * @Description: 自定义注解类，用来对方法执行的时候的记录
 * @author: L-ZP
 * @date:   2018年11月6日 上午10:23:44     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface MyLog {
	String value() default "";
}
