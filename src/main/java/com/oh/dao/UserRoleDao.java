/**  
 * @Title: UserRoleDao.java
 * @Package com.oh.service
 *
 */ 
package com.oh.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oh.bean.UserRole;

/**
 * @ClassName: UserRoleDao
 * @Description: TODO
 * @author yi.he
 * @date Mar 20, 2017 2:26:12 PM
 *
 */
@Repository
public class UserRoleDao {
	
	private static Logger LOG = LoggerFactory.getLogger("run");
	
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	 */
	public UserRoleDao() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#insert(com.oh.bean.UserRole)
	 */
	public int insert(UserRole userRole) throws Exception {
		int count =  baseDao.insert("userRole.insert", userRole);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#queryUserRole(com.oh.bean.UserRole)
	 */
	public UserRole queryUserRole(UserRole userRole) {
		UserRole ret = baseDao.queryForObject("userRole.queryRoles", userRole);
		return ret;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#delete(com.oh.bean.UserRole)
	 */
	public int delete(UserRole userRole) {
		return baseDao.delete("userRole.delete", userRole);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#update(com.oh.bean.UserRole)
	 */
	public int update(UserRole userRole) {
		return baseDao.delete("userRole.update", userRole);
	}
	
	public List<UserRole> findUserRoleByIds(Map<String, Object> paramMap) {
		return baseDao.queryForList("userRole.findUserRoleByIds", paramMap);
	}

}
