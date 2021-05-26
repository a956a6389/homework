/**  
 * @Title: GlobalExceptionResolver.java
 * @Package com.oh.exception
 *
 */ 
package com.oh.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: GlobalExceptionResolver
 * @Description: TODO
 * @author Owen.he
 * @date Apr 25, 2017 2:43:30 PM
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error");
		return modelAndView;
	}

}
