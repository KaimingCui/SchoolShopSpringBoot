package com.kaiming.o2osb.web.handler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kaiming.o2osb.exceptions.ProductOperationException;
import com.kaiming.o2osb.exceptions.ShopOperationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String, Object> handle(Exception e) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", false);
		if (e instanceof ShopOperationException) {
			modelMap.put("errMsg", e.getMessage());
		} else if (e instanceof ProductOperationException) {
			modelMap.put("errMsg", e.getMessage());
		} else {
			LOG.error("系统出现异常", e.getMessage());
			modelMap.put("errMsg", "未知错误，请联系工作人员进行解决");
		}
		return modelMap;
	}

}
