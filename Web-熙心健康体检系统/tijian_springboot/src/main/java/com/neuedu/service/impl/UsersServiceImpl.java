package com.neuedu.service.impl;

import com.neuedu.mapper.UsersMapper;
import com.neuedu.po.Users;
import com.neuedu.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users getUsersByUserIdByPass(Users users) {
        return usersMapper.getUsersByUserIdByPass(users);
    }

    @Override
    public Users getUsersById(String userId) {
        return usersMapper.getUsersById(userId);
    }

    @Override
    public int saveUsers(Users users) {
        return usersMapper.saveUsers(users);
    }
}
