/**  
 * @Title: RoleServiceImpl.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.oh.bean.Role;
import com.oh.dao.RoleDao;

/**
 * @ClassName: RoleServiceImpl
 * @Description: TODO
 * @author yi.he
 * @date Mar 9, 2017 9:47:59 AM
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	private static Logger LOG = LoggerFactory.getLogger("run");
	private static Map<Integer, Role> roleCacheMap = new HashMap<>();
	
	@Autowired
	private RoleDao roleDao;

	/**
	 * 
	 */
	public RoleServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#queryAllRoles()
	 */
	public List<Role> queryAllRoles() {
		List<Role> roles = roleDao.queryAllRoles();
		LOG.info("all roles size={}", roles.size());
		return roles;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#insert(com.oh.bean.Role)
	 */
	public int insert(Role role) throws Exception {
		Role exsitRole = roleDao.queryRole(role);
		if(null != exsitRole){
			return 0;
		}
		int count = roleDao.insert(role);
		if(count > 0){
			roleCacheMap.put(role.getId(), role);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#queryRole(com.oh.bean.Role)
	 */
	public Role queryRole(Role role) {
		Role retRole = roleCacheMap.get(role.getId());
		if(null != retRole){
			return retRole;
		}
		
		retRole = roleDao.queryRole(role);
		roleCacheMap.put(role.getId(), retRole);
		return retRole;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#deleteRole(int)
	 */
	public int deleteRole(int id) {
		int count =  roleDao.deleteRole(id);
		if(count > 0){
			roleCacheMap.remove(id);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#batchDeleteRoles(int[])
	 */
	public int batchDeleteRoles(int[] ids) {
		return roleDao.batchDeleteRoles(ids);
	}
	
	public int updateRole(Role role) {
		int count =  roleDao.updateRole(role);
		if(count > 0){
			roleCacheMap.put(role.getId(), role);
		}
		return count;
	}

	/* (non-Javadoc)
	 * @see com.oh.service.RoleService#queryAllRolesMap()
	 */
	@Override
	public Map<Integer, Role> queryAllRolesMap() {
		if(!CollectionUtils.isEmpty(roleCacheMap)){
			return roleCacheMap;
		}
		
		List<Role> roles = this.queryAllRoles();
		for (Role role : roles) {
			roleCacheMap.put(role.getId(), role);
		}
		return roleCacheMap;
	}

}
