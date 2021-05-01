/**  
 * @Title: UserRoleService.java
 * @Package com.oh.service
 *
 */
package com.oh.service;

import java.util.List;
import java.util.Map;

import com.oh.bean.UserRole;

/**
 * @ClassName: UserRoleService
 * @Description: TODO
 * @author yi.he
 * @date Mar 20, 2017 2:22:55 PM
 *
 */
public interface UserRoleService {
	/***
	 * 
	 * @Description: insert user role info.
	 * @param userRole
	 * @return int
	 * @throws Exception
	 */
	int insert(UserRole userRole) throws Exception;

	/***
	 * 
	 * @Description: query one user role
	 * @param userRole
	 * @return UserRole
	 */
	UserRole queryUserRole(UserRole userRole);

	/***
	 * 
	 * @Description: delete the userRole by id
	 * @param userRole
	 * @return int
	 */
	int delete(UserRole userRole);

	/***
	 * 
	 * @Description: update user role
	 * @param userRole
	 * @return int
	 */
	int update(UserRole userRole);
	
	/***
	 * 
	 * @Description: batch read user role of users
	 * @param paramMap
	 * @return List<UserRole> or null
	 */
	List<UserRole> findUserRoleByIds(Map<String, Object> paramMap);
}
