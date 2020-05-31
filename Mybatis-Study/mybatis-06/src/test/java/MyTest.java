import com.mybatis.dao.PersonMapper;
import com.mybatis.pojo.Person;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        System.out.println(mapper.queryUserById(1));

        System.out.println("========================");
        Person user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 测试二级缓存
     */
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        System.out.println(mapper.queryUserById(1));
        sqlSession.close();
        //先关闭，然后会缓存到二级缓存中
        System.out.println("========================");
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        PersonMapper mapper1 = sqlSession2.getMapper(PersonMapper.class);
        Person user = mapper1.queryUserById(1);
        System.out.println(user);
        sqlSession2.close();
    }

}
