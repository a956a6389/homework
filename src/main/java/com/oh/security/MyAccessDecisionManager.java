/**  
 * @Title: MyAccessDecisionManager.java
 * @Package com.oh.security
 *
 */
package com.oh.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

/**
 * @ClassName: MyAccessDecisionManager
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:45:39 PM
 *
 */
public class MyAccessDecisionManager implements AccessDecisionManager {
	private static Logger LOG = LoggerFactory.getLogger("run");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		String url = ((FilterInvocation) object).getRequestUrl();
		if (configAttributes == null) {
			LOG.info("The {} need't to authentication", url);
			return;
		}
		// 所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			// 访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			LOG.info("The {} need permission {}, user permissions {}", new Object[]{url, needPermission, authentication.getAuthorities()});
			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (ga.getAuthority().equals(needPermission)) {
					LOG.info("Authentication sucess URL {} permissions {} ", new Object[]{url, ga.getAuthority()});
					return;
				}
			}
		}
		// 没有权限
		LOG.warn("No Access Permission");
		throw new AccessDeniedException(" No Access Permission! ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(org.
	 * springframework.security.access.ConfigAttribute)
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(java.
	 * lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
