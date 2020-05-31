package com.zhang.dao;

import com.zhang.pojo.User;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UerTest {
    static Logger logger = Logger.getLogger(UerTest.class);
    @Test
    public void test(){
        //1.获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UserMapper userDao = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userDao.queryAll();
            userList.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testLog4j(){
        logger.info("配置完成");
    }

    @Test
    public void testLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        mapper.getUserByLimit(map);
        sqlSession.close();
    }

    @Test
    public void testRowBound(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //RowBound 实现分页
        RowBounds rowBound = new RowBounds(1,2);
        List<Object> list = sqlSession.selectList("com.zhang.dao.UserMapper.getUserRowBounds",null,rowBound);
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
