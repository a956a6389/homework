/**  
 * @Title: UserUtil.java
 * @Package com.oh.util
 *
 */
package com.oh.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.oh.security.CustomSecurityUser;

/**
 * @ClassName: UserUtil
 * @Description: TODO
 * @author Owen.he
 * @date Apr 25, 2017 1:38:38 PM
 *
 */
public class UserUtil {

	public static CustomSecurityUser getPrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (null != principal && !(principal instanceof AnonymousAuthenticationToken)) {
			return (CustomSecurityUser) principal;
		} 
		return null;
	}
}
