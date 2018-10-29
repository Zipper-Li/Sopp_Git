package com.Li.service.impl;

import org.springframework.stereotype.Service;

import com.Li.mapper.UserInfoMapper;
import com.Li.pojo.UserInfo;
import com.Li.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 用户表-保存了用户信息的表
作者：Sopp 服务实现类
 * </p>
 *
 * @author Sopp
 * @since 2018-10-30
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
