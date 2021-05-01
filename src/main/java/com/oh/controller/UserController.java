/**
 * 
 */
package com.oh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oh.Constant;
import com.oh.bean.User;
import com.oh.service.RoleService;
import com.oh.service.UserService;
import com.oh.type.UserStatus;

/**
 * 
 * @ClassName: UserController
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 4:42:15 PM
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private static Logger LOG = LoggerFactory.getLogger("errorFile");
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	/**
	 * 
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@InitBinder
	protected void initBinder(WebDataBinder webDataBinder){
//		webDataBinder.convertIfNecessary(webDataBinder.getTarget(), Role.class);
	}
	
	/***
	 * 
	* @Description: query all user info.
	* @param request
	* @param response
	* @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("user/list");
		try {
			model.addObject("users", userService.queryAllUser());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	ModelAndView add(@ModelAttribute @Valid User user, BindingResult result, HttpServletRequest request, 
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:/user/list");
		if(result.hasErrors() || null == user || 
				!StringUtils.isNoneBlank(user.getEmail()) || !StringUtils.isNoneBlank(user.getPassword()) ){
			model.setViewName("user/add");
			model.addObject("roles", roleService.queryAllRoles());
			model.addObject("statuss", UserStatus.values());
			return model;
		}
		
		user.setIp(request.getRemoteAddr());
		try {
			userService.insert(user);
		} catch (Exception e) {
			LOG.error("Add user exception: {}", e.getMessage());
			model.addObject(Constant.ERROR, e.getMessage());
			model.addObject("user", user);
			model.setViewName("user/add");
		}
			
		model.addObject("users", userService.queryAllUser());
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("user/add");
		model.addObject("user", new User());
		model.addObject("roles", roleService.queryAllRoles());
		model.addObject(Constant.TYPE, "Add");
		model.addObject(Constant.ACTION, "/user/add");
		model.addObject("statuss", UserStatus.values());
		return model;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	ModelAndView details(@RequestParam Long id){
		ModelAndView model = new ModelAndView("user/add");
		User user = new User();
		user.setId(id);
		model.addObject("user", userService.queryUser(user));
		model.addObject("roles", roleService.queryAllRoles());
		model.addObject("statuss", UserStatus.values());
		model.addObject(Constant.TYPE, "Update");
		model.addObject(Constant.ACTION, "/user/update");
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	ModelAndView update(@ModelAttribute @Valid User user, BindingResult result, HttpServletRequest request, 
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:/user/list");
		if(result.hasErrors() || null == user || 
				!StringUtils.isNoneBlank(user.getEmail()) || !StringUtils.isNoneBlank(user.getPassword()) ){
		/*	model.setViewName("user/add");
			model.addObject("roles", roleService.queryAllRoles());
			model.addObject("statuss", UserStatus.values());*/
			model.setViewName("redirect:/user/view");
			return model;
		}
		
		user.setIp(request.getRemoteAddr());
		try {
			userService.update(user);
		} catch (Exception e) {
			LOG.error("Add user exception: {}", e.getMessage());
		}
			
//		model.addObject("users", userService.queryAllUser());
		return model;
	}
}
