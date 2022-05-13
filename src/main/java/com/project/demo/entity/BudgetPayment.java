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
 *预算付款：(BudgetPayment)表实体类
 *
 */
@TableName("`budget_payment`")
@Data
@EqualsAndHashCode(callSuper = false)
public class BudgetPayment implements Serializable {

    //BudgetPayment编号
    @TableId(value = "budget_payment_id", type = IdType.AUTO)
    private Integer budget_payment_id;
    // 项目编号
    @TableField(value = "`item_no`")
    private String item_no;
    // 项目名称
    @TableField(value = "`entry_name`")
    private String entry_name;
    // 申请人
    @TableField(value = "`applicant`")
    private Integer applicant;
    // 付款金额
    @TableField(value = "`payment_amount`")
    private Integer payment_amount;
    // 财务
    @TableField(value = "`finance`")
    private Integer finance;
    // 付款时间
    @TableField(value = "`payment_time`")
    private Timestamp payment_time;
    // 付款备注
    @TableField(value = "`payment_remarks`")
    private String payment_remarks;
    // 支付状态
    @TableField(value = "pay_state")
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @TableField(value = "pay_type")
    private String pay_type;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
