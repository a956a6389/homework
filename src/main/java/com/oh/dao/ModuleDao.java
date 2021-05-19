package com.oh.dao;

import java.util.List;

import com.oh.bean.Module;

/**
 * 
 * @ClassName: ModuleDao
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 2:34:15 PM
 *
 */
public interface ModuleDao{
	/***
	 * 
	 * @Description: query modules and paging
	 * @param module
	 * @param start 
	 * @param limit 
	 * @return List<Module>
	 */
	public List<Module> queryModules(Module module, Integer start, Integer limit);

	/***
	 * 
	 * @Description: insert module
	 * @param module
	 * @return int
	 */
	public int insert(Module module)  ;

	/***
	 * 
	 * @Description: delete the module
	 * @param id
	 * @return int
	 */
	public int deleteModule(int id) ;

	/***
	 * 
	 * @Description: batch delete the module
	 * @param ids
	 * @return
	 */
	public int batchDeleteModules(int[] ids) ;
	
	/***
	 * 
	 * @Description: Update the module
	 * @param module
	 * @return
	 */
	public int updateModule(Module module) ;
	
	public Module queryModule(Module module);

}
