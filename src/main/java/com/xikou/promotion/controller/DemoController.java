package com.xikou.promotion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.xikou.promotion.common.ResponseVo;
import com.xikou.promotion.constant.ApiConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "web接口")
@RestController(value = "/demo/")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	// GET
	@ApiOperation(value = "分页数据列表展示demo" + ApiConstant.DEVELOPER, notes = "分页数据列表展示demo")
	@ResponseBody
	@RequestMapping(value = "/user/users", method = RequestMethod.GET)
	public ResponseEntity<ResponseVo> userList(int page, int limit) {

		return new ResponseEntity<>(ResponseVo.success("查询成功", ""), HttpStatus.OK);
	}

	// 新建
	@ResponseBody
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> createUser() {

		return new ResponseEntity<>(ResponseVo.success("新建成功", ""), HttpStatus.OK);
	}

	// 修改
	@ResponseBody
	@RequestMapping(value = "/user/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> modifyUserById(@PathVariable("id") String id) {

		return new ResponseEntity<>(ResponseVo.success("修改成功", id), HttpStatus.OK);
	}

	// 删除
	@ResponseBody
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> deleteUserById(@PathVariable("id") String id) {

		return new ResponseEntity<>(ResponseVo.success("删除成功", id), HttpStatus.OK);
	}
}
