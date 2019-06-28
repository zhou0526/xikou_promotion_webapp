package com.xikou.promotion.controller.rulepack;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xikou.common.utils.EntityCopyUtils;
import com.xikou.promotion.api.condition.RuleBusinessInteractionCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.RuleBusinessInteractionModel;
import com.xikou.promotion.api.service.rulebusinessinteraction.RuleBusinessInteractionService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.RuleBusinessInteractionVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "规则业务交互接口")
@RestController
@RequestMapping("/promotion/rulebic")
public class RuleBusinessInteractionController {
	private static final Logger logger = LoggerFactory.getLogger(RuleBusinessInteractionController.class);

	@Autowired
	private RuleBusinessInteractionService ruleBusinessInteractionService;

	@ApiOperation(value = "根据规则计算优惠金额", notes = "活动Id,原金额,原数量")
	@ResponseBody
	@RequestMapping(value = "/calculationpreferentialamount", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<RuleBusinessInteractionVo>> querySepc(RuleBusinessInteractionCondition condition) throws BusinessException {
		if (condition == null) {
			condition = new RuleBusinessInteractionCondition();
		}
		logger.error("传入的参数：{}", condition);
		List<RuleBusinessInteractionModel> ruleBusinessInteractionModel = ruleBusinessInteractionService.CalculationPreferentialAmount(condition);
		List<RuleBusinessInteractionVo> Vo = EntityCopyUtils.copyList(ruleBusinessInteractionModel, RuleBusinessInteractionVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleBusinessInteractionVo>>(ResponseVo.success("查询成功", Vo), HttpStatus.OK);
	}
}
