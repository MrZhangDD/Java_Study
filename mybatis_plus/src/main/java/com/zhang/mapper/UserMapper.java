package com.zhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhang.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * 使用了mybatis-plus 在mapper上实现基本的接口  BaseMapper
 */
@Repository // 代表持久层
public interface UserMapper extends BaseMapper<User> {
}
