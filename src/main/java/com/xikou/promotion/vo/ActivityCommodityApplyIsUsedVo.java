package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "活动商品是否已添加")
public class ActivityCommodityApplyIsUsedVo {

	@ApiModelProperty("活动Id")
	private String activityId;

	@ApiModelProperty("活动商品SKUID")
	private String commodityId;

}
