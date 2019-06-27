package com.xikou.promotion.controller.buygift;

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
import com.xikou.promotion.api.condition.PromotionBuyGiftCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.PromotionBuyGiftCommodityModel;
import com.xikou.promotion.api.service.buygift.PromotionBuyGiftCommodityService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.PromotionBuyGiftCommodityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 描述：买一赠二（吾G）
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */

@Api(tags = "买一赠二")
@RestController
@RequestMapping("/promotion/buyGift")
public class PromotionBuyGiftController {

	private static final Logger logger = LoggerFactory.getLogger(PromotionBuyGiftController.class);

	@Autowired
	private PromotionBuyGiftCommodityService promotionBuyGiftCommodityService;

	@ApiOperation(value = "买一赠二活动列表", notes = "买一赠二活动列表")
	@ResponseBody
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionBuyGiftCommodityVo>> queryActivityList(PromotionBuyGiftCondition condition, //
		@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new PromotionBuyGiftCondition();
		}
		logger.debug("传参错误：{}", condition);
		PaginationModel<PromotionBuyGiftCommodityModel> paginationModel = promotionBuyGiftCommodityService.queryList(condition, //
			(page - 1) * limit, limit);
		PaginationVo<PromotionBuyGiftCommodityVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, PromotionBuyGiftCommodityVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionBuyGiftCommodityVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

}
