package com.sch.student.service.Impl;

import com.sch.student.dto.StudentOptionDTO;
import com.sch.student.entity.AccountEntity;
import com.sch.student.entity.PaymentEntity;
import com.sch.student.entity.StudentEnrollEntity;
import com.sch.student.entity.StudentOptionEntity;
import com.sch.student.repository.PaymentRepository;
import com.sch.student.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void savePayment(PaymentEntity payment) {
        paymentRepository.save(payment);
    }

    public  PaymentEntity findPaymentByAccountId (Long id){
        PaymentEntity payment = paymentRepository.getAmmountByAccountIdentifier(id);
        return payment;
    }

    @Override
    public PaymentEntity setPayment(StudentOptionDTO userOption,AccountEntity account) {
        long millis=System.currentTimeMillis();
        Date dateNow = new Date(millis);

        PaymentEntity payment = PaymentEntity.builder()
                .amount(amountAdmission(userOption))
                .createPayment(dateNow)
                .modifyPayment(dateNow)
                .status(0)
                .schAccount(account)
                .build();
        return payment;
    }

    @Override
    public Double amountAdmission(StudentOptionDTO userOption) {
        int seq = 0;
        if(userOption.getMath() != 0){
            seq ++;
        }
        if(userOption.getInformaticsInformatics() != 0){
            seq ++;
        }
        if(userOption.getInformaticsMath() != 0){
            seq ++;
        }
        if(userOption.getPhysicsPhysics() != 0){
            seq ++;
        }
        if(userOption.getPhysicsMath() != 0){
            seq ++;
        }
        if(userOption.getChemistry() != 0){
            seq ++;
        }
        if(userOption.getBiology() != 0){
            seq ++;
        }
        if(userOption.getEnglish() != 0){
            seq ++;
        }
        if(userOption.getLiterature() != 0){
            seq ++;
        }
        if(userOption.getMathLN() != 0){
            seq ++;
        }
        if(userOption.getPhysicsPhysicsLN() != 0){
            seq ++;
        }
        if(userOption.getPhysicsMathLN() != 0){
            seq ++;
        }
        if(userOption.getChemistryChemistryLN() != 0){
            seq ++;
        }
        if(userOption.getChemistryMathLN() != 0){
            seq ++;
        }
        if(userOption.getBiologyBiologyLN() != 0){
            seq ++;
        }
        if(userOption.getBiologyMathLN() != 0){
            seq ++;
        }
        if(userOption.getEnglishLN() != 0){
            seq ++;
        }
        if(userOption.getLiteratureLN() != 0){
            seq ++;
        }
        double amount = 450000 + 50000 * seq;
        return amount;
    }
}
