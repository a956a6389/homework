/**
 * 
 */
package com.oh.dao;

import java.util.List;

import com.oh.bean.User;

/***
 * 
 * @ClassName: UserDao
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 4:37:00 PM
 *
 */
public interface UserDao{

	/***
	 * 
	 * @Description: query all user
	 * @return List<User>
	 */
	public List<User> queryAllUser();

	/**
	 * 
	 * @Description: insert user
	 * @param user
	 * @return int
	 */
	public int insert(User user);
	
	/***
	 * 
	 * @Description: update user
	 * @param user
	 * @return int
	 */
	public int update(User user);

	/***
	 * 
	 * @Description: query user
	 * @param user
	 * @return user
	 */
	public User queryUser(User user);
	
	/***
	 * 
	 * @Description: delete user
	 * @param id
	 * @return int
	 */
	public int delete(Long id);

}
