package com.sch.student.service;

import com.sch.student.dto.StudentOptionDTO;
import com.sch.student.entity.*;
import com.sch.student.pojo.Student;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    void savePayment(PaymentEntity payment);
    PaymentEntity setPayment(StudentOptionDTO userOption,AccountEntity account);
    Double amountAdmission(StudentOptionDTO userOption);
}
