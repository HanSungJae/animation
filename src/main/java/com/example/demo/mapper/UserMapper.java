package com.example.demo.mapper;

import com.example.demo.dto.Article;
import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {
    User findUser(@Param("userId") String userId, @Param("userPw") String userPw);
    void createUser(User user);

}