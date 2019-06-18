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
@ApiModel("活动对象")
public class ActivityVo implements Serializable {
	@ApiModelProperty(value = "活动ID")
	private String id;
	@ApiModelProperty(value = "活动名称")
	private String name;
	@ApiModelProperty(value = "活动描述")
	private String desc;
	@ApiModelProperty(value = "活动适用范围(1: 适用商户 2: 适用商品 3: 适用分类 4: 适用商户类型) 变更为 (1: 适用商家 2: 适用商品 3: 适用商品分类 4 适用商家类型)")
	private String activityScope;
	@ApiModelProperty(value = "活动适用商家范围  当活动适用范围为(适用商家类型),则可关联4种商家(4种商家(批发商,定制商,o2o联盟,喜扣))")
	private String merchantType;
	@ApiModelProperty(value = "活动类别(1: 单品促销  2: 整单促销 3: 组合促销 )")
	private String categoryRef;
	@ApiModelProperty(value = "推广平台(1: pc端 2: app 3: 小程序  4：公众号)")
	private String platformRef;
	@ApiModelProperty(value = "适用用户范围(1: 用户 2: 商家)")
	private String userScope;
	@ApiModelProperty(value = "当适用用户为(用户类型)(则可关联1: 普通用户 2: vip用户 3: 新用户 4: 老用户) 当适用用户为(商家类型),则可关联4种商家用户(批发商,定制商,o2o联盟,喜扣)")
	private String userTypeRef;
	@ApiModelProperty(value = "只能限定针对活动的格则包")
	private String rulePackId;
	@ApiModelProperty(value = "活动限定支付类型")
	private String payType;
	@ApiModelProperty(value = "商品数量限制")
	private Integer commodityQuantity;
	@ApiModelProperty(value = "活动banner图片地址")
	private String bannerUrl;
	@ApiModelProperty(value = "活动预热开始时间")
	private Date preheatTime;
	@ApiModelProperty(value = "活动开始时间")
	private Date startTime;
	@ApiModelProperty(value = "活动结束时间")
	private Date endTime;
	@ApiModelProperty(value = "优先级")
	private Integer priority;
	@ApiModelProperty(value = "活动排序字段")
	private Integer sortBy;
	@ApiModelProperty(value = "开关状态 1: 开启  2:关闭")
	private Byte switchState;
	@ApiModelProperty(value = "活动备注")
	private String remark;
	@ApiModelProperty(value = "活动状态 1: 未开始  2:预热中 3: 活动中 4: 已失效")
	private Byte state;
	@ApiModelProperty(value = "逻辑删除字段(1: 未删除 2: 已删除)")
	private Byte isDeleted;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
}
