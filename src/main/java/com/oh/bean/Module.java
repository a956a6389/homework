/**  
 * @Title: Module.java
 * @Package com.oh.bean
 *
 */ 
package com.oh.bean;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

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
	@NotBlank(message="EnName is required")
	private String enName;
	
	@NotBlank(message="URL is required")
	private String url;
	private boolean urlEnabled = Boolean.TRUE.booleanValue();
	private Date createdDate;
	private Date updatedDate;
	private Long createdBy;
	private Long updatedBy;
	private Boolean checked = Boolean.FALSE;
	
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
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}
	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	/**
	 * @return the createdBy
	 */
	public Long getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the updatedBy
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}
	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	/**
	 * @return the checked
	 */
	public Boolean getChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
