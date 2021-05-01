/**
 * 
 */
package com.oh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/***
 * 
 * @ClassName: IndexController
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 5:39:18 PM
 *
 */
@Controller
public class IndexController {
	/**
	 * 
	 */
	public IndexController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	ModelAndView index(ModelAndView model){
		model.setViewName("index");
		return model;
	}
}
