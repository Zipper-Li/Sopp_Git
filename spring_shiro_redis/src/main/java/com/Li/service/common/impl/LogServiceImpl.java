package com.Li.service.common.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Li.mapper.LogMapper;
import com.Li.pojo.Log;
import com.Li.service.common.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

	@Autowired
	private LogMapper mapper;
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insert(Log syslog) {
		mapper.insert(syslog);
	}

}
