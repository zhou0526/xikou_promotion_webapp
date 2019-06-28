package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "活动商品新建(去报名)")
public class ActivityCommodityApplyCreateVo {

	@ApiModelProperty("活动商品主信息")
	private ActivityCommodityApplyVo activityCommodityApplyVo;

	@ApiModelProperty("活动商品详细")
	private List<ActivityCommodityDetailVo> activityCommodityDetailVoList;

}
