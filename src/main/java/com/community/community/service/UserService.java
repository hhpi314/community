package com.community.community.service;

import com.community.community.mapper.UserMapper;
import com.community.community.model.User;
import com.community.community.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        //根据user id查数据库中有没有用户(id是指accountId，github的id)
        User dbuser = userMapper.findByAccountId(user.getAccountId());
        if(user==null){
            //用户不存在，插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userRepository.save(user);
        }
        else{
            //用户存在，更新数据
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setGmtModified(System.currentTimeMillis());
            dbuser.setToken(user.getToken());
            dbuser.setName(user.getName());
            userMapper.update(dbuser);
        }
    }
}
