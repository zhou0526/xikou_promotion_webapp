package com.xikou.promotion.controller.rule;

import com.xikou.promotion.api.condition.RuleCondition;
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
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.RuleModel;
import com.xikou.promotion.api.service.rule.RuleService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.RuleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags ="规则管理接口")
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
    @RequestMapping(value = "/deleteSepc/{id}", method = RequestMethod.POST)
    public ResponseEntity<RuleVo> deleteRule(@PathVariable("id") String id) throws BusinessException {

        try {
            ruleService.deleteRule(id);
        } catch (BusinessException ex) {
            return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity(ResponseVo.success("删除成功", id), HttpStatus.OK);
    }

}
