package com.sch.student.repository;

import com.sch.student.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity,Integer> {

    @Query("SELECT c FROM CategoriesEntity c WHERE c.id = :id_categories")
    CategoriesEntity findCategoriesByOptionStudent(@Param("id_categories") int id_categories);
}
