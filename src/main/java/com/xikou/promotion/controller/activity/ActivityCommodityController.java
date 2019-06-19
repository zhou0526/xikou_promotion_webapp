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
import com.xikou.promotion.api.condition.ActivityCommodityCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.ActivityCommodityModel;
import com.xikou.promotion.api.service.activity.ActivityCommodityService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.ActivityCommodityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 描述：活动商品
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@Api(tags = "活动商品")
@RestController
@RequestMapping("/promotion/activityCommodity")
public class ActivityCommodityController {
	private static final Logger logger = LoggerFactory.getLogger(ActivityCommodityController.class);

	@Autowired
	private ActivityCommodityService activityCommodityService;

	@ApiOperation(value = "活动商品列表", notes = "活动商品列表")
	@ResponseBody
	@RequestMapping(value = "/queryActivityCommodityList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityCommodityVo>> queryActivityCommodityList(ActivityCommodityCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) throws BusinessException {
		if (condition == null) {
			condition = new ActivityCommodityCondition();
		}
		logger.error("传参错误：{}", condition);
		PaginationModel<ActivityCommodityModel> paginationModel = activityCommodityService.queryActivityCommodityList(condition, //
			(page - 1) * limit, limit);
		PaginationVo<ActivityCommodityVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, //
			ActivityCommodityVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<ActivityCommodityVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增活动商品", notes = "新增活动商品")
	@ResponseBody
	@RequestMapping(value = "/saveActivityCommodity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveActivityCommodity(@RequestBody ActivityCommodityVo activityCommodityVo) throws BusinessException {
		try {
			activityCommodityService.saveActivityCommodity(EntityCopyUtils.copyBean(activityCommodityVo, //
				ActivityCommodityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改活动商品", notes = "修改活动商品")
	@ResponseBody
	@RequestMapping(value = "/modifyActivityCommodity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyActivityCommodity(@RequestBody ActivityCommodityVo activityCommodityVo) throws BusinessException {
		try {
			activityCommodityService.modifyActivityCommodity(EntityCopyUtils.copyBean(activityCommodityVo, //
				ActivityCommodityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "查看活动商品", notes = "查看活动商品")
	@ResponseBody
	@RequestMapping(value = "/queryActivityCommodityById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityCommodityVo>> queryActivityCommodityById(@PathVariable String id) throws BusinessException {
		try {
			ActivityCommodityVo activityCommodityVo = EntityCopyUtils.copyBean(activityCommodityService.queryActivityCommodityById(id), ActivityCommodityVo.class);
			return new ResponseEntity<>(ResponseVo.success("操作成功", activityCommodityVo), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

	@ApiOperation(value = "删除活动商品", notes = "删除活动商品")
	@ResponseBody
	@RequestMapping(value = "/deleteActivityCommodityById/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteActivityCommodityById(@PathVariable String id) throws BusinessException {
		try {
			activityCommodityService.deleteActivityCommodityById(id);
			return new ResponseEntity<>(ResponseVo.success("操作成功", ""), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

}
