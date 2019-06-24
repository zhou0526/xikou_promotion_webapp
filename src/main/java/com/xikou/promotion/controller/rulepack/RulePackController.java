package com.xikou.promotion.controller.rulepack;

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
import com.xikou.promotion.api.condition.RulePackCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.RulePackModel;
import com.xikou.promotion.api.service.rulepack.RulePackService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.DetailsVo;
import com.xikou.promotion.vo.RulePackVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "规则包管理接口")
@RestController
@RequestMapping("/promotion/rulepack")

public class RulePackController {
	private static final Logger logger = LoggerFactory.getLogger(RulePackController.class);
	@Autowired
	private RulePackService rulePackService;

	@ApiOperation(value = "新增规则包", notes = "新增规则包")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveRulePack(@RequestBody RulePackVo RulePackVo) throws BusinessException {
		try {
			rulePackService.saveRulePack(EntityCopyUtils.copyBean(RulePackVo, RulePackModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据条件分页查询规则包", notes = "规则包名称,规则包分类")
	@ResponseBody
	@RequestMapping(value = "/rulepacks", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<RulePackVo>> queryRule(RulePackCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new RulePackCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<RulePackModel> rulePackModel = rulePackService.queryRulePack(condition, (page - 1) * limit, limit);
		PaginationVo<RulePackVo> RulePackVo = VoConvertor.convertPaginationModelToVo(rulePackModel, RulePackVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RulePackVo>>(ResponseVo.success("查询成功", RulePackVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID逻辑删除规则包", notes = "根据ID逻辑删除规则包")
	@ResponseBody
	@RequestMapping(value = "/deleteSepc/{id}", method = RequestMethod.POST)
	public ResponseEntity<RulePackVo> deleteRulePack(@PathVariable("id") String id) throws BusinessException {

		try {
			rulePackService.deleteRulePack(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", id), HttpStatus.OK);
	}

	@ApiOperation(value = "根据活动或活动商品分页查询规格包引用", notes = "规则包分类")
	@ResponseBody
	@RequestMapping(value = "/RulePackQuote/{packType}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<RulePackVo>> querySepcQuote(@PathVariable("packType") Byte packType, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		PaginationModel<RulePackModel> rulePackModel = rulePackService.queryRulePackQuote(packType, (page - 1) * limit, limit);
		PaginationVo<RulePackVo> rulePackVo = VoConvertor.convertPaginationModelToVo(rulePackModel, RulePackVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RulePackVo>>(ResponseVo.success("查询成功", rulePackVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID删除规则值得规则ID", notes = "根据ID删除规则值得规则ID")
	@ResponseBody
	@RequestMapping(value = "/deleteRuleValueRef", method = RequestMethod.POST)
	public ResponseEntity<RulePackVo> deleteRulePackValueRef(@RequestBody DetailsVo detailsVo) throws BusinessException {
		try {
			rulePackService.deleteRulePackValueRef(detailsVo.getId(), detailsVo.getValueRef());
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", detailsVo.getId()), HttpStatus.OK);
	}

	@ApiOperation(value = "添加规则包详情", notes = "规则包id，规则包值")
	@ResponseBody
	@RequestMapping(value = "/modifyRulePack", method = RequestMethod.POST)
	public ResponseEntity<RulePackVo> modifyRulePack(@RequestBody DetailsVo detailsVo) throws BusinessException {
		try {
			rulePackService.modifyRulePack(detailsVo.getId(), detailsVo.getValueRef());
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("添加成功", ""), HttpStatus.OK);
	}
}
