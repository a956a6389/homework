package com.oh.dao;

import java.util.List;

import com.oh.bean.RoleModule;

/**
 * 
 * @ClassName: RoleRoleModuleDao
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 1:22:35 PM
 *
 */
public interface RoleModuleDao{
	/***
	 * 
	 * @Description: query roleModules and paging
	 * @param roleModule
	 * @param start 
	 * @param limit   
	 * @return List<RoleModule>
	 */
	public List<RoleModule> queryRoleModules(RoleModule roleModule, Integer start, Integer limit);

	/***
	 * 
	 * @Description: insert roleModule
	 * @param roleModule
	 * @return int
	 */
	public int insert(RoleModule roleModule);

	/***
	 * 
	 * @Description: delete the roleModule
	 * @param id
	 * @return int
	 */
	public int deleteRoleModule(int id) ;

	/***
	 * 
	 * @Description: batch delete the roleModule
	 * @param ids
	 * @return
	 */
	public int batchDeleteRoleModules(int[] ids) ;
	
	/***
	 * 
	 * @Description: Update the roleModule
	 * @param roleModule
	 * @return
	 */
	public int updateRoleModule(RoleModule roleModule) ;
	
	public RoleModule queryRoleModule(RoleModule roleModule);

}
