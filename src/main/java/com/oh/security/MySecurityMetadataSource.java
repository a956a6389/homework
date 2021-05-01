/**  
 * @Title: MySecurityMetadataSource.java
 * @Package com.oh.security
 *
 */
package com.oh.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.oh.bean.Role;
import com.oh.dao.RoleDao;

/**
 * @ClassName: MySecurityMetadataSource
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:48:45 PM
 *
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private RoleDao roleDao;
	
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes(
	 * java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java.
	 * lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@PostConstruct
	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Role> roles = roleDao.queryAllRoles();
			for (Role role : roles) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + role.getRoleName());
				configAttributes.add(configAttribute);
				resourceMap.put(resource.getResUrl(), configAttributes);
			}
		}
}
}
