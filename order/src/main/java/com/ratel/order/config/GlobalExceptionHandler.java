package com.ratel.order.config;

import com.ratel.common.exception.ErrorMsg;
import com.ratel.common.exception.ServiceException;
import com.ratel.common.response.ApiResponse;
import com.ratel.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * global exception handler
 *
 * @author daiyun
 * @date 2020/8/19
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ServiceException.class)
	public ApiResponse<Object> exceptionHandler(HttpServletRequest httpRequest, HttpServletResponse response, Exception e){
		Map<String, String[]> params = httpRequest.getParameterMap();
		ServiceException serviceException = (ServiceException) e;
		ErrorMsg errorMsg = serviceException.getErrorMsg();
		ApiResponse<Object> apiResponse = null;
		if (errorMsg != null) {
			log.error("failure params:{}, message:{}", JsonUtils.toJson(params), JsonUtils.toJson(errorMsg));
			apiResponse = new ApiResponse<>().setRetCode(errorMsg.getCode()).setRetMsg(errorMsg.getMsg());
		}
		response.setStatus(HttpStatus.OK.value());
		return apiResponse;
	}
}
