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
 *报销审批：(ReimbursementApproval)表实体类
 *
 */
@TableName("`reimbursement_approval`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ReimbursementApproval implements Serializable {

    //ReimbursementApproval编号
    @TableId(value = "reimbursement_approval_id", type = IdType.AUTO)
    private Integer reimbursement_approval_id;
    // 报销编号
    @TableField(value = "`reimbursement_no`")
    private String reimbursement_no;
    // 报销类型
    @TableField(value = "`reimbursement_type`")
    private String reimbursement_type;
    // 报销名称
    @TableField(value = "`reimbursement_name`")
    private String reimbursement_name;
    // 申请人
    @TableField(value = "`applicant`")
    private Integer applicant;
    // 审批结果
    @TableField(value = "`approval_results`")
    private String approval_results;
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
