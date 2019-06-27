package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "多买多折表规则Vo对象", description = "多买多折表规则Vo对象")
public class PromotionMoreDiscountRuleVo implements Serializable {
	private static final long serialVersionUID = -2582924408273592622L;
	@ApiModelProperty(value = "Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
	private String id;
	@ApiModelProperty(value = "绑定活动id", name = "activityId", example = "")
	private String activityId;
	@ApiModelProperty(value = "活动折扣方式(1:整单折扣率  2:阶梯折扣优惠)", name = "activityDiscount", example = "")
	private Byte activityDiscount;
	@ApiModelProperty(value = "整单折扣率", name = "unitDiscountRate", example = "")
	private Double unitDiscountRate;
	@ApiModelProperty(value = "最低购买", name = "minimumPurchase", example = "")
	private Integer minimumPurchase;
	@ApiModelProperty(value = "最大购买", name = "maximumPurchase", example = "")
	private Integer maximumPurchase;
	@ApiModelProperty(value = "费率1", name = "rateOne", example = "")
	private Double rateOne;
	@ApiModelProperty(value = "费率2", name = "rateTwo", example = "")
	private Double rateTwo;
	@ApiModelProperty(value = "费率3", name = "rateThree", example = "")
	private Double rateThree;
	@ApiModelProperty(value = "创建时间", name = "createTime", example = "")
	private Date createTime;
	@ApiModelProperty(value = "修改时间", name = "updateTime", example = "")
	private Date updateTime;
}
