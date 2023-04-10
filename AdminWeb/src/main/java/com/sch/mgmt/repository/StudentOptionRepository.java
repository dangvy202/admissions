package com.sch.student.repository;

import com.sch.student.entity.StudentOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOptionRepository extends JpaRepository<StudentOptionEntity,Long> {
}
