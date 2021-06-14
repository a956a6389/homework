/**
 * 
 */
package com.oh.common;

import java.io.Serializable;

/**
 * Response body to web common base class
 * @author owen
 * @file JsonResult.java
 * @package com.oh.common
 * @version v1.0
 * @date 2017/4/29
 */
public class JsonResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	private String msg;
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
