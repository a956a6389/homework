/**  
 * @Title: RoleModuleImpl.java
 * @Package com.oh.dao
 *
 */ 
package com.oh.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.oh.bean.RoleModule;

/**
 * @ClassName: RoleModuleImpl
 * @Description: TODO
 * @author Owen.he
 * @date Apr 17, 2017 1:24:28 PM
 *
 */
@Repository
public class RoleModuleImpl implements RoleModuleDao {
	
	@Autowired
	private BaseDao baseDao;

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#queryRoleModules(com.oh.bean.RoleModule, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<RoleModule> queryRoleModules(RoleModule roleModule, Integer start, Integer limit) {
		Map<String, Object> param = new HashMap<>(3);
		param.put("roleModule", roleModule);
		param.put("start", start);
		param.put("limit", limit);
		List<RoleModule> modules = baseDao.queryForList("roleModule.queryRoleModule", param);
		return modules;
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#insert(com.oh.bean.RoleModule)
	 */
	@Override
	public int insert(RoleModule roleModule) {
		int count = baseDao.insert("roleModule.insert", roleModule);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#deleteRoleModule(int)
	 */
	@Override
	public int deleteRoleModule(int id) {
		int count = baseDao.delete("roleModule.delete", id);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#batchDeleteRoleModules(int[])
	 */
	@Override
	public int batchDeleteRoleModules(int[] ids) {
		return baseDao.delete("roleModule.batchDeleteRoleModules", ids);
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#updateRoleModule(com.oh.bean.RoleModule)
	 */
	@Override
	public int updateRoleModule(RoleModule roleModule) {
		return baseDao.update("roleModule.update", roleModule);
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.RoleModuleDao#queryRoleModule(com.oh.bean.RoleModule)
	 */
	@Override
	public RoleModule queryRoleModule(RoleModule roleModule) {
		List<RoleModule> ms =  this.queryRoleModules(roleModule, 0, 1);
		return CollectionUtils.isEmpty(ms) ? null : ms.get(0);
	}

}
