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
 *预算报表：(BudgetStatement)表实体类
 *
 */
@TableName("`budget_statement`")
@Data
@EqualsAndHashCode(callSuper = false)
public class BudgetStatement implements Serializable {

    //BudgetStatement编号
    @TableId(value = "budget_statement_id", type = IdType.AUTO)
    private Integer budget_statement_id;
    // 报表编号
    @TableField(value = "`report_no`")
    private String report_no;
    // 预算名称
    @TableField(value = "`budget_name`")
    private String budget_name;
    // 预算时间
    @TableField(value = "`budget_time`")
    private Timestamp budget_time;
    // 预算费用
    @TableField(value = "`budget_expenses`")
    private Integer budget_expenses;
    // 预算分析
    @TableField(value = "`scheduled_analysis`")
    private String scheduled_analysis;


    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;

}
