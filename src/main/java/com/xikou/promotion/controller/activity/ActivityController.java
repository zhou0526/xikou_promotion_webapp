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
import com.xikou.promotion.api.condition.ActivityCondition;
import com.xikou.promotion.api.condition.ActivityOptionCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.ActivityModel;
import com.xikou.promotion.api.service.activity.ActivityService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.ActivityVo;
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
public class ActivityController {

	private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

	@Autowired
	private ActivityService activityService;

	@ApiOperation(value = "活动列表", notes = "活动列表")
	@ResponseBody
	@RequestMapping(value = "/activitys", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityVo>> queryActivityList(ActivityCondition condition, //
		@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new ActivityCondition();
		}
		logger.debug("传参错误：{}", condition);
		PaginationModel<ActivityModel> paginationModel = activityService.queryActivity(condition, //
			(page - 1) * limit, limit);
		PaginationVo<ActivityVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, ActivityVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<ActivityVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增活动", notes = "新增活动")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveActivity(@RequestBody ActivityVo activityVo) {
		try {
			activityService.saveActiveity(EntityCopyUtils.copyBean(activityVo, ActivityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改活动", notes = "修改活动")
	@ResponseBody
	@RequestMapping(value = "/modifyActivity", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyActivity(@RequestBody ActivityVo activityVo) {
		try {
			activityService.modifyActivity(EntityCopyUtils.copyBean(activityVo, ActivityModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "查看活动", notes = "查看活动")
	@ResponseBody
	@RequestMapping(value = "/queryActivity/{activityId}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<ActivityVo>> queryActivity(@PathVariable String activityId) {
		try {
			ActivityVo activityVo = EntityCopyUtils.copyBean(activityService.queryActivityById(activityId), ActivityVo.class);
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
			activityService.startOrStopActivity(condition);
			return new ResponseEntity<>(ResponseVo.success("操作成功", ""), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

}
