package com.xikou.promotion.controller.rule;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.xikou.promotion.api.condition.RuleCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.exception.ExceptionCode;
import com.xikou.promotion.api.model.RuleModel;
import com.xikou.promotion.api.service.rule.RuleService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.constant.RuleType;
import com.xikou.promotion.vo.DetailsVo;
import com.xikou.promotion.vo.IdListVo;
import com.xikou.promotion.vo.RuleTypeVo;
import com.xikou.promotion.vo.RuleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "规则管理接口")
@RestController
@RequestMapping("/promotion/rule")
public class RuleController {
	private static final Logger logger = LoggerFactory.getLogger(RuleController.class);
	@Autowired
	private RuleService ruleService;

	@ApiOperation(value = "新增规则", notes = "新增规则")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveRule(@RequestBody RuleVo RuleVo) throws BusinessException {
		try {
			ruleService.saveRule(EntityCopyUtils.copyBean(RuleVo, RuleModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据条件分页查询规则", notes = "规则名称,规则分类,规则子类引用,促销工具类别")
	@ResponseBody
	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<RuleVo>> queryRule(RuleCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new RuleCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<RuleModel> ruleModel = ruleService.queryRule(condition, (page - 1) * limit, limit);
		PaginationVo<RuleVo> ruleVo = VoConvertor.convertPaginationModelToVo(ruleModel, RuleVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleVo>>(ResponseVo.success("查询成功", ruleVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID逻辑删除规则", notes = "根据ID逻辑删除规则")
	@ResponseBody
	@RequestMapping(value = "/deleteRule/{id}", method = RequestMethod.POST)
	public ResponseEntity<RuleVo> deleteRule(@PathVariable("id") String id) throws BusinessException {

		try {
			ruleService.deleteRule(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", id), HttpStatus.OK);
	}

	@ApiOperation(value = "规则包分页查询规则引用", notes = "规则包分页查询规则引用")
	@ResponseBody
	@RequestMapping(value = "/queryRuleQuote/{packType}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<RuleVo>> queryRuleQuote(@PathVariable("packType") Byte packType, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		PaginationModel<RuleModel> ruleModel = ruleService.queryRuleQuote(packType, (page - 1) * limit, limit);
		PaginationVo<RuleVo> ruleVo = VoConvertor.convertPaginationModelToVo(ruleModel, RuleVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleVo>>(ResponseVo.success("查询成功", ruleVo), HttpStatus.OK);
	}

	@ApiOperation(value = "添加规则详情", notes = "规则id，规则值")
	@ResponseBody
	@RequestMapping(value = "/modifyRule", method = RequestMethod.POST)
	public ResponseEntity<RuleVo> modifyRulePack(@RequestBody DetailsVo detailsVo) throws BusinessException {
		try {
			ruleService.modifyRule(detailsVo.getId(),detailsVo.getValueRef());
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("添加成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "规则包详情查看规则列表", notes = "规则包值")
	@ResponseBody
	@RequestMapping(value = "/ruleList", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo<RuleVo>> queryRuleList(@RequestBody IdListVo ids) {
		List<RuleModel> ruleModel = ruleService.queryRuleList(ids.getIds());
		List<RuleVo> ruleVo = EntityCopyUtils.copyList(ruleModel, RuleVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleVo>>(ResponseVo.success("查询成功", ruleVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID删除规则值得规格ID", notes = "根据ID删除规则值得规格ID")
	@ResponseBody
	@RequestMapping(value = "/deleteRuleRuleValueRef", method = RequestMethod.POST)
	public ResponseEntity<RuleVo> deleteRuleValueRef(@RequestBody DetailsVo detailsVo) throws BusinessException {
		try {
			ruleService.deleteRuleValueRef(detailsVo.getId(), detailsVo.getValueRef());
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", detailsVo.getId()), HttpStatus.OK);
	}

	@ApiOperation(value = "获取规则类型", notes = "获取规则类型")
	@ResponseBody
	@RequestMapping(value = "/queryRuleType", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo<RuleType>> queryRuleType() {
		List<RuleType> PromotionType = RuleType.RuleType();
		List<RuleTypeVo> ruleTypeVo = EntityCopyUtils.copyList(PromotionType, RuleTypeVo.class);

		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleType>>(ResponseVo.success("查询成功", ruleTypeVo), HttpStatus.OK);
	}

	@ApiOperation(value = "获取规则子集类型", notes = "获取规则类型")
    @ResponseBody
    @RequestMapping(value = "/queryRuleSonType/{RuleType}", method = RequestMethod.POST)
    public ResponseEntity<ResponseVo<RuleType>> queryRuleSonType(@RequestBody String ruleType) {
        if (StringUtils.isBlank(ruleType)) {
            throw new BusinessException(ExceptionCode.RULETYPE_IS_NULL_EXCEPTION.getCode(), //
                    ExceptionCode.RULETYPE_IS_NULL_EXCEPTION.getMessage());
        }
        List<RuleType> sonType=null;
        if (ruleType.equals("1")){
            sonType = RuleType.ActivityCommodityType();
         }else if (ruleType.equals("2")){
            sonType = RuleType.PromotionType();
        }else if (ruleType.equals("3")){
            sonType = RuleType.CustomizeType();
        }else if (ruleType.equals("4")){
            sonType = RuleType.DisplayModeType();
        }
        List<RuleTypeVo> ruleTypeVo =EntityCopyUtils.copyList(sonType,RuleTypeVo.class);
        // 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
        return new ResponseEntity<ResponseVo<RuleType>>(ResponseVo.success("查询成功", ruleTypeVo), HttpStatus.OK);
    
    }

	@ApiOperation(value = "获取促销工具类别", notes = "获取促销工具类别")
	@ResponseBody
	@RequestMapping(value = "/queryRuletoolType", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo<RuleType>> queryRuletoolType() {
		List<RuleType> ruleType = RuleType.PromotionToolType();
		List<RuleTypeVo> ruleTypeVo = EntityCopyUtils.copyList(ruleType, RuleTypeVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<RuleType>>(ResponseVo.success("查询成功", ruleTypeVo), HttpStatus.OK);
	}


    @ApiOperation(value = "根据规则子集获取促销工具", notes = "根据规则子集获取促销工具")
    @ResponseBody
    @RequestMapping(value = "/queryConditionRuleSonType", method = RequestMethod.POST)
    public ResponseEntity<ResponseVo<RuleType>> queryConditionRuleSonType(@RequestBody String citationClassification) {
        if (StringUtils.isBlank(citationClassification)) {
            throw new BusinessException(ExceptionCode.RULECHILDREF_IS_NULL_EXCEPTION.getCode(), //
                    ExceptionCode.RULECHILDREF_IS_NULL_EXCEPTION.getMessage());
        }
        List<RuleType> toolType=null;
        if (citationClassification.equals("1")){
			toolType = RuleType.PromotionToolType1();
        }else if (citationClassification.equals("2")){
			toolType = RuleType.PromotionToolType2();
        }else if (citationClassification.equals("3")){
			toolType = RuleType.PromotionToolType3();
        }else if (citationClassification.equals("4")){
			toolType = RuleType.PromotionToolType4();

        }
        List<RuleTypeVo> ruleTypeVo =EntityCopyUtils.copyList(toolType,RuleTypeVo.class);
        // 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
        return new ResponseEntity<ResponseVo<RuleType>>(ResponseVo.success("查询成功", ruleTypeVo), HttpStatus.OK);

    }
}
