package com.xikou.promotion.controller.spec;

import java.util.List;

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
import com.xikou.promotion.api.condition.SpecCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.SpecModel;
import com.xikou.promotion.api.service.spec.SpecService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.IdListVo;
import com.xikou.promotion.vo.SpecVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "规格管理接口")
@RestController
@RequestMapping("/promotion/sepc")

public class SpecController {

	private static final Logger logger = LoggerFactory.getLogger(SpecController.class);

	@Autowired
	private SpecService specService;

	@ApiOperation(value = "新增规格", notes = "新增规格")
	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveSepc(@RequestBody SpecVo SpecVo) throws BusinessException {
		try {
			specService.saveSepc(EntityCopyUtils.copyBean(SpecVo, SpecModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新增成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "根据条件分页查询规格", notes = "规格名称")
	@ResponseBody
	@RequestMapping(value = "/sepcs", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<SpecVo>> querySepc(SpecCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		if (condition == null) {
			condition = new SpecCondition();
		}
		logger.error("传入的参数：{}", condition);
		PaginationModel<SpecModel> specModel = specService.querySepc(condition, (page - 1) * limit, limit);
		PaginationVo<SpecVo> specVo = VoConvertor.convertPaginationModelToVo(specModel, SpecVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<SpecVo>>(ResponseVo.success("查询成功", specVo), HttpStatus.OK);
	}

	@ApiOperation(value = "根据ID逻辑删除规格", notes = "根据ID逻辑删除规格")
	@ResponseBody
	@RequestMapping(value = "/deleteSepc/{id}", method = RequestMethod.POST)
	public ResponseEntity<SpecVo> deleteSepcById(@PathVariable("id") String id) throws BusinessException {

		try {
			specService.deleteSepc(id);
		} catch (BusinessException ex) {
			return new ResponseEntity(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity(ResponseVo.success("删除成功", id), HttpStatus.OK);
	}

	@ApiOperation(value = "规则分页查询规格引用", notes = "规则分页查询规格引用")
	@ResponseBody
	@RequestMapping(value = "/SepcQuote", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<SpecVo>> querySepcQuote(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
		PaginationModel<SpecModel> specModel = specService.querySepcQuote((page - 1) * limit, limit);
		PaginationVo<SpecVo> specVo = VoConvertor.convertPaginationModelToVo(specModel, SpecVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<SpecVo>>(ResponseVo.success("查询成功", specVo), HttpStatus.OK);
	}

	@ApiOperation(value = "规则详情查看规格列表", notes = "规则值")
	@ResponseBody
	@RequestMapping(value = "/SepcList", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo<SpecVo>> querySepcList(@RequestBody IdListVo ids) {
		List<SpecModel> specModel = specService.querySepcList(ids.getIds());
		List<SpecVo> specVo = EntityCopyUtils.copyList(specModel, SpecVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<SpecVo>>(ResponseVo.success("查询成功", specVo), HttpStatus.OK);
	}
}
