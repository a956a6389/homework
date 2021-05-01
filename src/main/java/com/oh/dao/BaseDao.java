/**  
* @Title: BaseDao.java
* @Package com.oh.dao
* @Description: TODO
* @author owen.he  
* @date Jun 17, 2016 9:40:46 AM
* @version V1.0  
*/
package com.oh.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: BaseDao
 * @Description: TODO
 * @author owen.he
 * @date Jun 17, 2016 9:40:46 AM
 *
 */
@Repository(value = "baseDao")
public class BaseDao extends BaseDaoSupport {
	private static final Logger LOG = LoggerFactory.getLogger("db");

	/**
	 * 
	 */
	public BaseDao() {
		// TODO Auto-generated constructor stub
	}

	public int update(String nameSpace, Object whereParams) {
		long s = System.currentTimeMillis();
		int ret = getSqlSession().update(nameSpace, whereParams);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		}
		return ret;
	}

	public int update(String nameSpace) {
		long s = System.currentTimeMillis();
		int ret = getSqlSession().update(nameSpace);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		}
		return ret;
	}

	public int delete(String nameSpace, Object whereParams) {
		long s = System.currentTimeMillis();
		int ret = getSqlSession().delete(nameSpace, whereParams);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		}
		return ret;
	}

	public <T> T queryForObject(String nameSpace) {
		long s = System.currentTimeMillis();
		T ret = getSqlSession().selectOne(nameSpace);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		}
		return ret;
	}

	/**
	 * 
	 * 
	 * @param nameSpace
	 * @param whereParams
	 * @param rowBounds
	 * @return
	 */
	public <T> List<T> queryForListPagination(String nameSpace, Object whereParams, RowBounds rowBounds) {
		long s = System.currentTimeMillis();
		List<T> ret = getSqlSession().selectList(nameSpace, whereParams, rowBounds);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		}
		return ret;
	}

	public <T> List<T> queryForList(String nameSpace, Object whereParams) {
		long s = System.currentTimeMillis();
		List<T> ret = getSqlSession().selectList(nameSpace, whereParams);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		}
		return ret;
	}

	public <T> List<T> queryForList(String nameSpace) {
		long s = System.currentTimeMillis();
		List<T> ret = getSqlSession().selectList(nameSpace);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, time={}ms", new Object[] { nameSpace, e - s });
		}
		return ret;
	}

	public int insert(String nameSpace, Object entity) {
		long s = System.currentTimeMillis();
		int ret = getSqlSession().insert(nameSpace, entity);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, entity=[{}] time={}ms", new Object[] { nameSpace, entity, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, entity=[{}] time={}ms", new Object[] { nameSpace, entity, e - s });
		}
		return ret;
	}

	public <T> T queryForObject(String nameSpace, Object whereParams) {
		long s = System.currentTimeMillis();
		T ret = getSqlSession().selectOne(nameSpace, whereParams);
		long e = System.currentTimeMillis();
		if (e - s > 100) {
			if (LOG.isWarnEnabled())
				LOG.warn("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		} else {
			if (LOG.isInfoEnabled())
				LOG.info("[MyBatisClient:serve] {}, params=[{}] time={}ms",
						new Object[] { nameSpace, whereParams, e - s });
		}
		return ret;
	}
}
