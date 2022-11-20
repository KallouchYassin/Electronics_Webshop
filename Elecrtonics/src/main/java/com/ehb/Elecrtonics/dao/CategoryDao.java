package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
