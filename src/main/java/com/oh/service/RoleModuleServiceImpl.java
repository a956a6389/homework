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

import org.apache.commons.collections.MapUtils;
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
	private static Map<Integer, List<Role>> moduleRolesCache = new HashMap<>();
	private static Map<Integer, List<Module>> roleModulesCache = new HashMap<>();
	
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
		if(MapUtils.isNotEmpty(moduleRolesCache)){
			return moduleRolesCache;
		}
		
		List<RoleModule> roleModules = this.queryRoleModules(null, null, null);
		Map<Integer, Role> roleCacheMap = roleService.queryAllRolesMap();
		List<Role> roles = null;
		for (RoleModule roleModule : roleModules) {
			if(moduleRolesCache.containsKey(roleModule.getModuleId())){
				roles = moduleRolesCache.get(roleModule.getModuleId());
				roles.add(roleCacheMap.get(roleModule.getRoleId()));
			}else{
				roles = new ArrayList<>(roleModules.size());
				roles.add(roleCacheMap.get(roleModule.getRoleId()));
			}
			moduleRolesCache.put(roleModule.getModuleId(), roles);
		}
		return moduleRolesCache;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleModuleService#readRoleToModules()
	 */
	@Override
	public Map<Integer, List<Module>> readRoleToModules() {
		if(MapUtils.isNotEmpty(roleModulesCache)){
			return roleModulesCache;
		}
		
		List<RoleModule> roleModules = this.queryRoleModules(null, null, null);
		Map<Integer, Module> moduleCacheMap = moduleService.queryAllModulesMap();
		List<Module> modules = null;
		for (RoleModule roleModule : roleModules) {
			if(moduleCacheMap.containsKey(roleModule.getRoleId())){
				modules = roleModulesCache.get(roleModule.getRoleId());
				modules.add(moduleCacheMap.get(roleModule.getModuleId()));
			}else{
				modules = new ArrayList<>(roleModules.size());
				modules.add(moduleCacheMap.get(roleModule.getModuleId()));
			}
			roleModulesCache.put(roleModule.getRoleId(), modules);
		}
		return roleModulesCache;
	}

}
