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
 *报销申请：(ClaimForReimbursement)表实体类
 *
 */
@TableName("`claim_for_reimbursement`")
@Data
@EqualsAndHashCode(callSuper = false)
public class ClaimForReimbursement implements Serializable {

    //ClaimForReimbursement编号
    @TableId(value = "claim_for_reimbursement_id", type = IdType.AUTO)
    private Integer claim_for_reimbursement_id;
    // 报销编号
    @TableField(value = "`reimbursement_no`")
    private String reimbursement_no;
    // 报销类型
    @TableField(value = "`reimbursement_type`")
    private String reimbursement_type;
    // 报销名称
    @TableField(value = "`reimbursement_name`")
    private String reimbursement_name;
    // 费用时间
    @TableField(value = "`cost_time`")
    private Timestamp cost_time;
    // 报销费用
    @TableField(value = "`reimbursement_expenses`")
    private Integer reimbursement_expenses;
    // 费用凭证
    @TableField(value = "`expense_voucher`")
    private String expense_voucher;
    // 申请人
    @TableField(value = "`applicant`")
    private Integer applicant;
    // 费用明细
    @TableField(value = "`expense_details`")
    private String expense_details;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
