package com.xikou.promotion.controller.round;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.xikou.common.constants.OprationConstant;
import com.xikou.common.model.ResponseVo;
import com.xikou.common.utils.EntityCopyUtils;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.RoundModel;
import com.xikou.promotion.api.service.round.RoundService;
import com.xikou.promotion.vo.RoundVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "活动轮次接口")
@RestController
@RequestMapping("/round")
public class RoundController {

	private static final Logger logger = LoggerFactory.getLogger(RoundController.class);

	@Autowired
	private RoundService roundService;

	@ApiOperation(value = "获取活动轮次", notes = "获取活动轮次")
	@ResponseBody
	@RequestMapping(value = "/current/{activityType}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo> queryCurrentRound(@ApiParam(value = "活动类型(1:买一赠二(吾G)，2: 全球买手, 3：0元竞拍 4:多买多折，5:砍价得红包，6:定制拼团)", required = true) @PathVariable Integer activityType) {

		List<RoundModel> roundModelList = roundService.queryCurrentRounds(activityType);
		return new ResponseEntity<>(ResponseVo.success(OprationConstant.OPRATION_SUCCESS_MESSAGE, roundModelList), HttpStatus.OK);
	}

	@ApiOperation(value = "新增活动轮次", notes = "新增活动轮次")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<com.xikou.promotion.common.ResponseVo> saveRound(@RequestBody RoundVo roundVo) {
		try {
			roundService.saveRound(EntityCopyUtils.copyBean(roundVo, RoundModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "编辑活动轮次", notes = "编辑活动轮次")
	@ResponseBody
	@RequestMapping(value = "/modifyRound", method = RequestMethod.POST)
	public ResponseEntity<com.xikou.promotion.common.ResponseVo> modifyRound(@RequestBody RoundVo roundVo) {
		try {
			roundService.modifyRound(EntityCopyUtils.copyBean(roundVo, RoundModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "生效(启用)活动轮次", notes = "生效(启用)活动轮次")
	@ResponseBody
	@RequestMapping(value = "/activeRound/{roundId}", method = RequestMethod.POST)
	public ResponseEntity<com.xikou.promotion.common.ResponseVo> activeRound(@PathVariable String roundId) {
		try {
			roundService.activeRound(roundId);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.success("启用成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "失效(停用)活动轮次", notes = "失效(停用)活动轮次")
	@ResponseBody
	@RequestMapping(value = "/deActiveRound/{roundId}", method = RequestMethod.POST)
	public ResponseEntity<com.xikou.promotion.common.ResponseVo> deActiveRound(@PathVariable String roundId) {
		try {
			roundService.deActiveRound(roundId);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(com.xikou.promotion.common.ResponseVo.success("启用成功", ""), HttpStatus.OK);
	}
}
