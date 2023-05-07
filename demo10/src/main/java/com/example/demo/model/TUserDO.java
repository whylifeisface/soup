package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;


/**
 * <p>
 * 
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class TUserDO implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     *  用户id 用手机号码代替
     */
    @NotNull
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String nickname;

    /**
     * 加盐的2次md5
     */
    @NotNull
    private String password;

    private String slat;

    /**
     * 注册日期
     */
    @TableField("registerDate")
    private Date registerdate;

    /**
     * 最后一次登录时间
     */
    @TableField("lastLoginDate")
    private Date lastlogindate;

    /**
     * 登录次数
     */
    @TableField("loginCount")
    private int  logincount;


}
