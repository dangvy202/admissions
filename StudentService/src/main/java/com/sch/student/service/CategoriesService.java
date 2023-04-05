package com.sch.student.service;

import com.sch.student.entity.CategoriesEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoriesService {
    CategoriesEntity findNameSubjectCategories(int id);
}
