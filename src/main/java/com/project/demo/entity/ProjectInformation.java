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
 *项目预算申请：(ProjectInformation)表实体类
 *
 */
@TableName("`project_information`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectInformation implements Serializable {

    //ProjectInformation编号
    @TableId(value = "project_information_id", type = IdType.AUTO)
    private Integer project_information_id;
    // 项目编号
    @TableField(value = "`item_no`")
    private String item_no;
    // 项目名称
    @TableField(value = "`entry_name`")
    private String entry_name;
    // 申请预算
    @TableField(value = "`apply_for_budget`")
    private Integer apply_for_budget;
    // 申请时间
    @TableField(value = "`application_time`")
    private Timestamp application_time;
    // 申请人
    @TableField(value = "`applicant`")
    private Integer applicant;
    // 项目简介
    @TableField(value = "`project_introduction`")
    private String project_introduction;
    // 项目明细
    @TableField(value = "`project_details`")
    private String project_details;
    // 申请原因
    @TableField(value = "`reason_for_application`")
    private String reason_for_application;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
