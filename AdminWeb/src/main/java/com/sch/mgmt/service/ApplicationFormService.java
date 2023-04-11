package com.sch.mgmt.service;

import com.sch.mgmt.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationFormService {
    List<ApplicationFormEntity> findAllAdmissions();
}
