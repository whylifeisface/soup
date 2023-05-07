package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TBrand extends Model<TBrand> {

    private static final long serialVersionUID=1L;

    /**
     * 品牌表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 品牌描述
     */
    private String desc;

    /**
     * 品牌地址
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 品牌分类
     */
    private String catName;

    /**
     * 分类id
     */
    private Integer parentCatId;

    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 是否推荐
     */
    private Boolean isHot;




}
