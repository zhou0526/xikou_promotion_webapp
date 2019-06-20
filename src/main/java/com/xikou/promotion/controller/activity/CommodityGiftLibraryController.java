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
import com.xikou.promotion.api.condition.CommodityGiftLibraryCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.CommodityGiftLibraryModel;
import com.xikou.promotion.api.service.activity.CommodityGiftLibraryService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.CommodityGiftLibraryVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */

@RestController
@Api(tags = "商品赠换品库")
@RequestMapping("/promotion/commodityGiftLibrary")
public class CommodityGiftLibraryController {

	private static final Logger logger = LoggerFactory.getLogger(CommodityGiftLibraryController.class);

	@Autowired
	private CommodityGiftLibraryService commodityGiftLibraryService;

	@ApiOperation(value = "商品赠换品库列表", notes = "商品赠换品库列表")
	@ResponseBody
	@RequestMapping(value = "/queryCommodityGiftLibraryList", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<CommodityGiftLibraryVo>> queryActivityCommodityList(CommodityGiftLibraryCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) throws BusinessException {
		if (condition == null) {
			condition = new CommodityGiftLibraryCondition();
		}
		logger.error("传参错误：{}", condition);
		PaginationModel<CommodityGiftLibraryModel> paginationModel = commodityGiftLibraryService.queryCommodityGiftLibraryList(condition, //
			(page - 1) * limit, limit);
		PaginationVo<CommodityGiftLibraryVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, //
			CommodityGiftLibraryVo.class);
		// 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
		return new ResponseEntity<ResponseVo<CommodityGiftLibraryVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
	}

	@ApiOperation(value = "新增商品赠换品库", notes = "新增商品赠换品库")
	@ResponseBody
	@RequestMapping(value = "/saveCommodityGiftLibrary", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> saveCommodityGiftLibrary(@RequestBody CommodityGiftLibraryVo commodityGiftLibraryVo) throws BusinessException {
		try {
			commodityGiftLibraryService.saveCommodityGiftLibrary(EntityCopyUtils.copyBean(commodityGiftLibraryVo, //
				CommodityGiftLibraryModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "修改商品赠换品库", notes = "修改商品赠换品库")
	@ResponseBody
	@RequestMapping(value = "/modifyCommodityGiftLibrary", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyCommodityGiftLibrary(@RequestBody CommodityGiftLibraryVo commodityGiftLibraryVo) throws BusinessException {
		try {
			commodityGiftLibraryService.modifyCommodityGiftLibrary(EntityCopyUtils.copyBean(commodityGiftLibraryVo, //
				CommodityGiftLibraryModel.class));
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
	}

	@ApiOperation(value = "查看商品赠换品库", notes = "查看商品赠换品库")
	@ResponseBody
	@RequestMapping(value = "/queryCommodityGiftLibraryById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo<CommodityGiftLibraryVo>> queryCommodityGiftLibraryById(@PathVariable String id) throws BusinessException {
		try {
			CommodityGiftLibraryVo commodityGiftLibraryVo = EntityCopyUtils.copyBean(commodityGiftLibraryService.queryCommodityGiftLibraryById(id), CommodityGiftLibraryVo.class);
			return new ResponseEntity<>(ResponseVo.success("操作成功", commodityGiftLibraryVo), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

	@ApiOperation(value = "删除商品赠换品库", notes = "删除商品赠换品库")
	@ResponseBody
	@RequestMapping(value = "/deleteCommodityGiftLibraryById/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteCommodityGiftLibraryById(@PathVariable String id) throws BusinessException {
		try {
			commodityGiftLibraryService.deleteCommodityGiftLibraryById(id);
			return new ResponseEntity<>(ResponseVo.success("操作成功", ""), HttpStatus.OK);
		} catch (BusinessException ex) {
			return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
		}
	}

}
