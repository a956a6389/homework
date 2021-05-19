/**  
 * @Title: RoleModule.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;

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
	private Integer id;
	
	private Integer roleId;

	private Integer moduleId;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

}
