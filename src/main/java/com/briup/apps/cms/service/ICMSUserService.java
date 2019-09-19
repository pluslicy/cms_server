/**
 * Project Name:cms
 * File Name:ICMSUserService.java
 * Package Name:com.briup.apps.cms.service
 * Date:2018年9月18日下午4:45:51
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.briup.apps.cms.service;
/**
 * ClassName:ICMSUserService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年9月18日 下午4:45:51 <br/>
 * @author   lichunyu
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

import java.util.List;

import com.briup.apps.cms.bean.User;

public interface ICMSUserService {
	long countAllUsers() ;
	
	List<User> query();
	
	void deleteById(int id) throws Exception;
	
	User findUserByUsername(String username) throws Exception;
	
	void saveOrUpdate(User user) throws Exception;
	
	void changeStatus(int id ,boolean status) throws Exception;
}

