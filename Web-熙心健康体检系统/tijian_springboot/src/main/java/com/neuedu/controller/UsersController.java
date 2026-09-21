package com.neuedu.controller;

import com.neuedu.po.Users;
import com.neuedu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // 登录接口 改为Post
    @PostMapping("/getUsersByUserIdByPass")
    public Users getUsersByUserIdByPass(@RequestBody Users users) {
        return usersService.getUsersByUserIdByPass(users);
    }

    // 手机号查重接口 改为Post
    @PostMapping("/getUsersById")
    public Users getUsersById(@RequestBody Users users) {
        return usersService.getUsersById(users.getUserId());
    }

    // 注册接口 改为Post
    @PostMapping("/saveUsers")
    public int saveUsers(@RequestBody Users users) {
        return usersService.saveUsers(users);
    }
}