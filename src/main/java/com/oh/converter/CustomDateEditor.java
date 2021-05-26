/**  
 * @Title: CustomDateEditor.java
 * @Package com.oh.converter
 *
 */ 
package com.oh.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * @ClassName: CustomDateEditor
 * @Description: TODO
 * @author Owen.he
 * @date Apr 25, 2017 10:27:01 AM
 *
 */
public class CustomDateEditor extends PropertiesEditor {
	private final Logger logger = LoggerFactory.getLogger("run");

	/* (non-Javadoc)
	 * @see org.springframework.beans.propertyeditors.PropertiesEditor#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;  
        try {  
            if(StringUtils.isNotBlank(text)){  
                date = format.parse(text);  
            }  
        } catch (ParseException e) {  
            format = new SimpleDateFormat("yyyy-MM-dd");  
            try {  
                date = format.parse(text);  
            } catch (ParseException e1) {  
                format = new SimpleDateFormat("yyyy-MM");  
                  
                try{  
                    date = format.parse(text);  
                }catch (Exception e2) {  
                    logger.error("bind date error", e);  
                }  
            }  
        }  
        setValue(date);
	}

}
