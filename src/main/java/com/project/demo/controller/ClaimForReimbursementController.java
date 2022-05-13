package com.project.demo.controller;

import com.project.demo.entity.ClaimForReimbursement;
import com.project.demo.service.ClaimForReimbursementService;
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
 *报销申请：(ClaimForReimbursement)表控制层
 *
 */
@RestController
@RequestMapping("/claim_for_reimbursement")
public class ClaimForReimbursementController extends BaseController<ClaimForReimbursement,ClaimForReimbursementService> {

    /**
     *报销申请对象
     */
    @Autowired
    public ClaimForReimbursementController(ClaimForReimbursementService service) {
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
