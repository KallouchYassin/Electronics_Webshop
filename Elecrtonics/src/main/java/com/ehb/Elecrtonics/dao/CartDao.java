package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.Cart;
import com.ehb.Elecrtonics.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDao extends CrudRepository<Cart,Integer> {

    List<Cart> findAllByUser(User user);
}
