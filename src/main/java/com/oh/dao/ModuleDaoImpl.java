/**  
 * @Title: ModuleDao.java
 * @Package com.oh.service
 *
 */ 
package com.oh.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<Module> queryModules(Module module, Integer start, Integer end) {
		List<Module> modules = baseDao.queryForList("module.queryModules", new Object[]{module, null == start ? 0 : start, null == end ? 1 : end});
		LOG.info("all modules size={}", modules.size());
		return modules;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#insert(com.oh.bean.Module)
	 */
	@Override
	public int insert(Module module){
		Module exsitModule = baseDao.queryForObject("module.selectOneModule", module);
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

}
