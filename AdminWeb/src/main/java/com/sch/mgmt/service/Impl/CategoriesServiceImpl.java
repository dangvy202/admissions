package com.sch.student.service.Impl;

import com.sch.student.entity.CategoriesEntity;
import com.sch.student.repository.CategoriesRepository;
import com.sch.student.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public CategoriesEntity findNameSubjectCategories(int id) {
        CategoriesEntity categories = categoriesRepository.findCategoriesByOptionStudent(id);
        return categories;
    }
}
