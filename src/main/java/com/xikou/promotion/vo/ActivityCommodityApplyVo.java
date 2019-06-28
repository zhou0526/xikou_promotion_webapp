package com.xikou.promotion.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@Data
@ToString
@ApiModel(value = "活动商品主信息")
public class ActivityCommodityApplyVo implements Serializable {

	private static final long serialVersionUID = 1707386733655197842L;

	@ApiModelProperty("商品主图")
	private String goodsImageUrl;

	@ApiModelProperty("商品名称")
	private String commodityName;

	// 商品货号
	@ApiModelProperty("商品货号")
	private String goodsCode;

	@ApiModelProperty("商品后台一级分类")
	private String categoryRef1;

	@ApiModelProperty("商品后台二级分类")
	private String categoryRef2;

	@ApiModelProperty("商品后台三级分类")
	private String categoryRef3;
	// 商品类名名称
	@ApiModelProperty("商品类目名称")
	private String categoryName;

	@ApiModelProperty("销售库存(该版本不使用)")
	private Integer stock;// 申请参与活动库存

	@ApiModelProperty("申请时间")
	private Date createTime;

	@ApiModelProperty("审核状态(查询时使用) 1:待审核，2:已审核，3:驳回，4:取消申请")
	private Integer state;// 审核状态1:待审核，2:审核通过，3:驳回，4:取消申请

	@ApiModelProperty("活动类型(1:买一赠二(吾G)，2: 全球买手, 3：0元竞拍 4:多买多折，5:砍价得红包，6:定制拼团)")
	private Integer activityType;

	@ApiModelProperty("活动Id")
	private String activityId;

	@ApiModelProperty("商家Id")
	private String merchantId;

	@ApiModelProperty("商家名称")
	private String merchantName;

	@ApiModelProperty("商品SPUID")
	private String goodsId;

}
