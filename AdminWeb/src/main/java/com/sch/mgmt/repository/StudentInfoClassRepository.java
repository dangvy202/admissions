package com.sch.student.repository;

import com.sch.student.entity.StudentInfoClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoClassRepository extends JpaRepository<StudentInfoClassEntity,Long> {

}
