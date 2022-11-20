package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Category;
import com.ehb.Elecrtonics.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    public Category addCategory(Category r)
    {
        return categoryDao.save(r);
    }

    public Iterable<Category> listCategory()
    {
       return categoryDao.findAll();
    }
    public void editCategory(Integer catid, Category cat)
    {
        Category category=categoryDao.findById(catid).get();
        category.setCat_name(cat.getCat_name());
        category.setDescription(cat.getDescription());
        category.setUrl(cat.getUrl());
        categoryDao.save(category);

    }

}
