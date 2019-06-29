package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@ApiModel("买一赠二活动优惠券规则对象")
public class PromotionBuyGiftCouponVo implements Serializable{
    private static final long serialVersionUID = 9051165346592686989L;
    @ApiModelProperty(value = "主键ID")
    private String id;
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "优惠券名称")
    private String couponName;
    @ApiModelProperty(value = "优惠券的面值生成规则，用户订单的多少倍")
    private Integer couponValue;
    @ApiModelProperty(value = "生成计算方式（1 用户付费开始时间计算 2 用户确认收货日期开始计算）")
    private Integer generateType;
    @ApiModelProperty(value = "有效方式（1 永久有效 default -1， 2根据生成日期产生多少天有效））")
    private Integer effectiveType;
    @ApiModelProperty(value = "有效起始时间（多少 单位/天）")
    private Integer effectiveStartTime;
    @ApiModelProperty(value = "使用范围（1 全球买手 2.多买多折 3.砍立得 4.0元竞拍 5.O2O实体店 6.定制拼团 ）")
    private String useScope;
    @ApiModelProperty(value = "发放方式（1.用户领取 2.自动发放到用户优惠券账户）")
    private Integer distrbutionType;
    @ApiModelProperty(value = "通知方式（1.不通知 2.短信通知 3.微信推送通知 4.APP推送消息通知）")
    private Integer notifyType;
    @ApiModelProperty(value = "优惠券过期前消息通知时间（多少 单位/天）")
    private Integer expiredTime;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}