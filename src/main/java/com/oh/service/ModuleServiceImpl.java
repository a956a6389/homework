/**  
 * @Title: ModuleServiceImpl.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return moduleDao.insert(module);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.ModuleService#deleteModule(int)
	 */
	@Override
	public int deleteModule(int id) {
		return moduleDao.deleteModule(id);
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
		return moduleDao.updateModule(module);
	}

}
