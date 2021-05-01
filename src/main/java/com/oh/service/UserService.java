/**
 * 
 */
package com.oh.service;

import java.util.List;

import com.oh.bean.User;

/***
 * 
 * @ClassName: UserService
 * @Description: TODO
 * @author yi.he
 * @date Mar 8, 2017 4:36:45 PM
 *
 */
public interface UserService {

	/***
	 * 
	 * @Description query all user
	 * @return
	 */
	List<User> queryAllUser();

	/***
	 * 
	* @Description: insert user info.
	* @param user
	* @return
	* @throws Exception
	 */
	int insert(User user) throws Exception;
	
	/***
	 * 
	* @Description: query one user
	* @param user
	* @return
	 */
	User queryUser(User user);
	
	/***
	 * 
	* @Description: update user info.
	* @param user
	* @return
	* @throws Exception
	 */
	int update(User user) throws Exception;
}
