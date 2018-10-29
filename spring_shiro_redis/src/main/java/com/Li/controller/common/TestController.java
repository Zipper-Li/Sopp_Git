package com.Li.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Li.mapper.UserInfoMapper;
import com.Li.pojo.UserInfo;
import com.Li.service.common.ManagerInfoService;

@RestController
public class TestController {
	@Autowired
	private StringRedisTemplate redis;
	
	@Autowired
	private ManagerInfoService service;
	
	@Autowired
	private UserInfoMapper mapper;
	
	public void test() {
		redis.opsForValue().set("","");
		//json转对象，然后强转
		redis.opsForValue().get("");
	}
	
	@RequestMapping("role")
	public String role() {
		UserInfo userinfo = service.findByUsername("lige");
		return "";
	}
	
	@RequestMapping("add")
	public void add() {
		UserInfo user = new UserInfo();
		mapper.insert(user);
		System.out.println(1);
	}
}
