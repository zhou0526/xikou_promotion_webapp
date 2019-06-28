package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@Data
@ToString
@ApiModel(value = "活动商品详情")
public class ActivityCommodityDetailVo implements Serializable {

	private static final long serialVersionUID = -6698012722705082264L;

	@ApiModelProperty("商品SKUID")
	private String commodityId;
	// 商品型号
	@ApiModelProperty("型号")
	private String commodityModel;

	// 商品规格
	@ApiModelProperty("规格")
	private String commoditySpec;

	@ApiModelProperty("活动库存")
	private Integer stock;// 申请参与活动库存

	@ApiModelProperty("起量")
	private Integer startAmount;// 起量

	@ApiModelProperty("市场价")
	private Integer marketPrice;// 市场价

	@ApiModelProperty("成本价")
	private Integer costPrice;// 成本价

	@ApiModelProperty("销售价")
	private Integer salePrice;// 销售价

	@ApiModelProperty("活动价")
	private Integer commodityPrice;// 活动价

	@ApiModelProperty("平台售价")
	private Integer patformPrice;// 平台售价

	@ApiModelProperty("砍价底价")
	private Integer commodityReservePrice;// 砍价底价

	@ApiModelProperty("折扣价")
	private Integer discountPrice;// 折扣价

	@ApiModelProperty("折扣（多买多折标注为最低折扣、砍立得标注为底价折扣、全球买手标注为折扣率2.5-4折）")
	private Double discount;// 折扣（多买多折标注为最低折扣、砍立得标注为底价折扣、全球买手标注为折扣率2.5-4折）

	@ApiModelProperty("优惠券抵用面值")
	private Integer couponReach;// 优惠券抵用面值

	@ApiModelProperty("优惠券指定生效日期")
	private Date couponEffectiveDate;// 优惠券指定生效日期

}
