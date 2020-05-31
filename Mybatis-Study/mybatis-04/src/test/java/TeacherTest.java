import com.mybatis.dao.StudentMapper;
import com.mybatis.dao.TeacherMapper;
import com.mybatis.pojo.Student;
import com.mybatis.pojo.Teacher;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherTest {

    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void testGetStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.getStudent().forEach(System.out:: println);
    }

    @Test
    public void testGetStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.getStudent().forEach(System.out:: println);
    }
}
