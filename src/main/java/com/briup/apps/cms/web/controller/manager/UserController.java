/**
 * Project Name:cms
 * File Name:UserController.java
 * Package Name:com.briup.apps.cms.web.controller.manager
 * Date:2018年9月18日下午4:04:16
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.
 */

package com.briup.apps.cms.web.controller.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.baidu.ai.aip.utils.IdentificationUtil;
import com.briup.apps.cms.bean.CMSFile;
import com.briup.apps.cms.util.FastDFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.service.ICMSUserService;
import com.briup.apps.cms.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName:UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2018年9月18日 下午4:04:16 <br/>
 * @author lichunyu
 * @version
 * @since JDK 1.6
 * @see
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/manager/user")
public class UserController {
    @Autowired
    private ICMSUserService cmsUserService;

    @ApiOperation(value = "查询所有用户信息")
    @GetMapping(value = "findAllUser")
    public MsgResponse findAllUser() {
        List<User> list = cmsUserService.query();
        return MsgResponse.success("success", list);
    }

    @ApiOperation(value = "通过id删除用户信息")
    @GetMapping(value = "deleteUserById")
    public MsgResponse deleteUserById(int id) {
        try {
            if (id < 20) {
                return MsgResponse.error("系统用户，无法删除");
            }
            cmsUserService.deleteById(id);
            return MsgResponse.success("删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return MsgResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "通过用户名查询用户信息")
    @GetMapping(value = "findUserByUsername")
    public MsgResponse findUserByUsername(String username) {
        try {
            User user = cmsUserService.findUserByUsername(username);
            return MsgResponse.success("success", user);
        } catch (Exception e) {
            e.printStackTrace();
            return MsgResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "保存或更新用户信息", notes = "如果参数中id不为空表示保存，否则表示更新")
    @PostMapping(value = "saveOrUpdateUser")
    public MsgResponse saveOrUpdateUser(User user) {
        try {
            cmsUserService.saveOrUpdate(user);
            return MsgResponse.success("success", user);
        } catch (Exception e) {
            e.printStackTrace();
            return MsgResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "修改用户状态", notes = "true表示开启，false表示关闭")
    @PostMapping(value = "changeStatus")
    public MsgResponse changeStatus(int id, boolean status) {
        try {
            cmsUserService.changeStatus(id, status);
            return MsgResponse.success("success", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return MsgResponse.error(e.getMessage());
        }
    }

//    @ApiOperation(value = "用户身份证识别", notes = "需传身份证照片url eg  " +
//            "idcard_front: https://ai.bdstatic.com/file/D348C98B677149C8B95909CFA204BA1C   " +
//            "idcard_back: https://ai.bdstatic.com/file/75537E3E7EE8446EBDCB35B5CEDEB9B6")
//    @PostMapping(value = "identificationUser")
//    public MsgResponse identificationUser(String idcard_front, String idcard_back) {
//        try {
//            byte[] front_data = IdentificationUtil.getImageFromURL(idcard_front);
//            byte[] back_data = IdentificationUtil.getImageFromURL(idcard_back);
//
//            String front = IdentificationUtil.idcard("front", front_data);
//            String back = IdentificationUtil.idcard("back", back_data);
//            HashMap map = new HashMap<String, String>();
//            map.putAll(IdentificationUtil.getFrontByJson(front));
//            map.putAll(IdentificationUtil.getBackByJson(back));
//
//            return MsgResponse.success("success", map);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return MsgResponse.error(e.getMessage());
//        }
//    }


}

