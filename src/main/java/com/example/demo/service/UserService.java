package com.example.demo.service;

import com.example.demo.dto.Article;
import com.example.demo.dto.User;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    public User getUser(String userId, String userPw){
        return userMapper.findUser(userId, userPw);
    }

    public void createUser(User user){
        userMapper.createUser(user);
    }

}
