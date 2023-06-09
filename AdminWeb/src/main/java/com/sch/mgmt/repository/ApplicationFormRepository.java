package com.sch.mgmt.repository;

import com.sch.mgmt.entity.ApplicationFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationFormRepository extends JpaRepository<ApplicationFormEntity,Long> {
//    @Query("SELECT a FROM ApplicationFormEntity a WHERE a.schUser.id = :id AND a.schReport.id = :id AND a.schOption.id = :id AND a.schInfoClass.id = :id AND a.schEnroll.id = :id")
//    List<ApplicationFormEntity> findEnrollInfomation(Long id);
}
