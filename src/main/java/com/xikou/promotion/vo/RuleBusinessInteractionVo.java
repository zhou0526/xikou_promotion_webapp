package com.xikou.promotion.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "规则业务交互Vo对象", description = "规则业务交互Vo对象")
public class RuleBusinessInteractionVo implements Serializable {

	@ApiModelProperty(value = "活动Id")
	private String activityId;

	@ApiModelProperty(value = "商品Id")
	private String activityCommodityId;

	@ApiModelProperty(value = "优惠金额")
	private Integer preferentialAmount;

	@ApiModelProperty(value = "类型标识")
	public String type;

	@ApiModelProperty(value = "类型值")
	public String values;

	@ApiModelProperty(value = "子集类型标识")
	public String subsetType;

	@ApiModelProperty(value = "子集类型值")
	public String subsetTypeValues;

	@ApiModelProperty(value = "促销工具类型标识")
	public String promotionType;

	@ApiModelProperty(value = "类型值")
	public String promotionTypeValues;
}
