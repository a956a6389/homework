/**
 * 
 */
package com.oh.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oh.bean.Role;
import com.oh.bean.User;
import com.oh.bean.UserRole;
import com.oh.dao.UserDao;

/***
 * 
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 4:37:00 PM
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private static Logger LOG = LoggerFactory.getLogger("run");
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserService#queryAllUser()
	 */
	public List<User> queryAllUser(){
//		RowBounds RowBounds = new RowBounds(0, 5);
		List<User> users = userDao.queryAllUser();
		LOG.info("all users size={}", users.size());
		Map<Integer, Role> roleMap = roleService.queryAllRolesMap();
		for (User user : users) {
			if(null == user.getRole()){
				continue;
			}
			user.setRole(roleMap.get(user.getRole().getId()));
		}
		return users;
	}

	public int insert(User user){
		if(user == null){
			return 0;
		}
		User existsUser = queryUser(user);
		if(existsUser != null){
			LOG.warn("User existis Email:{}", user.getEmail());
		}
		int count = userDao.insert(user);
		if(count > 0){
			updateUserRole(existsUser);
		}
		return count;
	}

	public User queryUser(User user){
		if(user == null){
			return null;
		}
		return userDao.queryUser(user);
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserService#update(com.oh.bean.User)
	 */
	@Override
	public int update(User user) throws Exception {
		if(user == null){
			return 0;
		}
		int count = userDao.update(user);
		if(count > 0){
			updateUserRole(user);
		}
		return count;
	}
	
	private void updateUserRole(User user){
		UserRole userRole = new UserRole();
		userRole.setRoleId(user.getRole().getId());
		userRole.setUserId(user.getId());
		UserRole userRoleExist = userRoleService.queryUserRole(userRole);
		if(null == userRoleExist){
			try {
				userRoleService.insert(userRole);
			} catch (Exception e) {
				LOG.error("Insert user and role fail: {}", e);
			}
		}else{
			userRoleService.update(userRole);
		}
	}

	/* (non-Javadoc)
	 * @see com.oh.service.UserService#delete(Long)
	 */
	@Override
	public int delete(Long id) {
		User paramUser = new User();
		paramUser.setId(id);
		User u = this.queryUser(paramUser);
		int count = userDao.delete(id);
		if(count > 0 ){
			UserRole userRole = new UserRole();
			userRole.setRoleId(u.getRole().getId());
			userRole.setUserId(id);
			userRoleService.delete(userRole);
		}
		return 0;
	}

}
