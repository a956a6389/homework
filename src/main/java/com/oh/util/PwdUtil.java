/**  
* @Title: PwdUtil.java
* @Package com.oh.util
* @Description: TODO
* @author owen.he  
* @date Jun 16, 2016 2:38:13 PM
* @version V1.0  
*/
package com.oh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @ClassName: PwdUtil
 * @Description: TODO
 * @author owen.he
 * @date Jun 16, 2016 2:38:13 PM
 *
 */
public class PwdUtil {
	private static Logger log = LoggerFactory.getLogger(PwdUtil.class);

	/**
	 * 
	 */
	public PwdUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static MessageDigest getInstance(String encodeType){
		try {
			return MessageDigest.getInstance(StringUtils.isEmpty(encodeType) ? "SHA" : encodeType);
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	/***
	 * 
	* @Description: SHA encode
	* @param inStr
	* @return
	 */
	public static String shaEncode(String inStr) {
		if(StringUtils.isEmpty(inStr)){
			return inStr;
		}
		MessageDigest sha = getInstance("SHA");
		
		try{
			byte[] byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return "";
	}

	/**
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(shaEncode("123456"));
	}

}
