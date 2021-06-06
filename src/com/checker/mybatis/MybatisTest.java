package com.checker.mybatis;

import com.checker.dao.EmployeeDAO;
import com.checker.dao.UserDAO;
import com.checker.entity.Employee;
import com.checker.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
}
