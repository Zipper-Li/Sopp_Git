package com.Li.service.common.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Li.mapper.UserInfoMapper;
import com.Li.pojo.UserInfo;
import com.Li.service.common.ManagerInfoService;

@Service
public class ManagerInfoServiceImpl implements ManagerInfoService {

	@Autowired
	private UserInfoMapper mapper;
	
	@Override
	public UserInfo findByUsername(String username) {
		return mapper.findByUsername(username);
	}

}
