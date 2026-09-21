package com.neuedu.service;


import com.neuedu.po.Users;

public interface UsersService {

    public Users getUsersByUserIdByPass(Users users);
    public Users getUsersById(String userId);
    public int saveUsers(Users users);
}
