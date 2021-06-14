/**
 * 
 */
package com.oh.exception;

/**
 * error code and success code
 * @author owen
 * @file ErrorCode.java
 * @package com.oh.exception
 * @version v1.0
 * @date 2017/4/29
 */
public enum ErrorCode {
	ERROR_SYSTEM(5000, "Symstem error."),
	SUCCESS(1000, "success");
	
	private int code;
	private String errorMsg;
	
	private ErrorCode(int code, String errorMsg) {
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
