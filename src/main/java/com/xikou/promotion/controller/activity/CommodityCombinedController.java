package com.xikou.promotion.controller.activity;

import com.xikou.common.model.PaginationModel;
import com.xikou.common.model.PaginationVo;
import com.xikou.common.utils.EntityCopyUtils;
import com.xikou.common.utils.VoConvertor;
import com.xikou.promotion.api.condition.CommodityCombinedCondition;
import com.xikou.promotion.api.exception.BusinessException;
import com.xikou.promotion.api.model.CommodityCombinedModel;
import com.xikou.promotion.api.service.activity.CommodityCombinedService;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.vo.CommodityCombinedVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 描述：
 * <p>
 *
 * @Author Yun zhao
 * @createby ${date}
 */
@RestController
@Api(tags = "组合商品")
@RequestMapping("/promotion/commodityCombined")
public class CommodityCombinedController {

    private static final Logger logger = LoggerFactory.getLogger(CommodityCombinedController.class);

    @Autowired
    private CommodityCombinedService commodityCombinedService;

    @ApiOperation(value = "组合商品库列表", notes = "组合商品库列表")
    @ResponseBody
    @RequestMapping(value = "/queryCommodityCombinedList", method = RequestMethod.GET)
    public ResponseEntity<ResponseVo<CommodityCombinedVo>> queryActivityCommodityList(CommodityCombinedCondition condition, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) throws BusinessException {
        if (condition == null) {
            condition = new CommodityCombinedCondition();
        }
        logger.error("传参错误：{}", condition);
        PaginationModel<CommodityCombinedModel> paginationModel = commodityCombinedService.queryCommodityCombinedList(condition, //
                (page - 1) * limit, limit);
        PaginationVo<CommodityCombinedVo> paginationVo = VoConvertor.convertPaginationModelToVo(paginationModel, //
                CommodityCombinedVo.class);
        // 返回200只表示网络请求成功 只有当ResponseVo的code为1时才代表接口响应返回成功!
        return new ResponseEntity<ResponseVo<CommodityCombinedVo>>(ResponseVo.success("查询成功", paginationVo), HttpStatus.OK);
    }

    @ApiOperation(value = "新增组合商品", notes = "新增组合商品")
    @ResponseBody
    @RequestMapping(value = "/saveCommodityCombined", method = RequestMethod.POST)
    public ResponseEntity<ResponseVo> saveCommodityCombined(@RequestBody CommodityCombinedVo CommodityCombinedVo) throws BusinessException {
        try {
            commodityCombinedService.saveCommodityCombined(EntityCopyUtils.copyBean(CommodityCombinedVo, //
                    CommodityCombinedModel.class));
        } catch (BusinessException ex) {
            return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
    }

    @ApiOperation(value = "修改组合商品", notes = "修改组合商品")
    @ResponseBody
    @RequestMapping(value = "/modifyCommodityCombined", method = RequestMethod.POST)
    public ResponseEntity<ResponseVo> modifyCommodityCombined(@RequestBody CommodityCombinedVo CommodityCombinedVo) throws BusinessException {
        try {
            commodityCombinedService.modifyCommodityCombined(EntityCopyUtils.copyBean(CommodityCombinedVo, //
                    CommodityCombinedModel.class));
        } catch (BusinessException ex) {
            return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResponseVo.success("修改成功", ""), HttpStatus.OK);
    }

    @ApiOperation(value = "查看组合商品", notes = "查看组合商品")
    @ResponseBody
    @RequestMapping(value = "/queryCommodityCombinedById/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseVo<CommodityCombinedVo>> queryCommodityCombinedById(@PathVariable String id) throws BusinessException {
        try {
            CommodityCombinedVo CommodityCombinedVo = EntityCopyUtils.copyBean(commodityCombinedService.queryCommodityCombinedById(id), CommodityCombinedVo.class);
            return new ResponseEntity<>(ResponseVo.success("操作成功", CommodityCombinedVo), HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "删除组合商品", notes = "删除组合商品")
    @ResponseBody
    @RequestMapping(value = "/deleteCommodityCombinedById/{id}", method = RequestMethod.POST)
    public ResponseEntity<ResponseVo> deleteCommodityCombinedById(@PathVariable String id) throws BusinessException {
        try {
            commodityCombinedService.deleteCommodityCombinedById(id);
            return new ResponseEntity<>(ResponseVo.success("操作成功", ""), HttpStatus.OK);
        } catch (BusinessException ex) {
            return new ResponseEntity<>(ResponseVo.unsuccess(ex.getMessage()), HttpStatus.OK);
        }
    }
}
