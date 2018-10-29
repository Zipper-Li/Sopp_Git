package com.Li.config.mybatis;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * 
 * @ClassName:  MyMetaObjectHandler   
 * @Description: 全局处理类的转换
 * @author: L-ZP
 * @date:   2018年11月10日 下午9:02:01     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler{

	/**
	 * 注入日志处理的类
	 */
	private static final Logger logger = LoggerFactory.getLogger(MyMetaObjectHandler.class);
	
	@Override
	public void insertFill(MetaObject metaObject) {
		logger.info("start insert fill ....");
		metaObject.setValue("createTime", new Date());
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		logger.info("start update fill ....");
		metaObject.setValue("updateTime", new Date());
	}

}
