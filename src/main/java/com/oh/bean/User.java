/**  
 * @Title: User.java
 * @Package com.oh.ben
 *
 */
package com.oh.bean;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import com.oh.type.UserStatus;
import com.oh.util.PwdUtil;

/**
 * @ClassName: User
 * @Description: User ben
 * @author yi.he
 * @date Mar 8, 2017 3:59:44 PM
 *
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504314184555852338L;
	
	private Long id;

	/** chinese name **/
	private String cnName;

	private String enName;

	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Email is required")
	private String email;

	private UserStatus status;

	private Date createDate;

	private Date updateDate;

	private String ip;

	private String nickName;
	
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName == null ? null : cnName.trim();
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName == null ? null : enName.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	public String getNickName() {
		return nickName == null ? null : nickName.trim();
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

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

}
