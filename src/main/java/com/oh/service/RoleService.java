/**  
 * @Title: RoleService.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.List;
import java.util.Map;

import com.oh.bean.Role;

/**
 * @ClassName: RoleService
 * @Description: TODO
 * @author yi.he
 * @date Mar 9, 2017 9:44:47 AM
 *
 */
public interface RoleService {
	/***
	 * 
	 * @Description query all roles
	 * @return
	 */
	List<Role> queryAllRoles();

	/***
	 * 
	* @Description: insert role info.
	* @param role
	* @return
	* @throws Exception
	 */
	int insert(Role role) throws Exception;
	
	/***
	 * 
	* @Description: query one role
	* @param role
	* @return User
	 */
	Role queryRole(Role role);
	
	/***
	 * 
	 * @Description: delete the role by id
	 * @param id
	 * @return int
	 */
	int deleteRole(int id);
	
	/***
	 * 
	 * @Description: batch delete the roles
	 * @param ids
	 * @return int
	 */
	int batchDeleteRoles(int[] ids);

	/***
	 * 
	 * @Description: update role
	 * @param role
	 * @return Role
	 */
	int updateRole(Role role);
	
	/***
	 * 
	 * @Description: return the map of all roles
	 * @return Map<Integer, Role>
	 */
	Map<Integer, Role> queryAllRolesMap();
	
}
