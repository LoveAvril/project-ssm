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
 *财务用户：(FinancialUser)表实体类
 *
 */
@TableName("`financial_user`")
@Data
@EqualsAndHashCode(callSuper = false)
public class FinancialUser implements Serializable {

    //FinancialUser编号
    @TableId(value = "financial_user_id", type = IdType.AUTO)
    private Integer financial_user_id;
    // 职位
    @TableField(value = "`position`")
    private String position;
    // 姓名
    @TableField(value = "`full_name`")
    private String full_name;
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
