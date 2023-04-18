package com.sch.student.repository;

import com.sch.student.entity.ImgInfomationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgInfoRepository extends JpaRepository<ImgInfomationEntity , Long> {
    @Query("SELECT i FROM ImgInfomationEntity i WHERE i.account.id = :id")
    ImgInfomationEntity findImgByAccountId(Long id);
}
