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

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.oh.bean.Module;
import com.oh.bean.Role;
import com.oh.service.ModuleService;
import com.oh.service.RoleModuleService;

/**
 * @ClassName: MySecurityMetadataSource
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:48:45 PM
 *
 */
@Service("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private ModuleService moduleService;

	@Autowired
	private RoleModuleService roleModuleService;

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
		Collection<ConfigAttribute> configAttributes = null;
		loadResourceDefine();
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if(requestUrl.indexOf("?")>-1){
			requestUrl = requestUrl.substring(0,requestUrl.indexOf("?"));
		}
		if(MapUtils.isNotEmpty(resourceMap)){
			configAttributes = resourceMap.get(requestUrl);
		}
		/*if(CollectionUtils.isEmpty(configAttributes)){
			configAttributes = new ArrayList<>();
			configAttributes.add(new SecurityConfig("ROLE_USER"));
		}*/
		return configAttributes;
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

//	@PostConstruct
	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			Map<Integer, List<Role>> moduleRoles = roleModuleService.readModuleToRoles();
			Map<Integer, Module> moduleCacheMap = moduleService.queryAllModulesMap();
			for (Map.Entry<Integer, List<Role>> entry : moduleRoles.entrySet()) {
				Module tempModule = moduleCacheMap.get(entry.getKey());

				for (Role role : entry.getValue()) {
					if (!resourceMap.containsKey(tempModule.getUrl())) {
						Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
						ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + role.getRoleName());
						configAttributes.add(configAttribute);
						resourceMap.put(tempModule.getUrl(), configAttributes);
					}else{
						Collection<ConfigAttribute> configAttributes = resourceMap.get(tempModule.getUrl());
						ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + role.getRoleName());
						configAttributes.add(configAttribute);
						resourceMap.put(tempModule.getUrl(), configAttributes);
					}
				}
			}
		}
	}
}
