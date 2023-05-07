package com.example.demo.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 微信搜一搜：贺贺学编程
 * @since 2022-06-27
 */
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    private Long userId;

      /**
     * 商品id
     */
      private Long goodsId;

      /**
     * 收获地址
     */
      private Long deliveryAddrId;

      /**
     * 多余出来的商品
     */
      private String goodsName;

      /**
     * 商品单价
     */
      private BigDecimal goodsPrice;

      /**
     * 1pc 2android 3ios
     */
      private Integer orderChannel;

      /**
     * 订单状态 0未支付 ,1已支付2已发货3已收5已完成
     */
      private Integer status;

      /**
     * 创建事件
     */
      private LocalDateTime createDate;

      /**
     * 支付事件
     */
      private LocalDateTime payDate;

    
    public Long getId() {
        return id;
    }

      public void setId(Long id) {
          this.id = id;
      }
    
    public Long getUserId() {
        return userId;
    }

      public void setUserId(Long userId) {
          this.userId = userId;
      }
    
    public Long getGoodsId() {
        return goodsId;
    }

      public void setGoodsId(Long goodsId) {
          this.goodsId = goodsId;
      }
    
    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }

      public void setDeliveryAddrId(Long deliveryAddrId) {
          this.deliveryAddrId = deliveryAddrId;
      }
    
    public String getGoodsName() {
        return goodsName;
    }

      public void setGoodsName(String goodsName) {
          this.goodsName = goodsName;
      }
    
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

      public void setGoodsPrice(BigDecimal goodsPrice) {
          this.goodsPrice = goodsPrice;
      }
    
    public Integer getOrderChannel() {
        return orderChannel;
    }

      public void setOrderChannel(Integer orderChannel) {
          this.orderChannel = orderChannel;
      }
    
    public Integer getStatus() {
        return status;
    }

      public void setStatus(Integer status) {
          this.status = status;
      }
    
    public LocalDateTime getCreateDate() {
        return createDate;
    }

      public void setCreateDate(LocalDateTime createDate) {
          this.createDate = createDate;
      }
    
    public LocalDateTime getPayDate() {
        return payDate;
    }

      public void setPayDate(LocalDateTime payDate) {
          this.payDate = payDate;
      }

    @Override
    public String toString() {
        return "TOrder{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", goodsId=" + goodsId +
                  ", deliveryAddrId=" + deliveryAddrId +
                  ", goodsName=" + goodsName +
                  ", goodsPrice=" + goodsPrice +
                  ", orderChannel=" + orderChannel +
                  ", status=" + status +
                  ", createDate=" + createDate +
                  ", payDate=" + payDate +
              "}";
    }
}
