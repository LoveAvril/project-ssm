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
 *报销报表：(ReimbursementReport)表实体类
 *
 */
@TableName("`reimbursement_report`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ReimbursementReport implements Serializable {

    //ReimbursementReport编号
    @TableId(value = "reimbursement_report_id", type = IdType.AUTO)
    private Integer reimbursement_report_id;
    // 报表编号
    @TableField(value = "`report_no`")
    private String report_no;
    // 报销名称
    @TableField(value = "`reimbursement_name`")
    private String reimbursement_name;
    // 报销时间
    @TableField(value = "`reimbursement_time`")
    private Timestamp reimbursement_time;
    // 报销费用
    @TableField(value = "`reimbursement_expenses`")
    private Integer reimbursement_expenses;
    // 报销分析
    @TableField(value = "`reimbursement_analysis`")
    private String reimbursement_analysis;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
