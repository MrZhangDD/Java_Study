package com.mybatis.dao;

import com.mybatis.pojo.Person;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {

    Person queryUserById(@Param("id") int id);
}
