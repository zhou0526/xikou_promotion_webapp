package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@ApiModel("买一赠二活动商品对象")
public class PromotionBuyGiftCommodityVo {
	@ApiModelProperty(value = "主键ID")
	private String id;
	@ApiModelProperty(value = "活动ID")
	private String activityId;
	@ApiModelProperty(value = "商家id")
	private String merchantId;
	@ApiModelProperty(value = "寄卖用户")
	private String userId;
	@ApiModelProperty(value = "寄卖用户名称")
	private String userName;
	@ApiModelProperty(value = "商品id")
	private String commodityId;
	@ApiModelProperty(value = "商品名称")
	private String commodityName;
	@ApiModelProperty(value = "优先级")
	private Integer priority;
	@ApiModelProperty(value = "活动商品虚拟库存")
	private Integer virtualStock;
	@ApiModelProperty(value = "库存")
	private Long stock;
	@ApiModelProperty(value = "销售状态（1:在售，2:售罄）")
	private Byte state;
	@ApiModelProperty(value = "是否上架，1：是，2：否")
	private Byte online;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
	@ApiModelProperty(value = "销售价")
	private Integer salePrice;
	@ApiModelProperty(value = "成本价")
	private Integer costPrice;
	@ApiModelProperty(value = "市场价")
	private Integer marketPrice;
	@ApiModelProperty(value = "活动价")
	private Integer commodityPrice;

}