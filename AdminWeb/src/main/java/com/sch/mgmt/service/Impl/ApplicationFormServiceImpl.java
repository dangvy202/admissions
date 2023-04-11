package com.sch.mgmt.service.Impl;

import com.sch.mgmt.entity.*;
import com.sch.mgmt.repository.ApplicationFormRepository;
import com.sch.mgmt.service.ApplicationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationFormServiceImpl implements ApplicationFormService {

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Override
    public List<ApplicationFormEntity> findAllAdmissions() {
        List<ApplicationFormEntity> listApplicationForm = applicationFormRepository.findAll();
        return listApplicationForm;
    }
}
