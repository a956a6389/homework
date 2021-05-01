/**  
 * @Title: ModuleService.java
 * @Package com.oh.service
 *
 */ 
package com.oh.service;

import java.util.List;

import com.oh.bean.Module;

/***
 * 
 * @ClassName: ModuleService
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 2:37:42 PM
 *
 */
public interface ModuleService {
	/***
	 * 
	 * @Description query modules
	 * @return
	 */
	List<Module> queryModules(Module module, Integer start, Integer end);

	/***
	 * 
	* @Description: insert module info.
	* @param module
	* @return
	* @throws Exception
	 */
	int insert(Module module) throws Exception;
	
	/***
	 * 
	 * @Description: delete the module by id
	 * @param id
	 * @return int
	 */
	int deleteModule(int id);
	
	/***
	 * 
	 * @Description: batch delete the modules
	 * @param ids
	 * @return int
	 */
	int batchDeleteModules(int[] ids);

	/***
	 * 
	 * @Description: update module
	 * @param module
	 * @return Module
	 */
	int updateModule(Module module);
}
