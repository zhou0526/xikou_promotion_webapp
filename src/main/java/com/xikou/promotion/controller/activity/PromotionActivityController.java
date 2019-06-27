package com.xikou.promotion.controller.activity;

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
import com.xikou.promotion.api.condition.ActivityOptionCondition;
import com.xikou.promotion.api.condition.PromotionActivityCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.PromotionActivityModel;
import com.xikou.promotion.api.service.activity.PromotionActivityService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.PromotionActivityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */

@Api(tags = "活动管理")
@RestController
@RequestMapping("/promotion/activity")
public class PromotionActivityController {

	private static final Logger logger = LoggerFactory.getLogger(PromotionActivityController.class);

	@Autowired
	private PromotionActivityService promotionActivityService;

	@ApiOperation(value = "活动列表", notes = "活动列表")
	@ResponseBody
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionActivityVo>> queryActivityList(PromotionActivityCondition condition, //
		@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new PromotionActivityCondition();
		}
		logger.debug("传参错误：{}", condition);
		PaginationModel<PromotionActivityModel> paginationModel = promotionActivityService.queryActivity(condition, //
			(page - 1) * limit, limit);
		PaginationVo<PromotionActivityVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, PromotionActivityVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<PromotionActivityVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增活动", notes = "新增活动")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveActivity(@RequestBody PromotionActivityVo promotionActivityVo) {
		try {
			promotionActivityService.saveActiveity(EntityCopyUtils.copyBean(promotionActivityVo, PromotionActivityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改活动", notes = "修改活动")
	@ResponseBody
	@RequestMapping(value = "/modifyActivity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyActivity(@RequestBody PromotionActivityVo promotionActivityVo) {
		try {
			promotionActivityService.modifyActivity(EntityCopyUtils.copyBean(promotionActivityVo, PromotionActivityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "查看活动", notes = "查看活动")
	@ResponseBody
	@RequestMapping(value = "/queryActivity/{activityId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<PromotionActivityVo>> queryActivity(@PathVariable String activityId) {
		try {
			PromotionActivityVo activityVo = EntityCopyUtils.copyBean(promotionActivityService.queryActivityById(activityId), PromotionActivityVo.class);
			return new ResponseEntity<>(ResponseVo.success("操作成功", activityVo), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

	@ApiOperation(value = "活动开启/关闭", notes = "活动开启/关闭")
	@ResponseBody
	@RequestMapping(value = "/startOrStopActivity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> startOrStopActivity(@RequestBody ActivityOptionCondition condition) {
		try {
			promotionActivityService.startOrStopActivity(condition);
			return new ResponseEntity<>(ResponseVo.success("操作成功", ""), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

}
