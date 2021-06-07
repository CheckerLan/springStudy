package com.checker.dao;

import com.checker.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDAO {

    public List<Teacher> getTeacher(Teacher teacher);

    public List<Teacher> getTeacherWithChoose(Teacher teacher);

    public List<Teacher> getTeacherWithTrim(Teacher teacher);

    public List<Teacher> getTeacherWithForeach(@Param("ids") List<Integer> ids);

    public int updateTeacher(Teacher teacher);
}
