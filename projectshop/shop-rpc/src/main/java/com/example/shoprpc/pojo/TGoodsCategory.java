package com.example.shoprpc.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 你要自爆?
 * @since 2022-07-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TGoodsCategory {



    private static final long serialVersionUID=1L;

    /**
     * 商品分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    private String mobileName;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 家族图谱
     */
    private String parentIdPath;

    /**
     * 等级
     */
    private Boolean level;

    /**
     * 顺序排序
     */
    private Integer sortOrder;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 分类图片
     */
    private String image;

    /**
     * 是否推荐为热门分类
     */
    private Boolean isHot;

    /**
     * 分类分组默认0
     */
    private Boolean catGroup;

    /**
     * 分佣比例
     */
    private Boolean commissionRate;



}
