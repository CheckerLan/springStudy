package com.checker.dao;

import com.checker.entity.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
    public Employee getEmployeeById(Integer id);

    public List<Employee> listEmployee();

    @MapKey("id")
    public Map<String, Employee> listEmployeeForMap();

    public int updateEmployee(Employee employee);

    public int deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);
}
