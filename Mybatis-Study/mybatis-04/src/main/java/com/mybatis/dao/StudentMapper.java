package com.mybatis.dao;

import com.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudent();
    List<Student> getStudent2();
}
