/**  
* @Title: BaseDaoSupport.java
* @Package com.oh.dao
* @Description: TODO
* @author owen.he  
* @date Jun 17, 2016 9:39:14 AM
* @version V1.0  
*/ 
package com.oh.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
* @ClassName: BaseDaoSupport
* @Description: TODO
* @author owen.he
* @date Jun 17, 2016 9:39:14 AM
*
*/
public abstract class BaseDaoSupport extends SqlSessionDaoSupport  {

	/**
	 * 
	 */
	public BaseDaoSupport() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	@Qualifier(value = "sqlSessionTemplate")
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

}
