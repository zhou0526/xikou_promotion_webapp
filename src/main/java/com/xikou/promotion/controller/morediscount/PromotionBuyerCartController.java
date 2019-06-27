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
import com.xikou.promotion.api.condition.PromotionBuyerCartCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.PromotionBuyerCartModel;
import com.xikou.promotion.api.service.morediscount.PromotionBuyerCartService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.PromotionBuyerCartVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(tags = "多买多折购物车管理")
@RestController
@RequestMapping("/promotion/promotionbuyercart")
public class PromotionBuyerCartController {

	private static final Logger logger = LoggerFactory.getLogger(PromotionBuyerCartController.class);

	@Autowired
	private PromotionBuyerCartService promotionBuyerCartService;

	@ApiOperation(value = "根据条件分页查询多买多折购物车", notes = "商家ID,商家名称,购买用户ID,商品ID(sku),商品(SKU)名称")
	@ResponseBody
	@RequestMapping(value = "/queryPaging", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionBuyerCartVo>> queryPaging(PromotionBuyerCartCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new PromotionBuyerCartCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<PromotionBuyerCartModel> promotionBuyerCartModel = promotionBuyerCartService.queryPaging(condition, (page - 1) * limit, limit);
		PaginationVo<PromotionBuyerCartVo> promotionBuyerCartVo = VoConvertor.convertPaginationModelToVo(promotionBuyerCartModel, PromotionBuyerCartVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionBuyerCartVo>>(ResponseVo.success("查询成功", promotionBuyerCartVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据id查询多买多折购物车", notes = "购买用户ID")
	@ResponseBody
	@RequestMapping(value = "/queryAccordingID/{buyerUserId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionBuyerCartVo>> queryAccordingID(@RequestBody String buyerUserId) {

		List<PromotionBuyerCartModel> promotionBuyerCartModel = promotionBuyerCartService.queryAccordingID(buyerUserId);
		List<PromotionBuyerCartVo> promotionBuyerCartVo = EntityCopyUtils.copyList(promotionBuyerCartModel, PromotionBuyerCartVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionBuyerCartVo>>(ResponseVo.success("查询成功", promotionBuyerCartVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID删除多买多折购物车商品", notes = "Id")
	@ResponseBody
	@RequestMapping(value = "/deleteBuyerCart/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteBuyerCart(@PathVariable("id") String id) throws BusinessException {

		try {
			promotionBuyerCartService.deleteBuyerCart(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "新增多买多折购物车商品", notes = "新增多买多折购物车商品")
	@ResponseBody
	@RequestMapping(value = "/saveIncrease", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveIncrease(@RequestBody PromotionBuyerCartVo promotionBuyerCartVo) throws BusinessException {
		try {
			promotionBuyerCartService.saveIncrease(EntityCopyUtils.copyBean(promotionBuyerCartVo, PromotionBuyerCartModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据购买用户ID清空多买多折购物车", notes = "购买用户ID")
	@ResponseBody
	@RequestMapping(value = "/deleteEmptyBuyerCart/{buyerUserId}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteEmptyBuyerCart(@PathVariable("buyerUserId") String buyerUserId) throws BusinessException {

		try {
			promotionBuyerCartService.deleteEmptyBuyerCart(buyerUserId);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", ""), HttpStatus.OK);
	}
}
