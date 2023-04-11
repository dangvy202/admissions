package com.sch.mgmt.repository;

import com.sch.mgmt.entity.StudentEnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollRepository extends JpaRepository<StudentEnrollEntity,Long> {
}
