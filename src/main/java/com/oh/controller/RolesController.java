/**  
 * @Title: RolesController.java
 * @Package com.oh.controller
 *
 */ 
package com.oh.controller;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oh.Constant;
import com.oh.bean.Role;
import com.oh.service.RoleService;

/**
 * @ClassName: RolesController
 * @Description: Role controller
 * @author yi.he
 * @date Mar 9, 2017 9:14:49 AM
 *
 */
@Controller
@RequestMapping("/role")
public class RolesController {
	
	@Autowired
	private RoleService roleService;

	/**
	 * 
	 */
	public RolesController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(ModelAndView model){
		model.setViewName("role/list");
		model.addObject("roles", roleService.queryAllRoles());
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(ModelAndView model, @Valid Role role, BindingResult result){
		String view = "redirect:/role/list";
		if(result.hasErrors() || null == role || !StringUtils.isNoneBlank(role.getRoleName())){
			model.setViewName("role/add");
//			model.addObject("role", new Role());
			return model;
		}
			
		try {
			int count = roleService.insert(role);
			if(count <= 0){
				view = "role/add";
				model.addObject(Constant.ERROR, "The role is exist");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addObject(Constant.ERROR, e.getMessage());
			model.addObject("role", role);
			view = "role/add";
		}
		
		model.setViewName(view);
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model){
		model.setViewName("role/add");
		model.addObject("role", new Role());
		model.addObject(Constant.TYPE, "Add");
		model.addObject(Constant.ACTION, "/role/add");
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView model, Integer id){
		model.setViewName("role/add");
		Role role = new Role();
		role.setId(id);
		Role retRole = roleService.queryRole(role);
		model.addObject("role", retRole);
		model.addObject(Constant.TYPE, "Update");
		model.addObject(Constant.ACTION, "/role/update");
		return model;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ModelAndView model,  @Valid Role role, BindingResult result){
		String view = "redirect:/role/list";
		if(result.hasErrors() || null == role || !StringUtils.isNoneBlank(role.getRoleName())){
			model.setViewName("role/add");
			return model;
		}
			
		try {
			int count = roleService.updateRole(role);
			if(count <= 0){
				view = "role/add";
				model.addObject(Constant.ERROR, "Update the role is error");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addObject(Constant.ERROR, e.getMessage());
			model.addObject("role", role);
			view = "role/add";
		}
		
		model.setViewName(view);
		return model;
	}
	
	@RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
	public ModelAndView batchDelete(ModelAndView model){
		int[] ids = new int[3];
		roleService.batchDeleteRoles(ids);
		model.setViewName("role/list");
		model.addObject(Constant.MESSAGE, "Delete success.");
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(ModelAndView model, Integer id){
		roleService.deleteRole(id);
		model.setViewName("redirect:/role/list");
		//model.addObject(Constant.MESSAGE, "Delete success.");
		return model;
	}
}
