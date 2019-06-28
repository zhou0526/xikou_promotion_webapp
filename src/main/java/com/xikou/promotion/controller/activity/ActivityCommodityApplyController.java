package com.xikou.promotion.controller.activity;

import com.xikou.promotion.api.model.PromotionActivityApplyCommodityModel;
import com.xikou.promotion.vo.ActivityCommodityApplyCreateVo;
import com.xikou.promotion.vo.ActivityCommodityApplyIsUsedVo;
import com.xikou.promotion.vo.ActivityCommodityDetailVo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.xikou.common.model.PaginationModel;
import com.xikou.common.model.PaginationVo;
import com.xikou.common.utils.EntityCopyUtils;
import com.xikou.common.utils.VoConvertor;
import com.xikou.promotion.api.condition.ActivityCommodityApplyCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.service.activity.ActivityCommodityApplyService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.ActivityCommodityApplyVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 描述：活动商品报名与审核接口
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@Api(tags = "活动商品报名与审核")
@RestController
@RequestMapping("/promotion/activityCommodity")
public class ActivityCommodityApplyController {
	private static final Logger logger = LoggerFactory.getLogger(ActivityCommodityApplyController.class);

	@Autowired
	private ActivityCommodityApplyService activityCommodityApplyService;

	@ApiOperation(value = "活动商品主信息列表(申请中)", notes = "活动商品主信息列表(申请中)")
	@ResponseBody
	@RequestMapping(value = "/queryActivityCommodityApplyList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityCommodityApplyVo>> queryActivityCommodityApplyList(ActivityCommodityApplyCondition condition, //
		@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new ActivityCommodityApplyCondition();
		}
		logger.debug("传参错误：{}", condition);
		PaginationModel<PromotionActivityApplyCommodityModel> paginationModel = activityCommodityApplyService.queryActivityCommodityApplyList(condition, //
			(page - 1) * limit, limit);
		PaginationVo<ActivityCommodityApplyVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, //
			ActivityCommodityApplyVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<ActivityCommodityApplyVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "活动商品详情信息列表(申请中)", notes = "活动商品详情信息列表(申请中)")
	@ResponseBody
	@RequestMapping(value = "/queryActivityCommodityDetailList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityCommodityDetailVo>> queryActivityCommodityDetailList(String activityCommodityId, //
		@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {

		if (StringUtils.isBlank(activityCommodityId)) {
			return new ResponseEntity<ResponseVo<ActivityCommodityDetailVo>>(ResponseVo.unsuccess("活动商品Id不能为空!"), HttpStatus.OK);
		}
		PaginationModel<PromotionActivityApplyCommodityModel> paginationModel = activityCommodityApplyService.queryActivityCommodityDetailListById(//
			activityCommodityId, (page - 1) * limit, limit);
		PaginationVo<ActivityCommodityDetailVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, //
			ActivityCommodityDetailVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<ActivityCommodityDetailVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "活动商品去报名", notes = "活动商品去报名")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveActivityCommodityApply(@RequestBody ActivityCommodityApplyCreateVo vo) {
		try {
			for (ActivityCommodityDetailVo v : vo.getActivityCommodityDetailVoList()) {
				PromotionActivityApplyCommodityModel model = EntityCopyUtils.copyBean(vo.getActivityCommodityApplyVo(), PromotionActivityApplyCommodityModel.class);
				model.setCommodityId(v.getCommodityId());
				model.setCommodityModel(v.getCommodityModel());
				model.setCommoditySpec(v.getCommoditySpec());
				model.setStock(v.getStock());
				model.setStartAmount(v.getStartAmount());
				model.setMarketPrice(v.getMarketPrice());
				model.setCostPrice(v.getCostPrice());
				model.setSalePrice(v.getSalePrice());
				model.setCommodityPrice(v.getCommodityPrice());
				model.setPatformPrice(v.getPatformPrice());
				model.setCommodityReservePrice(v.getCommodityReservePrice());
				model.setDiscountPrice(v.getDiscountPrice());
				model.setDiscount(v.getDiscount());
				model.setCouponReach(v.getCouponReach());
				model.setCouponEffectiveDate(v.getCouponEffectiveDate());
				activityCommodityApplyService.saveActivityCommodityApply(model);
			}
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "查询活动商品是否已添加(若返回对象为空则未添加,反之则已添加)", //
		notes = "查询活动商品是否已添加(若返回对象为空则未添加,反之则已添加)")
	@ResponseBody
	@RequestMapping(value = "/queryActivityCommodityApplyIsUsed", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityCommodityApplyVo>> queryActivityCommodityById(@RequestBody ActivityCommodityApplyIsUsedVo vo) {
		try {
			PromotionActivityApplyCommodityModel model = activityCommodityApplyService.queryByActivityIdAndCommodityId(//
				vo.getActivityId(), vo.getCommodityId());
			return new ResponseEntity<>(ResponseVo.success("操作成功", EntityCopyUtils.copyBean(model//
				, ActivityCommodityApplyVo.class)), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

}
