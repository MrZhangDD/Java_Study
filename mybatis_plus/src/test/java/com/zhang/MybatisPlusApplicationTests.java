package com.zhang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.mapper.UserMapper;
import com.zhang.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    /**
     * 查询功能
     */
    void testMapper(){

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入
     */
    @Test
    void insertTest(){
        User user = new User();
        user.setEmail("qq.com");
        user.setName("mybatis-pluss");
        user.setAge(20);
        userMapper.insert(user);
    }
    /**
     * 测试更新
     */
    @Test
    void updateTest(){
        User user = new User();
        user.setId(5L);
        user.setName("张");
        userMapper.updateById(user);
    }

    /**
     * 测试查询
     */
    @Test
    void quertTest(){
        Map<String, Object> map = new HashMap<>();

        map.put("name","mybatis-plus");
        map.put("age",15);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    /**
     * 测试分页，需要有相关分页配置
     */

    @Test
    void testPage(){
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);

    }
}
