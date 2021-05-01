/**  
 * @Title: UserRoleServiceImpl.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oh.bean.UserRole;
import com.oh.dao.UserRoleDao;

/**
 * @ClassName: UserRoleServiceImpl
 * @Description: TODO
 * @author yi.he
 * @date Mar 20, 2017 2:26:12 PM
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;

	/**
	 * 
	 */
	public UserRoleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#insert(com.oh.bean.UserRole)
	 */
	public int insert(UserRole userRole) throws Exception {
		int count =  userRoleDao.insert(userRole);
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#queryUserRole(com.oh.bean.UserRole)
	 */
	public UserRole queryUserRole(UserRole userRole) {
		UserRole ret = userRoleDao.queryUserRole(userRole);
		return ret;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#delete(com.oh.bean.UserRole)
	 */
	public int delete(UserRole userRole) {
		return userRoleDao.delete(userRole);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#update(com.oh.bean.UserRole)
	 */
	public int update(UserRole userRole) {
		return userRoleDao.update(userRole);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserRoleService#findUserRoleByIds(java.util.Map)
	 */
	public List<UserRole> findUserRoleByIds(Map<String, Object> paramMap) {
		if(MapUtils.isEmpty(paramMap)){
			return null;
		}
		return userRoleDao.findUserRoleByIds(paramMap);
	}
}
