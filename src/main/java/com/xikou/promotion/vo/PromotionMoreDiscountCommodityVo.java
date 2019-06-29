package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "多买多折活动商品vo对象", description = "多买多折活动商品vo对象")
public class PromotionMoreDiscountCommodityVo implements Serializable {
	private static final long serialVersionUID = -8164355746358444935L;
	@ApiModelProperty(value = "Id", name = "id", example = "主键ID(采用分布式ObjectId生成策略 24位长度)")
	private String id;
	@ApiModelProperty(value = "绑定活动id", name = "activityId", example = "")
	private String activityId;
	@ApiModelProperty(value = "商家ID", name = "merchantId", example = "")
	private String merchantId;
	@ApiModelProperty(value = "商家名称", name = "merchantName", example = "")
	private String merchantName;
	@ApiModelProperty(value = "商品spuID", name = "goodsId", example = "")
	private String goodsId;
	@ApiModelProperty(value = "商品后台一级分类(查询时使用,冗余)", name = "categoryRef1", example = "")
	private String categoryRef1;
	@ApiModelProperty(value = "商品后台二级分类(查询时使用,冗余)", name = "categoryRef2", example = "")
	private String categoryRef2;
	@ApiModelProperty(value = "商品后台三级分类(查询时使用,冗余)", name = "categoryRef3", example = "")
	private String categoryRef3;
	@ApiModelProperty(value = "商品后台类名名称(冗余)", name = "categoryName", example = "")
	private String categoryName;
	@ApiModelProperty(value = "商品货号(冗余)", name = "goodsCode", example = "")
	private String goodsCode;
	@ApiModelProperty(value = "商品主图url", name = "goodsImageUrl", example = "")
	private String goodsImageUrl;
	@ApiModelProperty(value = "商品ID(sku)", name = "commodityId", example = "")
	private String commodityId;
	@ApiModelProperty(value = "商品名称(查询时使用,冗余)", name = "commodityName", example = "")
	private String commodityName;
	@ApiModelProperty(value = "商品规格(查询时使用,冗余)", name = "commoditySpec", example = "")
	private String commoditySpec;
	@ApiModelProperty(value = "商品型号(查询时使用,冗余)", name = "commodityModel", example = "")
	private String commodityModel;
	@ApiModelProperty(value = "状态(1 在售  2售罄)", name = "status", example = "")
	private Integer status;
	@ApiModelProperty(value = "活动商品库存", name = "stock", example = "")
	private Integer stock;
	@ApiModelProperty(value = "活动商品虚拟库存", name = "virtualStock", example = "")
	private Integer virtualStock;
	@ApiModelProperty(value = "销售价", name = "salePrice", example = "")
	private Integer salePrice;
	@ApiModelProperty(value = "成本价", name = "costPrice", example = "")
	private Integer costPrice;
	@ApiModelProperty(value = "市场价", name = "marketPrice", example = "")
	private Integer marketPrice;
	@ApiModelProperty(value = "活动价", name = "commodityPrice", example = "")
	private Integer commodityPrice;
	@ApiModelProperty(value = "销量", name = "salesVolume", example = "")
	private Integer salesVolume;
	@ApiModelProperty(value = "起量", name = "startAcount", example = "")
	private Integer startAcount;
	@ApiModelProperty(value = "最低折扣", name = "discount", example = "")
	private Double discount;
	@ApiModelProperty(value = "优先级", name = "priority", example = "")
	private Integer priority;
	@ApiModelProperty(value = "下单后发货时间（小时）", name = "deliveryTime", example = "")
	private Integer deliveryTime;
	@ApiModelProperty(value = "用户限购量", name = "purchaseLimit", example = "")
	private Integer purchaseLimit;
	@ApiModelProperty(value = "是否上架,1.是，2.否", name = "online", example = "")
	private Integer online;
	@ApiModelProperty(value = "开始时间", name = "startTime", example = "")
	private Date startTime;
	@ApiModelProperty(value = "结束时间", name = "endTime", example = "")
	private Date endTime;
	@ApiModelProperty(value = "是否删除,1.是，2.否", name = "isDeleted", example = "")
	private Integer isDeleted;
	@ApiModelProperty(value = "创建时间", name = "createTime", example = "")
	private Date createTime;
	@ApiModelProperty(value = "修改时间", name = "updateTime", example = "")
	private Date updateTime;
}
