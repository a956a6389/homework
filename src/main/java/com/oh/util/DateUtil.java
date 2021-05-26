/**  
 * @Title: DateUtil.java
 * @Package com.oh.util
 *
 */ 
package com.oh.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @author Owen.he
 * @date Apr 25, 2017 1:40:50 PM
 *
 */
public class DateUtil {

	/***
	 * 
	 * @Description: get the now date
	 * @return Date
	 */
	public static Date now(){
		return Calendar.getInstance().getTime();
	}
}
