package com.xikou.promotion.controller.morediscount;

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
import com.xikou.promotion.api.condition.PromotionMoreDiscountCommodityCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.PromotionMoreDiscountCommodityModel;
import com.xikou.promotion.api.service.morediscount.PromotionMoreDiscountCommodityService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.PromotionMoreDiscountCommodityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.security.cert.Extension;
import java.util.List;

@Api(tags = "多买多折活动商品管理")
@RestController
@RequestMapping("/promotion/promotionmorediscountcommodity")
public class PromotionMoreDiscountCommodityController {

	private static final Logger logger = LoggerFactory.getLogger(PromotionMoreDiscountCommodityController.class);
	@Autowired
	private PromotionMoreDiscountCommodityService promotionMoreDiscountCommodityService;

	@ApiOperation(value = "根据条件分页查询多买多折活动商品", notes = "绑定活动id,商家ID,商品ID(sku)")
	@ResponseBody
	@RequestMapping(value = "/queryPaging", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>> queryPaging(PromotionMoreDiscountCommodityCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new PromotionMoreDiscountCommodityCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<PromotionMoreDiscountCommodityModel> promotionMoreDiscountCommodityModel = promotionMoreDiscountCommodityService.queryPaging(condition, (page - 1) * limit, limit);
		PaginationVo<PromotionMoreDiscountCommodityVo> promotionMoreDiscountCommodityVo = VoConvertor.convertPaginationModelToVo(promotionMoreDiscountCommodityModel, PromotionMoreDiscountCommodityVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>>(ResponseVo.success("查询成功", promotionMoreDiscountCommodityVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增多买多折活动商品", notes = "新增多多买多折活动商品")
	@ResponseBody
	@RequestMapping(value = "/saveIncrease", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveIncrease(@RequestBody PromotionMoreDiscountCommodityVo promotionMoreDiscountCommodityVo) throws BusinessException {
		try {
			promotionMoreDiscountCommodityService.saveIncrease(EntityCopyUtils.copyBean(promotionMoreDiscountCommodityVo, PromotionMoreDiscountCommodityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改多买多折活动商品", notes = "修改多买多折活动商品")
	@ResponseBody
	@RequestMapping(value = "/modifyMoreDiscountCommodity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyMoreDiscountCommodity(@RequestBody PromotionMoreDiscountCommodityVo promotionMoreDiscountCommodityVo) throws BusinessException {
		try {
			promotionMoreDiscountCommodityService.modifyMoreDiscountCommodity(EntityCopyUtils.copyBean(promotionMoreDiscountCommodityVo, PromotionMoreDiscountCommodityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID逻辑删除多买多折活动商品", notes = "Id")
	@ResponseBody
	@RequestMapping(value = "/deleteMoreDiscountCommodity/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteMoreDiscountCommodity(@PathVariable("id") String id) throws BusinessException {

		try {
			promotionMoreDiscountCommodityService.deleteMoreDiscountCommodity(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "多买多折活动商品上下架", notes = "ID,是否上架(1.是，2.否)")
	@ResponseBody
	@RequestMapping(value = "/modifyOnline", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyOnline(@PathVariable("id") String id, @PathVariable("online") Byte online) throws BusinessException {

		try {
			promotionMoreDiscountCommodityService.modifyOnline(id, online);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "验证起量", notes = "ID,当前商品选择的数量")
	@ResponseBody
	@RequestMapping(value = "/verificationThreshold/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> verificationThreshold(@PathVariable("id") String id, @PathVariable("number") Integer number) throws BusinessException {

		try {
			promotionMoreDiscountCommodityService.verificationThreshold(id, number);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("验证成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据activityId查询多买多折活动商品", notes = "绑定活动Id")
	@ResponseBody
	@RequestMapping(value = "/queryMoreDiscountCommodityList/{activityId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>> queryMoreDiscountCommodityList(@RequestBody String activityId) {

		List<PromotionMoreDiscountCommodityModel> promotionMoreDiscountCommodityModel = promotionMoreDiscountCommodityService.queryMoreDiscountCommodityList(activityId);
		List<PromotionMoreDiscountCommodityVo> promotionMoreDiscountCommodityVo = EntityCopyUtils.copyList(promotionMoreDiscountCommodityModel, PromotionMoreDiscountCommodityVo.class);

		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>>(ResponseVo.success("查询成功", promotionMoreDiscountCommodityVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据Id查询多买多折活动商品", notes = "多买多折活动商品表id")
	@ResponseBody
	@RequestMapping(value = "/queryMoreDiscountCommodity/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>> queryMoreDiscountCommodity(@RequestBody String id) {

		PromotionMoreDiscountCommodityModel promotionMoreDiscountCommodityModel = promotionMoreDiscountCommodityService.queryMoreDiscountCommodity(id);
		PromotionMoreDiscountCommodityVo promotionMoreDiscountCommodityVo = EntityCopyUtils.copyBean(promotionMoreDiscountCommodityModel, PromotionMoreDiscountCommodityVo.class);

		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionMoreDiscountCommodityVo>>(ResponseVo.success("查询成功", promotionMoreDiscountCommodityVo), HttpStatus.OK);
	}
}
