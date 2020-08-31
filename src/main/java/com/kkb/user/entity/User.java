package com.kkb.user.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郁晓超
 * @since 2020-08-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String user001;

    /**
     * 用户名
     */
    private String user002;

    /**
     * 密码
     */
    private String user003;

    /**
     * 姓名
     */
    private String user004;

    /**
     * 性别
     */
    private String user005;

    /**
     * 邮箱
     */
    private String user006;

    /**
     * 手机号
     */
    private String user007;

    /**
     * 地址
     */
    private String user008;

    /**
     * 创建日期
     */
    private Date user009;
}
