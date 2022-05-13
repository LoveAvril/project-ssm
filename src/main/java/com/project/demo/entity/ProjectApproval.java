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
 *项目审批：(ProjectApproval)表实体类
 *
 */
@TableName("`project_approval`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectApproval implements Serializable {

    //ProjectApproval编号
    @TableId(value = "project_approval_id", type = IdType.AUTO)
    private Integer project_approval_id;
    // 项目编号
    @TableField(value = "`item_no`")
    private String item_no;
    // 项目名称
    @TableField(value = "`entry_name`")
    private String entry_name;
    // 申请人
    @TableField(value = "`applicant`")
    private Integer applicant;
    // 审批结果
    @TableField(value = "`approval_results`")
    private String approval_results;
    // 审批时间
    @TableField(value = "`approval_time`")
    private Timestamp approval_time;
    // 财务
    @TableField(value = "`finance`")
    private Integer finance;
    // 审批说明
    @TableField(value = "`approval_description`")
    private String approval_description;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
