package com.project.demo.controller;

import com.project.demo.entity.ReimbursementApproval;
import com.project.demo.service.ReimbursementApprovalService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *报销审批：(ReimbursementApproval)表控制层
 *
 */
@RestController
@RequestMapping("/reimbursement_approval")
public class ReimbursementApprovalController extends BaseController<ReimbursementApproval,ReimbursementApprovalService> {

    /**
     *报销审批对象
     */
    @Autowired
    public ReimbursementApprovalController(ReimbursementApprovalService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
