/**  
 * @Title: ModuleDao.java
 * @Package com.oh.service
 *
 */ 
package com.oh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.oh.bean.Module;

/**
 * 
 * @ClassName: ModuleDao
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 2:34:15 PM
 *
 */
@Repository
public class ModuleDaoImpl implements ModuleDao{
	private static Logger LOG = LoggerFactory.getLogger("run");
	
	@Autowired
	private BaseDao baseDao;

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#queryModules()
	 */
	@Override
	public List<Module> queryModules(Module module, Integer start, Integer limit) {
		Map<String, Object> param = new HashMap<>(3);
		param.put("module", module);
		param.put("start", start);
		param.put("limit", limit);
		List<Module> modules = baseDao.queryForList("module.queryModule", param);
		LOG.info("all modules size={}", modules.size());
		return modules;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#insert(com.oh.bean.Module)
	 */
	@Override
	public int insert(Module module){
		Module paramModule = new Module();
		paramModule.setUrl(module.getUrl());
		Map<String, Object> param = new HashMap<>(3);
		param.put("module", paramModule);
		param.put("start", 0);
		param.put("limit", 1);
		Module exsitModule = baseDao.queryForObject("module.queryModule", param);
		if(null != exsitModule){
			return 0;
		}
		return baseDao.insert("module.insert", module);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#deleteModule(int)
	 */
	@Override
	public int deleteModule(int id) {
		return baseDao.delete("module.deleteById", id);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#batchDeleteModules(int[])
	 */
	@Override
	public int batchDeleteModules(int[] ids) {
		return baseDao.delete("module.batchDeleteModules", ids);
	}
	
	@Override
	public int updateModule(Module module) {
		return baseDao.update("module.update", module);
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.ModuleDao#queryModule(com.oh.bean.Module)
	 */
	@Override
	public Module queryModule(Module module) {
		List<Module> ms =  this.queryModules(module, 0, 1);
		return CollectionUtils.isEmpty(ms) ? null : ms.get(0);
	}

}
