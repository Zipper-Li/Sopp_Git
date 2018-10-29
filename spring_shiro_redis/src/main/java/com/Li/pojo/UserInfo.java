package com.Li.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * <p>
 * 用户表-保存了用户信息的表
作者：Sopp
 * </p>
 *
 * @author Sopp
 * @since 2018-11-12
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户密码盐值
     */
    private String passSalt;

    /**
     * 用户组id
     */
    private Integer userGroupid;

    /**
     * 用户性别，0：女，1：男
     */
    private Integer userSex;

    /**
     * 用户QQ号码
     */
    private String userQq;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 用户最后一次登录ip
     */
    private Integer lastIpAddress;

    /**
     * 用户头像地址
     */
    private String headImage;

    /**
     * 用户个人描述
     */
    private String userAbout;

    /**
     * 用户微博
     */
    private String userWeibo;

    /**
     * 是否锁定，0：未锁定，1：锁定
     */
    private Integer islocked;

    /**
     * 是否冻结，0：未冻结，1：冻结
     */
    private Integer isfreeze;

    /**
     * 用户状态，99：删除
     */
    private Integer status;

    /**
     * 当前状态，标识是否更新。
     */
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
	
	/** 角色 */
	@TableField(exist = false)
	private List<Role> role;

	/** 权限id */
	@TableField(exist = false)
	private List<Permission> permission;


}
