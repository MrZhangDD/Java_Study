package com.zhang.dao;

import com.zhang.pojo.User;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

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
}
