/**  
 * @Title: RoleDao.java
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

import com.oh.bean.Role;

/**
 * @ClassName: RoleDao
 * @Description: TODO
 * @author yi.he
 * @date Mar 9, 2017 9:47:59 AM
 *
 */
@Repository
public class RoleDao{
	private static Logger LOG = LoggerFactory.getLogger("run");
	
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	 */
	public RoleDao() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#queryAllRoles()
	 */
	public List<Role> queryAllRoles() {
		List<Role> roles = baseDao.queryForList("role.queryRoles", null);
		LOG.info("all roles size={}", roles.size());
		return roles;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#insert(com.oh.bean.Role)
	 */
	public int insert(Role role) throws Exception {
		Role exsitRole = baseDao.queryForObject("role.selectOneRole", role);
		if(null != exsitRole){
			return 0;
		}
		return baseDao.insert("role.insert", role);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#queryRole(com.oh.bean.Role)
	 */
	public Role queryRole(Role role) {
		return baseDao.queryForObject("role.selectOneRole", role);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#deleteRole(int)
	 */
	public int deleteRole(int id) {
		return baseDao.delete("role.deleteById", id);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#batchDeleteRoles(int[])
	 */
	public int batchDeleteRoles(int[] ids) {
		return baseDao.delete("role.batchDeleteRoles", ids);
	}
	
	public int updateRole(Role role) {
		return baseDao.update("role.update", role);
	}

}
