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
@ApiModel(value = "活动商品")
public class ActivityCommodityVo implements Serializable {

	private static final long serialVersionUID = 7069715648661770862L;

	@ApiModelProperty("主键ID")
	private String id;
	@ApiModelProperty("活动id")
	private String activityId;
	@ApiModelProperty("商家id")
	private String merchantId;
	@ApiModelProperty("商家名称")
	private String merchantName;
	@ApiModelProperty("商品id")
	private String commodityId;
	@ApiModelProperty("商品Name")
	private String commodityName;
	@ApiModelProperty("针对商品的格则包id,只能绑定一个规则包")
	private String rulePackId;
	@ApiModelProperty("活动商品库存")
	private Integer activityCommodityStock;
	@ApiModelProperty("活动商品价格")
	private Integer activityCommodityPrice;
	@ApiModelProperty("活动商品底价")
	private Integer commodityReservePrice;
	@ApiModelProperty("销量")
	private Integer salesVolume;
	@ApiModelProperty("浏览量")
	private Integer viewQuantity;
	@ApiModelProperty("优先级")
	private Integer priority;
	@ApiModelProperty("逻辑删除字段  (1: 未删除 2: 已删除)")
	private Byte isDeleted = 1;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("修改时间")
	private Date updateTime;
}
