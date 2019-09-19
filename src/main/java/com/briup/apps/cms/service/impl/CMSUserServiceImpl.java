/**
 * Project Name:cms
 * File Name:CMSUserServiceImpl.java
 * Package Name:com.briup.apps.cms.service.impl
 * Date:2018年9月18日下午4:46:08
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.briup.apps.cms.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.dao.CMSUserMapper;
import com.briup.apps.cms.dao.extend.UserMapper;
import com.briup.apps.cms.service.ICMSUserService;

/**
 * ClassName:CMSUserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年9月18日 下午4:46:08 <br/>
 * @author   lichunyu
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service
public class CMSUserServiceImpl implements ICMSUserService {
	@Autowired
	private CMSUserMapper cmsUserMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> query() {
		UserExample example = new UserExample();
		List<User> list = cmsUserMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(int id) throws Exception {
		cmsUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		User user = userMapper.loadUserByUsername(username);
		return user;
	}

	@Override
	public void saveOrUpdate(User user) throws Exception {
		if(user.getId() == null) {
			user.setEnabled(false);
			user.setRegTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			cmsUserMapper.insert(user);
		} else {
			cmsUserMapper.updateByPrimaryKey(user);
		}
	}

	@Override
	public void changeStatus(int id, boolean status) throws Exception {
		User user =  cmsUserMapper.selectByPrimaryKey(id);
		user.setEnabled(status);
		cmsUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public long countAllUsers() {
		UserExample example = new UserExample();
		return cmsUserMapper.countByExample(example);
	}

}

