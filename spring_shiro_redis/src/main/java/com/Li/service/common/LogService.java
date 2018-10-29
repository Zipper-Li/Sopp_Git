package com.Li.service.common;

import com.Li.pojo.Log;
import com.baomidou.mybatisplus.extension.service.IService;

public interface LogService extends IService<Log> {
	void insert(Log syslog);
}
