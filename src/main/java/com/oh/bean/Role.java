/**  
 * @Title: Role.java
 * @Package com.oh.ben
 *
 */ 
package com.oh.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: Role
 * @Description: Role
 * @author yi.he
 * @date Mar 8, 2017 4:01:54 PM
 *
 */
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8988766785675302789L;

	private int id;
	
	@NotBlank(message = "Role Name is required")
	private String roleName;
	
	/**
	 * 
	 */
	public Role() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
