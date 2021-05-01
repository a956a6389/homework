/**  
 * @Title: RoleModule.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: RoleModule
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:57:57 PM
 *
 */
public class RoleModule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Role role;

	private List<Module> module;


	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the module
	 */
	public List<Module> getModuleEntity() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModuleEntity(List<Module> module) {
		this.module = module;
	}
}
