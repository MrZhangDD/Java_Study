package com.zhang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String name;
    @TableId(type = IdType.AUTO) // 数据库id自增需要配置数据库字段自增
    private Long id;
    private String email;
    private Integer age;
    private Date createTime;
    private Date updateTime;
}
