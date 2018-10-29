package com.Li.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Li.annotation.MyLog;

/**
 * 
 * @ClassName:  PageConroller   
 * @Description: 公共的页面访问路径
 * @author: L-ZP
 * @date:   2018年10月30日 上午10:59:15     
 * 注意：本内容仅限于个人学习，禁止外泄以及用于其他的商业项目
 */
@Controller
public class PageConroller {
	/**
	 * 
	 * index   
	 * @Description: 首页访问
	 * @param: @return      
	 * @author: L-ZP
	 * @time: 上午11:07:05      
	 * @throws   
	 * @return: String
	 */
	@MyLog(value = "测试访问首页")  //这里添加了AOP的自定义注解
	@RequestMapping("/")
	public String index() {
		return "html/index";
	}
}
