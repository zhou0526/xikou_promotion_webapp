package com.xikou.promotion.exception;

import com.xikou.promotion.common.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.weibo.api.motan.exception.MotanServiceException;

@ControllerAdvice
public class WebAppGlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebAppGlobalExceptionHandler.class);

	// NoHandler错误
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ResponseVo> handle(NoHandlerFoundException ex) {

		String message = "HTTP '" + ex.getHttpMethod() + "' for '" + ex.getRequestURL() + "' is not found.";
		logger.error("NoHandler错误:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.NOT_FOUND.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// 缺少参数错误
	@ExceptionHandler({ MissingServletRequestParameterException.class })
	public ResponseEntity<ResponseVo> requestMissingServletRequest(MissingServletRequestParameterException ex) {

		String message = "Required " + ex.getParameterType() + " parameter '" + ex.getParameterName() + "' is not present.";
		logger.error("MissingServletRequestParameterException:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.BAD_REQUEST.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	// 405错误
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	public ResponseEntity<ResponseVo> request405(HttpRequestMethodNotSupportedException ex) {

		String message = "Request " + ex.getMethod() + " is not supported.";
		logger.error("405错误:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.METHOD_NOT_ALLOWED.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
	}

	// 406错误
	@ExceptionHandler({ HttpMediaTypeNotAcceptableException.class })
	public ResponseEntity<ResponseVo> request406(HttpMediaTypeNotAcceptableException ex) {

		String message = "MediaType is not acceptable.";
		logger.error("406错误:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.NOT_ACCEPTABLE.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}

	// 500错误
	@ExceptionHandler({ ConversionNotSupportedException.class, HttpMessageNotWritableException.class })
	public ResponseEntity<ResponseVo> server500(RuntimeException ex) {

		String message = "Internal Server Error: " + ex;
		logger.error("500错误:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// motan服务不可用错误
	@ExceptionHandler({ MotanServiceException.class })
	public ResponseEntity<ResponseVo> motanServiceException(MotanServiceException ex) {

		String message = "motan服务异常: " + ex;
		logger.error("motan服务异常:" + ex, WebAppGlobalExceptionHandler.class);
		ResponseVo error = new ResponseVo(HttpStatus.SERVICE_UNAVAILABLE.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
	}

	// 其他错误
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ResponseVo> exception(Exception ex) {

		String message = "Other Error: " + ex;
		logger.error("Other Error:", ex);
		ResponseVo error = new ResponseVo(HttpStatus.INTERNAL_SERVER_ERROR.value(), message, "");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
