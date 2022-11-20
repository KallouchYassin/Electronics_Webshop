package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {
}
