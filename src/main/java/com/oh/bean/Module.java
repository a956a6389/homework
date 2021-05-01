/**  
 * @Title: Module.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;

/**
 * @ClassName: Module
 * @Description: TODO
 * @author Owen.he
 * @date Apr 13, 2017 1:59:30 PM
 *
 */
public class Module implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String cnName;
	private String enName;
	private String url;
	private boolean urlEnabled = Boolean.TRUE.booleanValue();
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the urlEnabled
	 */
	public boolean isUrlEnabled() {
		return urlEnabled;
	}
	/**
	 * @param urlEnabled the urlEnabled to set
	 */
	public void setUrlEnabled(boolean urlEnabled) {
		this.urlEnabled = urlEnabled;
	}
	/**
	 * @return the cnName
	 */
	public String getCnName() {
		return cnName;
	}
	/**
	 * @param cnName the cnName to set
	 */
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	/**
	 * @return the enName
	 */
	public String getEnName() {
		return enName;
	}
	/**
	 * @param enName the enName to set
	 */
	public void setEnName(String enName) {
		this.enName = enName;
	}

}
