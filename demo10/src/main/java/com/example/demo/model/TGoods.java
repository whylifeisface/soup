package com.example.demo.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-24
 */
@Data
public class TGoods implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodImg;

    private String goodsDetial;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private BigDecimal seckillPrice;

    private Integer sockCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm",timezone="Asia/Shanghai")
    private Date endTime;

    @TableField(exist = false)
    private int state;
//    @TableField(exist = false)
//    private String startDateToString;
//    @TableField(exist = false)
//    private String endTimeToString;

}
