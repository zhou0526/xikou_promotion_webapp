package com.xikou.promotion.controller.morediscount;

import com.xikou.promotion.api.condition.VerifyAddingShoppingCartsCondition;
import com.xikou.promotion.api.model.PromotionBuyerCartModel;
import com.xikou.promotion.vo.PromotionBuyerCartVo;
import com.xikou.promotion.vo.PromotionMoreDiscountCommodityVo;
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
import com.xikou.promotion.api.condition.PromotionMoreDiscountRuleCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.PromotionMoreDiscountRuleModel;
import com.xikou.promotion.api.service.morediscount.PromotionMoreDiscountRuleService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.PromotionMoreDiscountRuleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "多买多折表规则管理")
@RestController
@RequestMapping("/promotion/promotionmorediscountrule")
public class PromotionMoreDiscountRuleController {

	private static final Logger logger = LoggerFactory.getLogger(PromotionMoreDiscountRuleController.class);
	@Autowired
	private PromotionMoreDiscountRuleService promotionMoreDiscountRuleService;

	@ApiOperation(value = "根据条件分页查询多买多折表规则", notes = "绑定活动id,商家ID,商品ID(sku)")
	@ResponseBody
	@RequestMapping(value = "/queryPaging", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionMoreDiscountRuleVo>> queryPaging(PromotionMoreDiscountRuleCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new PromotionMoreDiscountRuleCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<PromotionMoreDiscountRuleModel> promotionMoreDiscountRuleModel = promotionMoreDiscountRuleService.queryPaging(condition, (page - 1) * limit, limit);
		PaginationVo<PromotionMoreDiscountRuleVo> promotionMoreDiscountRuleVo = VoConvertor.convertPaginationModelToVo(promotionMoreDiscountRuleModel, PromotionMoreDiscountRuleVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionMoreDiscountRuleVo>>(ResponseVo.success("查询成功", promotionMoreDiscountRuleVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增多买多折表规则", notes = "新增多买多折表规则")
	@ResponseBody
	@RequestMapping(value = "/saveIncrease", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveIncrease(@RequestBody PromotionMoreDiscountRuleVo promotionMoreDiscountRuleVo) throws BusinessException {
		try {
			promotionMoreDiscountRuleService.saveIncrease(EntityCopyUtils.copyBean(promotionMoreDiscountRuleVo, PromotionMoreDiscountRuleModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改多买多折规则", notes = "修改多买多折规则")
	@ResponseBody
	@RequestMapping(value = "/modifyMoreDiscountRule", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyMoreDiscountRule(@RequestBody PromotionMoreDiscountRuleVo promotionMoreDiscountRuleVo) throws BusinessException {
		try {
			promotionMoreDiscountRuleService.modifyMoreDiscountRule(EntityCopyUtils.copyBean(promotionMoreDiscountRuleVo, PromotionMoreDiscountRuleModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID删除多买多折规则", notes = "Id")
	@ResponseBody
	@RequestMapping(value = "/deleteMoreDiscountRule/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteMoreDiscountRule(@PathVariable("id") String id) throws BusinessException {

		try {
			promotionMoreDiscountRuleService.deleteMoreDiscountRule(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据activityId查询多买多折规则", notes = "绑定活动Id")
	@ResponseBody
	@RequestMapping(value = "/queryMoreDiscountRule/{activityId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionMoreDiscountRuleVo>> queryMoreDiscountRule(@RequestBody String activityId) {

		PromotionMoreDiscountRuleModel promotionMoreDiscountRuleModel = promotionMoreDiscountRuleService.queryMoreDiscountRule(activityId);
		PromotionMoreDiscountRuleVo promotionMoreDiscountRuleVo = EntityCopyUtils.copyBean(promotionMoreDiscountRuleModel, PromotionMoreDiscountRuleVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionMoreDiscountRuleVo>>(ResponseVo.success("查询成功", promotionMoreDiscountRuleVo), HttpStatus.OK);
	}

	@ApiOperation(value = "验证提交购物车", notes = "Id,绑定活动ID,提交购物车商品数量")
	@ResponseBody
	@RequestMapping(value = "/verifyAddingShoppingCarts", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> verifyAddingShoppingCarts(VerifyAddingShoppingCartsCondition condition) throws BusinessException {
		if (condition == null) {
			condition = new VerifyAddingShoppingCartsCondition();
		}
		try {
			promotionMoreDiscountRuleService.verifyAddingShoppingCarts(condition);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("验证成功", ""), HttpStatus.OK);
	}
}
