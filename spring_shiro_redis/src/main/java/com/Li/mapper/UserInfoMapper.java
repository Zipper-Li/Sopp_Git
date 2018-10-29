package com.Li.mapper;

import org.springframework.cache.annotation.CacheConfig;

import com.Li.pojo.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表-保存了用户信息的表
作者：Sopp Mapper 接口
 * </p>
 *
 * @author Sopp
 * @since 2018-10-30
 */
@CacheConfig(cacheNames = "userinfo")
public interface UserInfoMapper extends BaseMapper<UserInfo> {

	/*根据用户名查询权限等内容*/
	UserInfo findByUsername(String username);

}
