/**  
 * @Title: RoleModuleServiceImpl.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oh.bean.Module;
import com.oh.bean.Role;
import com.oh.bean.RoleModule;
import com.oh.dao.RoleModuleDao;

/**
 * @ClassName: RoleModuleServiceImpl
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 1:36:08 PM
 *
 */
@Service
public class RoleModuleServiceImpl implements RoleModuleService {
	@Autowired
	private RoleModuleDao roleModuleDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ModuleService moduleService;

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#queryRoleModules(com.oh.bean.RoleModule, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<RoleModule> queryRoleModules(RoleModule roleModule, Integer start, Integer end) {
		return roleModuleDao.queryRoleModules(roleModule, start, end);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#insert(com.oh.bean.RoleModule)
	 */
	@Override
	public int insert(RoleModule roleModule) throws Exception {
		return roleModuleDao.insert(roleModule);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#deleteRoleModule(int)
	 */
	@Override
	public int deleteRoleModule(int id) {
		return roleModuleDao.deleteRoleModule(id);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#batchDeleteRoleModules(int[])
	 */
	@Override
	public int batchDeleteRoleModules(int[] ids) {
		return roleModuleDao.batchDeleteRoleModules(ids);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#updateRoleModule(com.oh.bean.RoleModule)
	 */
	@Override
	public int updateRoleModule(RoleModule roleModule) {
		return roleModuleDao.updateRoleModule(roleModule);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#readModuleToRoles()
	 */
	@Override
	public Map<Integer, List<Role>> readModuleToRoles() {
		List<RoleModule> roleModules = this.queryRoleModules(null, null, null);
		Map<Integer, List<Role>> retMap = new HashMap<>(roleModules.size());
		Map<Integer, Role> roleCacheMap = roleService.queryAllRolesMap();
		for (RoleModule roleModule : roleModules) {
			if(retMap.containsKey(roleModule.getModuleId())){
				List<Role> roles = retMap.get(roleModule.getModuleId());
				roles.add(roleCacheMap.get(roleModule.getRoleId()));
			}else{
				List<Role> roles = new ArrayList<>(roleModules.size());
				roles.add(roleCacheMap.get(roleModule.getRoleId()));
				retMap.put(roleModule.getModuleId(), roles);
			}
		}
		return retMap;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#readRoleToModules()
	 */
	@Override
	public Map<Integer, List<Module>> readRoleToModules() {
		List<RoleModule> roleModules = this.queryRoleModules(null, null, null);
		Map<Integer, List<Module>> retMap = new HashMap<>(roleModules.size());
		Map<Integer, Module> moduleCacheMap = moduleService.queryAllModulesMap();
		for (RoleModule roleModule : roleModules) {
			Module temp = moduleCacheMap.get(roleModule.getModuleId());
			if(retMap.containsKey(roleModule.getRoleId())){
				List<Module> modules = retMap.get(roleModule.getRoleId());
				modules.add(temp);
			}else{
				List<Module> modules = new ArrayList<>(roleModules.size());
				modules.add(temp);
				retMap.put(roleModule.getRoleId(), modules);
			}
		}
		return retMap;
	}

	/**
	 * @see com.oh.service.RoleModuleService#deleteRoleModuleByRoleIds(int[])
	 */
	@Override
	public int deleteRoleModuleByRoleIds(int[] ids) {
		return roleModuleDao.deleteRoleModuleByRoleIds(ids);
	}

	/**
	 * @see com.oh.service.RoleModuleService#batchInsert(java.util.List)
	 */
	@Override
	public int batchInsert(List<RoleModule> roleModules) {
		return roleModuleDao.batchInsert(roleModules);
	}

}
