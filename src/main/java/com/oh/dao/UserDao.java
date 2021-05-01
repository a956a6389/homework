/**
 * 
 */
package com.oh.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oh.bean.User;
import com.oh.service.RoleService;

/***
 * 
 * @ClassName: UserDao
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 4:37:00 PM
 *
 */
@Repository
public class UserDao{
	private static Logger LOG = LoggerFactory.getLogger("run");
	@Autowired
	private BaseDao baseDao;

	/**
	 * 
	 */
	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public List<User> queryAllUser(){
//		RowBounds RowBounds = new RowBounds(0, 5);
		List<User> users = baseDao.queryForList("user.queryUsers", null);
		LOG.info("all users size={}", users.size());
		return users;
	}

	public int insert(User user){
		if(user == null){
			return 0;
		}
		return baseDao.insert("user.insert", user);
	}
	
	public int update(User user){
		if(user == null){
			return 0;
		}
		return baseDao.insert("user.update", user);
	}

	public User queryUser(User user){
		if(user == null){
			return null;
		}
		return baseDao.queryForObject("user.selectUser", user);
	}

}
