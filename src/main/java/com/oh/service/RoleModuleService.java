/**  
 * @Title: RoleRoleModuleService.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.List;
import java.util.Map;

import com.oh.bean.Module;
import com.oh.bean.Role;
import com.oh.bean.RoleModule;

/**
 * @ClassName: RoleRoleModuleService
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 1:34:26 PM
 *
 */
public interface RoleModuleService {
	/***
	 * 
	 * @Description query roleModules
	 * @return
	 */
	List<RoleModule> queryRoleModules(RoleModule roleModule, Integer start, Integer end);

	/***
	 * 
	* @Description: insert roleModule info.
	* @param roleModule
	* @return
	* @throws Exception
	 */
	int insert(RoleModule roleModule) throws Exception;
	
	/***
	 * 
	 * @Description: delete the roleModule by id
	 * @param id
	 * @return int
	 */
	int deleteRoleModule(int id);
	
	/***
	 * 
	 * @Description: batch delete the roleModules
	 * @param ids
	 * @return int
	 */
	int batchDeleteRoleModules(int[] ids);

	/***
	 * 
	 * @Description: update roleModule
	 * @param roleModule
	 * @return RoleModule
	 */
	int updateRoleModule(RoleModule roleModule);
	
	Map<Integer, List<Role>> readModuleToRoles();
	
	Map<Integer, List<Module>> readRoleToModules();
}
