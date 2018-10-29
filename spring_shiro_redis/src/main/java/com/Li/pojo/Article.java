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
 * 文章表-保存了用户的文章信息，与类型表进行关联。
作者：Sopp
 * </p>
 *
 * @author Sopp
 * @since 2018-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *  自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章名字
     */
    private String articleName;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章访问人数
     */
    private Integer articleVisitUserinfo;

    /**
     * 发布ip
     */
    private String publishIp;

    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 是否置顶
     */
    @TableField("isTop")
    private Integer isTop;

    /**
     * 是否博主推荐
     */
    @TableField("isGroum")
    private Integer isGroum;

    /**
     * 文章属性，1：已发布，2：未发布，99：删除
     */
    private Integer articleStatus;

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
