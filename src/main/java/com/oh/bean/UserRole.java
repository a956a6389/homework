/**  
 * @Title: UserRole.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;

/**
 * @ClassName: UserRole
 * @Description: TODO
 * @author yi.he
 * @date Mar 20, 2017 2:16:06 PM
 *
 */
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7464797873202102294L;

	private long id;
	private long roleId;
	private long userId;
	/**
	 * 
	 */
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

}
