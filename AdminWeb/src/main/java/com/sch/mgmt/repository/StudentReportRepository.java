package com.sch.mgmt.repository;

import com.sch.mgmt.entity.StudentReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReportRepository extends JpaRepository<StudentReportEntity,Long> {


}
