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
 * 广告表-保存了广告信息。
作者：Sopp
 * </p>
 *
 * @author Sopp
 * @since 2018-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Advertisement implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 广告名字
     */
    private String adName;

    /**
     * 广告类型：0：图片，1：flash，2：代码，3：文字。
     */
    private Integer adType;

    /**
     * 广告点击次数。
     */
    private Integer adClickTime;

    /**
     * 广告状态，0：关闭，1：启用。
     */
    private Integer adStatus;

    /**
     * 广告链接地址
     */
    private String adLinkAddress;

    /**
     * 广告联系人
     */
    private String adConnector;

    /**
     * 广告联系人电话
     */
    private String adConnectPhone;

    /**
     * 广告联系人邮箱
     */
    private String adConnectEmail;

    /**
     * 广告开始时间
     */
    private Date adBegintime;

    /**
     * 广告结束时间
     */
    private Date adEndtime;

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
