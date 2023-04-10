package com.sch.student.repository;

import com.sch.student.entity.StudentEnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollRepository extends JpaRepository<StudentEnrollEntity,Long> {
}
