/**  
 * @Title: ModuleRole.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: ModuleRole
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 1:11:34 PM
 *
 */
public class ModuleRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Module module;
	private List<Role> roles;
	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
