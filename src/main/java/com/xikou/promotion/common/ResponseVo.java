package com.xikou.promotion.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseVo<T> {

	@ApiModelProperty(value = "返回码：0: 正确, 非0: 错误码")
	private int code;
	@ApiModelProperty(value = "返回码消息提示")
	private String msg;
	@ApiModelProperty(value = "返回码数据")
	private T data;

	public ResponseVo(int code, String msg, T data) {

		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static ResponseVo unsuccess(String msg) {

		return buildResponseInfo(1, msg, null);
	}

	public static ResponseVo success(String msg, Object data) {

		return buildResponseInfo(0, msg, data);
	}

	private static ResponseVo buildResponseInfo(int code, String msg, Object data) {

		return new ResponseVo<>(code, msg, data);
	}

}
