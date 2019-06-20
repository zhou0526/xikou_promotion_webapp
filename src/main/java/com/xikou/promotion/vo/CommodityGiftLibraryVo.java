package com.xikou.promotion.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@ApiModel(value = "商品赠换品库")
public class CommodityGiftLibraryVo implements Serializable {
	private static final long serialVersionUID = 2119533295931664602L;
	@ApiModelProperty("主键")
	private String id;
	@ApiModelProperty("赠换状态 1: 赠  2: 换")
	private Byte giftCommodityType;
	@ApiModelProperty("商品id")
	private String commodityId;
	@ApiModelProperty("商品品牌id")
	private String brandId;
	@ApiModelProperty("商品名称")
	private String commodityName;
	@ApiModelProperty("商品描述")
	private String commodityIntroduction;
	@ApiModelProperty("商品主图url")
	private String commodityImageUrl;
	@ApiModelProperty("商品品牌名称")
	private String brandName;
	@ApiModelProperty("商品品牌描述")
	private String brandDescription;
	@ApiModelProperty("商品品牌图片url")
	private String brandUrl;
	@ApiModelProperty(" 赠换商品库存")
	private Integer giftCommodityStock;
	@ApiModelProperty("赠换商品价格")
	private Integer giftCommodityPrice;
	@ApiModelProperty("逻辑删除字段  (1: 未删除 2: 已删除)")
	private Byte isDeleted;
	@ApiModelProperty("创建时间")
	private Date createTime;
	@ApiModelProperty("修改时间")
	private Date updateTime;

}