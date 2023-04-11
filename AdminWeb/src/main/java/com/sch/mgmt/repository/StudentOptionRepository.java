package com.sch.mgmt.repository;

import com.sch.mgmt.entity.StudentOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOptionRepository extends JpaRepository<StudentOptionEntity,Long> {
}
