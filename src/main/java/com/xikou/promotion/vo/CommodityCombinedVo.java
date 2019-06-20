package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@Data
@ToString
@ApiModel(value = "组合商品对象")
public class CommodityCombinedVo implements Serializable{

    private static final long serialVersionUID = 3680576968598927810L;
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("商家id")
    private String merchantId;
    @ApiModelProperty("主商品id (sku)")
    private String commodityId;
    @ApiModelProperty("组合商品名称")
    private String combinedName;
    @ApiModelProperty("辅商品id (sku)")
    private String assistCommodityId;
    @ApiModelProperty("辅商品预警库存数量 (sku)")
    private Integer assistCommodityWarningStock;
    @ApiModelProperty("套装商品价格")
    private Integer suitCommodityPrice;
    @ApiModelProperty("套装商品底价")
    private Integer suitCommodityReservePrice;
    @ApiModelProperty("销量")
    private Integer salesVolume;
    @ApiModelProperty("浏览量")
    private Integer viewQuantity;
    @ApiModelProperty("逻辑删除字段  (1: 未删除 2: 已删除)")
    private Byte isDeleted;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("修改时间")
    private Date updateTime;
}
