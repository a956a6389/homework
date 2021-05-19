/**  
 * @Title: LoginController.java
 * @Package com.oh.controller
 *
 */
package com.oh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oh.bean.User;

/**
 * @ClassName: LoginController
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 10:22:33 AM
 *
 */
@Controller
public class LoginController {

	@RequestMapping("/login/denied")
	public ModelAndView denied() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (null != auth && !(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			modelAndView.addObject("username", userDetail.getUsername());
		}
		modelAndView.setViewName("/login/403");
		setCommon(modelAndView, null);
		return modelAndView;
	}

	@RequestMapping(value = "/login/index", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/login/login");
		modelAndView.addObject("action", "/login");
		setCommon(modelAndView, null);
		return modelAndView;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/login/index");
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/login/logout");
		setCommon(modelAndView, null);
		return modelAndView;
	}

	private void setCommon(ModelAndView modelAndView, User user) {
		modelAndView.addObject("user", null == user ? new User() : user);
	}
}
