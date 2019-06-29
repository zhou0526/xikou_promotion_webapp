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
public class PromotionActivityVo implements Serializable {
	@ApiModelProperty(value = "活动ID")
	private String id;
	@ApiModelProperty(value = "1:买一赠二(吾G)，2: 全球买手, 3：0元竞拍 4:多买多折，5:砍价得红包，6:定制拼团")
	private Integer activityType;
	@ApiModelProperty(value = "活动名称")
	private String name;
	@ApiModelProperty(value = "宣传描述1")
	private String propagandaDesc1;
	@ApiModelProperty(value = "宣传描述2")
	private String propagandaDesc2;
	@ApiModelProperty(value = "活动描述")
	private String desc;
	@ApiModelProperty(value = "活动参与者范围(1: 批发供应商 2: 供应链商家 3: o2o实体商家 4: 定制拼团商家)")
	private String participantScope;
	@ApiModelProperty(value = "活动支持商品分类")
	private String commodityCategory;
	@ApiModelProperty(value = "活动类别(1: 单品促销  2: 整单促销 3: 组合促销 )")
	private String categoryRef;
	@ApiModelProperty(value = "推广平台(1: APP 2:公众号 3: 小程序  4：H5)")
	private String platformRef;
	@ApiModelProperty(value = "适用用户范围(1: 用户 2: 商家)")
	private String userScope;
	@ApiModelProperty(value = "适用用户类型")
	private String userTypeRef;
	@ApiModelProperty(value = "活动限定支付类型")
	private String payType;
	@ApiModelProperty(value = "商品参与数量限制(不限制时为-1)")
	private Integer commodityQuantity;
	@ApiModelProperty(value = "活动banner图片地址")
	private String bannerUrl;
	@ApiModelProperty(value = "邮费方式（1、包邮 2.固定邮费 3.引用邮费模版）")
	private Integer postageWay;
	@ApiModelProperty(value = "邮费值")
	private Integer postage;
	@ApiModelProperty(value = "引用邮费模板id")
	private String postageRef;
	@ApiModelProperty(value = "活动是否预热(1: 不预热 2: 预热)")
	private Integer isPreheat;
	@ApiModelProperty(value = "活动预热提前时长 单位（天）")
	private Integer preheatTime;
	@ApiModelProperty(value = "活动开始时间")
	private Date startTime;
	@ApiModelProperty(value = "活动结束时间")
	private Date endTime;
	@ApiModelProperty(value = "优先级")
	private Integer priority;
	@ApiModelProperty(value = "开关状态 1: 开启  2:关闭")
	private Integer switchState;
	@ApiModelProperty(value = "活动备注")
	private String remark;
	@ApiModelProperty(value = "是否支持寄卖(1: 支持 2: 不支持)")
	private Integer supportConsignment;
	@ApiModelProperty(value = "设置最大允许寄卖时长(10天)")
	private Integer maxConsignmentDuration;
	@ApiModelProperty(value = "活动状态 1: 未开始  2:预热中 3: 活动中 4: 已失效")
	private Integer state;
	@ApiModelProperty(value = "逻辑删除字段  (1: 未删除 2: 已删除)")
	private Integer isDeleted;
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "修改时间")
	private Date updateTime;
}
