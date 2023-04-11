package com.sch.mgmt.repository;

import com.sch.mgmt.entity.StudentInfoClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoClassRepository extends JpaRepository<StudentInfoClassEntity,Long> {

}
