package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *员工用户：(EmployeeUser)表实体类
 *
 */
@TableName("`employee_user`")
@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeUser implements Serializable {

    //EmployeeUser编号
    @TableId(value = "employee_user_id", type = IdType.AUTO)
    private Integer employee_user_id;
    // 性别
    @TableField(value = "`gender`")
    private String gender;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
    // 职位
    @TableField(value = "`position`")
    private String position;
    // 用户编号
    @TableField(value = "user_id")
    private Integer userId;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
