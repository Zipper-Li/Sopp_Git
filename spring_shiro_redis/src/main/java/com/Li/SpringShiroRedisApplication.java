package com.Li;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @ClassName:  SpringShiroRedisApplication
 * @Description: springboot启动类
 * @author: l-zp
 * @date:   2018年8月17日 下午5:08:15
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = { "com.Li.mapper" })
@ComponentScan(basePackages = { "com.Li.*" })
public class SpringShiroRedisApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(SpringShiroRedisApplication.class, args);
	}
}
