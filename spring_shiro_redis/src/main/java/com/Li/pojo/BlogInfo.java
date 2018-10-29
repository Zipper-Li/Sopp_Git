package com.Li.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客信息表-保存了个人博客相关信息表。
作者：Sopp
 * </p>
 *
 * @author Sopp
 * @since 2018-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 博客描述
     */
    private String blogAbout;

    /**
     * 博客名称
     */
    private String blogName;

    /**
     * 博客关键字
     */
    private String blogKeyword;

    /**
     * 博客用户id
     */
    private Integer blogUserid;

    /**
     * 博客状态，1：发布，0：未发布，99删除
     */
    private Integer blogStatus;

    /**
     * 博客发布时间
     */
    private Date blogReleastTime;

    /**
     * 版本，防止同步修改。
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


}
