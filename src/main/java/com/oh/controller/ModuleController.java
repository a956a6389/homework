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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oh.Constant;
import com.oh.bean.Module;
import com.oh.service.ModuleService;

/***
 * 
 * @ClassName: ModuleController
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 2:10:02 PM
 *
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
	private static Logger LOG = LoggerFactory.getLogger("errorFile");
	
	@Autowired
	private ModuleService moduleService;

	/***
	 * 
	* @Description: query all module info.
	* @param request
	* @param response
	* @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	ModelAndView list(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("module/list");
		try {
			model.addObject("modules", moduleService.queryModules(null, null, null));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	ModelAndView add(@ModelAttribute @Valid Module module, BindingResult result, HttpServletRequest request, 
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:/module/list");
		if(result.hasErrors() || null == module || !StringUtils.isNoneBlank(module.getUrl()) 
				|| !StringUtils.isNoneBlank(module.getEnName())){
			model.setViewName("module/add");
			return model;
		}
		
		try {
			moduleService.insert(module);
		} catch (Exception e) {
			LOG.error("Add module exception: {}", e.getMessage());
			model.addObject(Constant.ERROR, e.getMessage());
			model.addObject("module", module);
			model.setViewName("module/add");
		}
			
		model.addObject("modules", moduleService.queryModules(null, null, null));
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView("module/add");
		model.addObject("module", new Module());
		model.addObject(Constant.TYPE, "Add");
		model.addObject(Constant.ACTION, "/module/add");
		return model;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	ModelAndView details(@RequestParam Integer id){
		ModelAndView model = new ModelAndView("module/add");
		Module module = new Module();
		module.setId(id);
		model.addObject("module", moduleService.queryModules(module, null, null));
		model.addObject(Constant.TYPE, "Update");
		model.addObject(Constant.ACTION, "/module/update");
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	ModelAndView update(@ModelAttribute @Valid Module module, BindingResult result, HttpServletRequest request, 
			HttpServletResponse response){
		ModelAndView model = new ModelAndView("redirect:/module/list");
		if(result.hasErrors() || null == module || !StringUtils.isNoneBlank(module.getUrl()) 
				|| !StringUtils.isNoneBlank(module.getEnName())){
			model.setViewName("redirect:/module/view");
			return model;
		}
		
		try {
			moduleService.updateModule(module);
		} catch (Exception e) {
			LOG.error("Add module exception: {}", e.getMessage());
		}
			
		model.addObject("modules", moduleService.queryModules(null, null, null));
		return model;
	}
}
