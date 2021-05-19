/**  
 * @Title: UserDetailService.java
 * @Package com.oh.security
 *
 */
package com.oh.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.oh.bean.Role;
import com.oh.bean.User;
import com.oh.service.RoleService;
import com.oh.service.UserService;

/**
 * @ClassName: UserDetailService
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:14:01 PM
 *
 */
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User paramUser = new User();
		paramUser.setEmail(username);

		User user = userService.queryUser(paramUser);
		if (user == null)
			throw new UsernameNotFoundException(username + " not exist!");

		Map<Integer, Role> roleMap = roleService.queryAllRolesMap();
		user.setRole(roleMap.get(user.getRole().getId()));

		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().trim(), true,
				true, true, true, grantedAuths);
	}

	private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		authSet.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName()));
		return authSet;
	}
}
