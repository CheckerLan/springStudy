package com.checker.mybatis;

import com.checker.dao.EmployeeDAO;
import com.checker.dao.TeacherDAO;
import com.checker.dao.UserDAO;
import com.checker.entity.Employee;
import com.checker.entity.Teacher;
import com.checker.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("config/mybatis-config.xml"));

    public MybatisTest() throws IOException {
    }

    @Test
    public void test() throws IOException {

        // 根据全局配置文件创建SqlSessionFactory
        String resource = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取session
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeDAO mapper = sqlSession.getMapper(EmployeeDAO.class);
            mapper.getEmployeeById(1);
        }
        // 等价于
        /*
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            EmployeeDAO mapper = sqlSession.getMapper(EmployeeDAO.class);
            mapper.getEmpById(1);
        }finally {
            sqlSession.close();
        }
         */
    }

    @Test
    public void test4Method() {

        // 拿sqlsession
        try (SqlSession sqlSession = sessionFactory.openSession()) {

            // 获取mapper
            EmployeeDAO employeeDAO = sqlSession.getMapper(EmployeeDAO.class);

            Employee employee1 = new Employee(1, "lan", 0, "123@163.com");
            Employee employee2 = new Employee(null, "小明", 0, "123@163.com");

            employeeDAO.insertEmployee(employee2);
            System.out.println(employee2);

            employeeDAO.deleteEmployee(2);

            employeeDAO.updateEmployee(employee1);
            System.out.println(employee1);

            employeeDAO.getEmployeeById(1);

        }
    }
    @Test
    public void testList() {

        try (SqlSession sqlSession = sessionFactory.openSession()){
            EmployeeDAO dao = sqlSession.getMapper(EmployeeDAO.class);
            final List<Employee> employees = dao.listEmployee();
            System.out.println(employees);

            final Map<String, Employee> stringEmployeeMap = dao.listEmployeeForMap();
            System.out.println(stringEmployeeMap);

        }
    }

    @Test
    public void testAssociated(){

        try(SqlSession sqlSession = sessionFactory.openSession()){
            final UserDAO mapper = sqlSession.getMapper(UserDAO.class);
            final User user = mapper.getUser(1);
            System.out.println(user);


        }

    }

    @Test
    public void testLazy(){
        try(SqlSession sqlSession = sessionFactory.openSession()){
            final UserDAO mapper = sqlSession.getMapper(UserDAO.class);
            final User user = mapper.getUser(1);
            System.out.println(user.getUid());
            System.out.println(user.getDept());
        }
    }

    @Test
    public void testTeacher(){
        try(final SqlSession sqlSession = sessionFactory.openSession()){
            final TeacherDAO mapper = sqlSession.getMapper(TeacherDAO.class);
            final Teacher teacher = new Teacher();
            teacher.setTid(1);
            teacher.setTname("aa");
//            teacher.setBirthDay(new Date());
//            System.out.println(mapper.getTeacher(teacher));
//            System.out.println(mapper.getTeacherWithTrim(teacher));
            System.out.println(mapper.getTeacherWithChoose(teacher));

        }
    }

    
    @Test
    public void testForeach(){
        try(final SqlSession sqlSession = sessionFactory.openSession()){
            final TeacherDAO mapper = sqlSession.getMapper(TeacherDAO.class);
            final List<Teacher> teachers = mapper.getTeacherWithForeach(Arrays.asList(1, 2, 3, 4, 5));
            System.out.println(teachers);
        }
    }
    
    @Test
    public void testUpdate(){
        try(final SqlSession sqlSession = sessionFactory.openSession()){
            final TeacherDAO mapper = sqlSession.getMapper(TeacherDAO.class);
            final Teacher teacher = new Teacher();
            teacher.setTid(1);
            teacher.setTname("11");
            mapper.updateTeacher(teacher);
        }
    }

    @Test
    public void testCache(){
        try(final SqlSession sqlSession = sessionFactory.openSession()){
            final TeacherDAO mapper = sqlSession.getMapper(TeacherDAO.class);
            Teacher teacher = new Teacher();
            teacher.setTid(1);

            System.out.println("放入一级缓存，0/1");
            System.out.println(mapper.getTeacher(teacher));

            System.out.println("应该从一级缓存拿,0/2");
            System.out.println(mapper.getTeacher(teacher));
        }finally {
            System.out.println("sqlsession关闭，一级缓存被清除，应该放入二级缓存");
        }

        try(final SqlSession sqlSession = sessionFactory.openSession()){
            final TeacherDAO mapper = sqlSession.getMapper(TeacherDAO.class);
            Teacher teacher = new Teacher();
            teacher.setTid(1);
            // 从二级?
            System.out.println("应该从二级缓存拿,1/3,2/4");
            System.out.println(mapper.getTeacher(teacher));
            System.out.println(mapper.getTeacher(teacher));

            teacher.setTid(2);
            System.out.println("应该放入一级缓存,2/5");
            System.out.println(mapper.getTeacher(teacher));

            System.out.println("应该从一级缓存拿,2/6");
            System.out.println(mapper.getTeacher(teacher));

        }

        // 同时开两个session
        try (SqlSession sqlSession1 = sessionFactory.openSession();SqlSession sqlSession2 = sessionFactory.openSession()){
            TeacherDAO mapper1 = sqlSession1.getMapper(TeacherDAO.class);
            TeacherDAO mapper2 = sqlSession2.getMapper(TeacherDAO.class);

            Teacher teacher = new Teacher();
            teacher.setTid(3);

            System.out.println("应该都是放入一级缓存，两次sql,2/7,2/8");
            mapper1.getTeacher(teacher);
            mapper2.getTeacher(teacher);

            System.out.println("应该都从一级缓存拿,2/9,2/10");
            mapper1.getTeacher(teacher);
            mapper2.getTeacher(teacher);
        }
    }
}
