package com.spring.api.rest.controller.v1;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.spring.error.CustomError;
import com.spring.service.UserService;

@Controller
@RequestMapping("/api/rest/v1/non-blocking")
public class NonBlockingController {
	
	private static final Logger logger = LoggerFactory.getLogger(NonBlockingController.class);
	
	@Resource
	private UserService userService;
	
	private MessageSourceAccessor messageSourceAccessor;
	
	@Resource
    public void setMessageSource(MessageSource messageSource) {
        this.messageSourceAccessor = new MessageSourceAccessor(messageSource);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
    public DeferredResult<String> square() {
		final DeferredResult<String> deferredResult = new DeferredResult<>();
		runInOtherThread(deferredResult);
		return deferredResult;
	}
	
	private void runInOtherThread(DeferredResult<String> deferredResult) {
		deferredResult.setResult("HTTP response is: 42");
	}
	
	 @ExceptionHandler(Exception.class)
	  public @ResponseBody CustomError handleRuntimeException(Exception exception, HttpServletResponse httpResponse) {
	      logger.error(messageSourceAccessor.getMessage("error.processing"), exception);
	      CustomError error = new CustomError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
	              messageSourceAccessor.getMessage("error.internal.error"));
	      httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	      return error;
	  }
}
