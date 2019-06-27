package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "多买多折购物车Vo对象", description = "多买多折购物车Vo对象")
public class PromotionBuyerCartVo implements Serializable {
	private static final long serialVersionUID = -4238982488806954335L;
	@ApiModelProperty(value = "Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
	private String id;
	@ApiModelProperty(value = "商家ID", name = "merchantId", example = "")
	private String merchantId;
	@ApiModelProperty(value = "商家名称", name = "merchantName", example = "")
	private String merchantName;
	@ApiModelProperty(value = "购买用户ID", name = "buyerUserId", example = "")
	private String buyerUserId;
	@ApiModelProperty(value = "商品ID(sku)", name = "commodityId", example = "")
	private String commodityId;
	@ApiModelProperty(value = "商品(SKU)名称", name = "commodityName", example = "")
	private String commodityName;
	@ApiModelProperty(value = "商品规格", name = "commoditySpec", example = "")
	private String commoditySpec;
	@ApiModelProperty(value = "商品型号", name = "commodityModel", example = "")
	private String commodityModel;
	@ApiModelProperty(value = "商品SKU单位", name = "commodityUnit", example = "")
	private String commodityUnit;
	@ApiModelProperty(value = "商品销售价", name = "salePrice", example = "")
	private Integer salePrice;
	@ApiModelProperty(value = "活动价格", name = "activityPrice", example = "")
	private Integer activityPrice;
	@ApiModelProperty(value = "折扣", name = "discount", example = "")
	private Double discount;
	@ApiModelProperty(value = "购买数量", name = "buyerNumber", example = "")
	private Integer buyerNumber;
	@ApiModelProperty(value = "排序号", name = "orderNo", example = "")
	private Integer orderNo;
	@ApiModelProperty(value = "创建时间", name = "createTime", example = "")
	private Date createTime;
	@ApiModelProperty(value = "修改时间", name = "updateTime", example = "")
	private Date updateTime;
}
