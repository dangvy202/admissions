package com.sch.mgmt.controller;

import com.sch.mgmt.entity.ApplicationFormEntity;
import com.sch.mgmt.service.Impl.ApplicationFormServiceImpl;
import jakarta.servlet.jsp.tagext.TagLibraryValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class AdmissionAdminController {

    private ApplicationFormServiceImpl applicationFormServiceImpl;

    public AdmissionAdminController(ApplicationFormServiceImpl applicationFormServiceImpl){
        this.applicationFormServiceImpl = applicationFormServiceImpl;
    }
    @RequestMapping("admission/admin")
    public String listAdmissionController(Model model){
        List<ApplicationFormEntity> listApplicationForm = applicationFormServiceImpl.findAllAdmissions();

        model.addAttribute("applicationForm" , listApplicationForm);
        return "template/admin/admission/list";
    }
}
