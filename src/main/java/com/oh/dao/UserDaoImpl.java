/**  
 * @Title: UserDaoImpl.java
 * @Package com.oh.dao
 *
 */
package com.oh.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oh.bean.User;

/**
 * @ClassName: UserDaoImpl
 * @Description: TODO
 * @author Owen.he
 * @date Apr 21, 2017 9:55:56 AM
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	private static Logger LOG = LoggerFactory.getLogger("run");
	@Autowired
	private BaseDao baseDao;


	public List<User> queryAllUser() {
		// RowBounds RowBounds = new RowBounds(0, 5);
		List<User> users = baseDao.queryForList("user.queryUsers", null);
		LOG.info("all users size={}", users.size());
		return users;
	}

	public int insert(User user) {
		if (user == null) {
			return 0;
		}
		return baseDao.insert("user.insert", user);
	}

	public int update(User user) {
		if (user == null) {
			return 0;
		}
		return baseDao.insert("user.update", user);
	}

	public User queryUser(User user) {
		if (user == null) {
			return null;
		}
		return baseDao.queryForObject("user.selectUser", user);
	}

	/* (non-Javadoc)
	 * @see com.oh.dao.UserDao#delete(int)
	 */
	@Override
	public int delete(Long id) {
		return baseDao.delete("user.deleteById", id);
	}
}
