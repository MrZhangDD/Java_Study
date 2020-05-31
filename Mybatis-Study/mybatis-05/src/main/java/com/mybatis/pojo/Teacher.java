package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    private int id;
    private String name;

    //一个老师有多个学生
    private List<Student> students;
}
