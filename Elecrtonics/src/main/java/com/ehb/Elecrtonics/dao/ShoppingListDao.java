package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.ShoppingList;
import com.ehb.Elecrtonics.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingListDao extends CrudRepository<ShoppingList,Integer> {

List<ShoppingList> findByUser(User user);
}
