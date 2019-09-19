/**
 * Project Name:cms
 * File Name:UserController.java
 * Package Name:com.briup.apps.cms.web.controller.manager
 * Date:2018年9月18日下午4:04:16
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.briup.apps.cms.web.controller.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.service.ICMSUserService;
import com.briup.apps.cms.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName:UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年9月18日 下午4:04:16 <br/>
 * @author   lichunyu
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Api(description="用户管理")
@RestController
@RequestMapping("/manager/user")
public class UserController {
	@Autowired
	private ICMSUserService cmsUserService;
	
	@ApiOperation(value="查询所有用户信息")
	@GetMapping(value="findAllUser")
	public MsgResponse findAllUser() {
		List<User> list = cmsUserService.query();
		return MsgResponse.success("success", list);
	}
	
	@ApiOperation(value="通过id删除用户信息")
	@GetMapping(value="deleteUserById")
	public MsgResponse deleteUserById(int id) {
		try {
			if(id<20) {
				return MsgResponse.error("系统用户，无法删除");
			}
			cmsUserService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过用户名查询用户信息")
	@GetMapping(value="findUserByUsername")
	public MsgResponse findUserByUsername(String username) {
		try {
			User user = cmsUserService.findUserByUsername(username);
			return MsgResponse.success("success", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="保存或更新用户信息",notes="如果参数中id不为空表示保存，否则表示更新")
	@PostMapping(value="saveOrUpdateUser")
	public MsgResponse saveOrUpdateUser(User user) {
		try {
			cmsUserService.saveOrUpdate(user);
			return MsgResponse.success("success", user);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="修改用户状态",notes="true表示开启，false表示关闭")
	@PostMapping(value="changeStatus")
	public MsgResponse changeStatus(int id ,boolean status) {
		try {
			cmsUserService.changeStatus(id, status);
			return MsgResponse.success("success", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
}

