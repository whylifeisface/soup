package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GoodVo implements Serializable {
    private static final long serializableUID = -19059184535584387L;
    private Integer GoodId;
    private String GoodsName;
    private String GoodNameH1;
    private BigDecimal marketPrice;
    private String originalImg;

}
