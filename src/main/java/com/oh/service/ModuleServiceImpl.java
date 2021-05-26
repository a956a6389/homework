/**  
 * @Title: ModuleServiceImpl.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.oh.bean.Module;
import com.oh.dao.ModuleDao;

/**
 * @ClassName: ModuleServiceImpl
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 2:45:12 PM
 *
 */
@Service
public class ModuleServiceImpl implements ModuleService {
	private static Map<Integer, Module> moduleCacheMap = new HashMap<>();
	
	@Autowired
	private ModuleDao moduleDao;

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#queryModules(com.oh.bean.Module, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<Module> queryModules(Module module, Integer start, Integer end) {
		return moduleDao.queryModules(module, start, end);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#insert(com.oh.bean.Module)
	 */
	@Override
	public int insert(Module module) throws Exception {
		int count =  moduleDao.insert(module);
		if(count > 0){
			moduleCacheMap.put(module.getId(), module);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#deleteModule(int)
	 */
	@Override
	public int deleteModule(int id) {
		int count =  moduleDao.deleteModule(id);
		if(count > 0){
			moduleCacheMap.remove(id);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#batchDeleteModules(int[])
	 */
	@Override
	public int batchDeleteModules(int[] ids) {
		return moduleDao.batchDeleteModules(ids);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#updateModule(com.oh.bean.Module)
	 */
	@Override
	public int updateModule(Module module) {
		int count =  moduleDao.updateModule(module);
		if(count > 0){
			moduleCacheMap.put(module.getId(), module);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#queryAllModulesMap()
	 */
	@Override
	public Map<Integer, Module> queryAllModulesMap() {
		if(!CollectionUtils.isEmpty(moduleCacheMap)){
			return moduleCacheMap;
		}
		
		List<Module> modules = this.queryModules(null, null, null);
		for (Module module : modules) {
			moduleCacheMap.put(module.getId(), module);
		}
		return moduleCacheMap;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#selectOneModules(com.oh.bean.Module)
	 */
	@Override
	public Module selectOneModules(Module module) {
		Module retModule = moduleCacheMap.get(module.getId());
		if(null == retModule){
			List<Module> modules =  this.queryModules(module, 0, 1);
			if(!CollectionUtils.isEmpty(modules)){
				retModule = modules.get(0);
				moduleCacheMap.put(module.getId(), retModule);
			}
		}
		return retModule;
	}

}
