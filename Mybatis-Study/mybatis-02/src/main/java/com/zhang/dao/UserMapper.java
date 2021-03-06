package com.zhang.dao;

import com.zhang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> queryAll();

    List<User> getUserByLimit(Map<String,Integer> map);
    List<User> getUserRowBounds();
}
