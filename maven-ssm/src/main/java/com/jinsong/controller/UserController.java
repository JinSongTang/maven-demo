package com.jinsong.controller;

import com.jinsong.bean.User;
import com.jinsong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangjinsong
 * @Classname UserController
 * @Description TODO
 * @Date 2019/8/10 14:25
 * @Created by tangjinsong
 */
@Controller
@RequestMapping("demo")
public class UserController {
    @Autowired
    private  UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public User select(){

        return userService.seByid();
    }


}
