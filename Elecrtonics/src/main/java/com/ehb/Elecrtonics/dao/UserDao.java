package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {

    User findByEmail(String email);
}
