package com.Li.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

/**
 * 
 * @ClassName:  MybatisPlusConfig   
 * @Description: mp的配置类
 * @author: L-ZP
 * @date:   2018年11月10日 下午10:11:41     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.taotao.manager.mapper")
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	/**
	 * 配置逻辑删除的状态
	 */
	@Bean
	public ISqlInjector sqlInjector() {
		return new LogicSqlInjector();
	}

	/**
	 * 
	 * performanceInterceptor   
	 * @Description: SQL执行效率插件
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 下午10:12:09      
	 * @throws   
	 * @return: PerformanceInterceptor
	 */
	@Bean
	@Profile({ "dev", "test" })
	public PerformanceInterceptor performanceInterceptor() {
		/*sql的最大执行时间*/
		int maxTime = 100;
		/*格式化sql*/
		boolean format = true;
		/*写入sql日志处理*/
		boolean writeInLog = true;
		/*构造对象*/
		PerformanceInterceptor performance = new PerformanceInterceptor();
		performance.setMaxTime(maxTime);
		performance.setFormat(format);
		performance.setWriteInLog(writeInLog);
		return performance;
	}
	
	/**
	 * 配置乐观锁：
	 * 使用步骤：
	 * 1.取出记录时，获取当前version
	 * 2.更新时，带上这个version
	 * 3.执行更新时， set version = newVersion where version = oldVersion
	 * 4.如果version不对，就更新失败
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
	    return new OptimisticLockerInterceptor();
	}
}
