/**  
 * @Title: CustomSecurityUser.java
 * @Package com.oh.security
 *
 */ 
package com.oh.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @ClassName: CustomSecurityUser
 * @Description: TODO
 * @author Owen.he
 * @date Apr 25, 2017 11:14:44 AM
 *
 */
public class CustomSecurityUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 * @param userId
	 */
	public CustomSecurityUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, Long userId) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userId = userId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
