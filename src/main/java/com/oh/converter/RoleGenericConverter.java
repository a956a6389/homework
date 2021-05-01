/**  
 * @Title: RoleGenericConverter.java
 * @Package com.oh.converter
 *
 */
package com.oh.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.oh.bean.Role;

/**
 * @ClassName: RoleGenericConverter
 * @Description: TODO
 * @author yi.he
 * @date Mar 21, 2017 9:41:53 AM
 *
 */
public class RoleGenericConverter implements GenericConverter {

	/**
	 * 
	 */
	public RoleGenericConverter() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.convert.converter.GenericConverter#
	 * getConvertibleTypes()
	 */
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> pairs = new HashSet<ConvertiblePair>();
		pairs.add(new ConvertiblePair(Integer.class, Role.class));
		pairs.add(new ConvertiblePair(String.class, Role.class));
		return pairs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.GenericConverter#convert(java.
	 * lang.Object, org.springframework.core.convert.TypeDescriptor,
	 * org.springframework.core.convert.TypeDescriptor)
	 */
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		if(null == source || null == sourceType || null == targetType){
			return null;
		}
		
		Role role = new Role();
		if(sourceType.getType() == Integer.class){
			role.setId((Integer)source);
		}else if(sourceType.getType() == String.class){
			role.setId(Integer.parseInt((String)source));
		}
		return role;
	}

}
