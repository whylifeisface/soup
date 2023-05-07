package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */
@Data
public class TSeckillOrder implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 商品id
     */
      private Long goodsId;

    private Long userId;

    private Long orderId;

    private Long goodId;

    @TableField(exist = false)
   private int UserNotFind;
}
